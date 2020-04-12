package com.topjava.basejava.webapp.storage;

import com.topjava.basejava.webapp.exception.ExistStorageException;
import com.topjava.basejava.webapp.exception.NotExistStorageException;
import com.topjava.basejava.webapp.exception.StorageException;
import com.topjava.basejava.webapp.model.Resume;
import com.topjava.basejava.webapp.storage.AbstractStorage;
import com.topjava.basejava.webapp.storage.Storage;

import java.util.Arrays;
import java.util.List;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage extends AbstractStorage {
    protected static final int STORAGE_LIMIT = 10_000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    @Override
    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    protected boolean isExist(Object index) {
        return (int) index >= 0;
    }

    @Override
    protected void doUpdate(Resume resume, Object index) {
        storage[(int) index] = resume;
    }

    @Override
    protected void doSave(Resume resume, Object key) {
        int index = (Integer) key;
        if (size >= STORAGE_LIMIT) {
            throw new StorageException("Storage overflow", resume.getUuid());
        }
        insertResume(resume, index);
        size++;
    }

    @Override
    protected Resume doGet(Object index) {
        return storage[(int) index];
    }

    @Override
    protected void doDelete(Object index) {
        fillEmptySpace((int) index);
        storage[size - 1] = null;
        size--;
    }

    @Override
    protected List<Resume> doCopyStorage(){
        return Arrays.asList(Arrays.copyOfRange(storage,0, size));
    }

    protected abstract Integer getKey(String uuid);

    protected abstract void insertResume(Resume resume, int index);

    protected abstract void fillEmptySpace(int index);
}
