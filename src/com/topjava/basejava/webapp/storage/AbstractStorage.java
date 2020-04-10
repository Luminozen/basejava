package com.topjava.basejava.webapp.storage;

import com.topjava.basejava.webapp.exception.ExistStorageException;
import com.topjava.basejava.webapp.exception.NotExistStorageException;
import com.topjava.basejava.webapp.model.Resume;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public abstract class AbstractStorage implements Storage {

    protected abstract Object getKey(String uuid);

    protected abstract boolean isExist(Object uuid);

    protected abstract void doUpdate(Resume resume, Object key);

    protected abstract void doSave(Resume resume, Object key);

    protected abstract void doDelete(Object key);

    protected abstract Resume doGet(Object key);

    protected abstract List<Resume> doCopyStorage();
    @Override
    public void update(Resume resume) {
        Object key = getExist(resume.getUuid());
        doUpdate(resume, key);
    }

    @Override
    public void save(Resume resume) {
        Object key = getNotExist(resume.getUuid());
        doSave(resume,key);
    }

    @Override
    public Resume get(String uuid) {
        Object key = getExist(uuid);
        return doGet(key);
    }

    @Override
    public void delete(String uuid) {
        Object key = getExist(uuid);
        doDelete(key);
    }

    private Object getExist(String uuid) {
        Object key =  getKey(uuid);
        if (!isExist(key)) {
            throw new NotExistStorageException(uuid);
        }
        return key;
    }

    private Object getNotExist(String uuid) {
        Object key =  getKey(uuid);
        if (isExist(key)) {
            throw new ExistStorageException(uuid);
        }
        return key;
    }

    @Override
    public List<Resume> getAllSorted(){
        List<Resume> copyStorage = doCopyStorage();
        Collections.sort(copyStorage);
        return copyStorage;
    }

}
