package com.topjava.basejava.webapp.storage;

import com.topjava.basejava.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {

    protected List<Resume> StorageList = new ArrayList<>();

    @Override
    protected Object getKey(String uuid) {
        for (Resume resume : StorageList) {
            if (resume.getUuid().equals(uuid)) {
                return StorageList.indexOf(resume);
            }
        }
        return null;
    }

    @Override
    protected boolean isExist(Object key) {
        return key != null;
    }

    @Override
    protected void doUpdate(Resume resume, Object key) {
        StorageList.set((Integer) key, resume);
    }

    @Override
    protected void doSave(Resume resume, Object key) {
        StorageList.add(resume);
    }

    @Override
    protected void doDelete(Object key) {
        StorageList.remove(((Integer) key).intValue());
    }

    @Override
    protected Resume doGet(Object key) {
        return StorageList.get((Integer) key);
    }

    @Override
    public void clear() {
        StorageList.clear();
    }

    @Override
    public Resume[] getAll() {
        return StorageList.toArray(new Resume[StorageList.size()]);
    }

    @Override
    public int size() {
        return StorageList.size();
    }
}
