package com.topjava.basejava.webapp.storage;

import com.topjava.basejava.webapp.exception.StorageException;
import com.topjava.basejava.webapp.model.Resume;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class AbstractFileStorage extends AbstractStorage<File> {
    private File directory;

    protected abstract void doWrite(Resume resume, File file) throws IOException;

    protected abstract Resume doRead(File file) throws IOException;

    protected AbstractFileStorage(File directory) {
        Objects.requireNonNull(directory, "directory must not be null");
        if (!directory.isDirectory()) {
            throw new IllegalArgumentException(directory.getAbsolutePath() + "is not directory");
        }
        if (!directory.canRead() || !directory.canWrite()) {
            throw new IllegalArgumentException(directory.getAbsolutePath() + "is not readable/writable");
        } else {
            this.directory = directory;
        }
    }

    @Override
    protected File getKey(String filename) {
        return new File(directory, filename);
    }

    @Override
    protected boolean isExist(File file) {
        return file.exists();
    }

    @Override
    protected void doUpdate(Resume resume, File file) {
        try {
            doWrite(resume, file);
        } catch (IOException e) {
            throw new StorageException("File write error", resume.getUuid(), e);
        }
    }

    @Override
    protected void doSave(Resume resume, File file) {
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new StorageException("Create file error", file.getName(), e);
        }
        doUpdate(resume, file);
    }

    @Override
    protected void doDelete(File file) {
        if (!file.delete()) {
            throw new StorageException("File delete error", file.getName());
        }
    }

    @Override
    protected Resume doGet(File file) {
        try {
            return doRead(file);
        } catch (IOException e) {
            throw new StorageException("File read error", file.getName());
        }
    }

    @Override
    protected List<Resume> doCopyStorage() {
        File[] dirFiles = directory.listFiles();
        if(dirFiles==null){
            throw new StorageException("Directory read error", directory.getName());
        }
        List<Resume> list = new ArrayList<>(dirFiles.length);
        for(File file:dirFiles){
            list.add(doGet(file));
        }
        return list;
    }

    @Override
    public void clear() {
        File[] dirFiles = directory.listFiles();
        if(dirFiles==null) {
            throw new StorageException("Directory read error", directory.getName());
        }
        for (File file : dirFiles) {
            file.delete();
        }
    }

    @Override
    public int size() {
        File[] dirFiles = directory.listFiles();
        if(dirFiles==null) {
            throw new StorageException("Directory read error", directory.getName());
        }
        return dirFiles.length;
    }
}
