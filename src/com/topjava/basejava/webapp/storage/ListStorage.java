package com.topjava.basejava.webapp.storage;

import com.topjava.basejava.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {

    protected List<Resume> storageList = new ArrayList<>();

    @Override
    protected Integer getKey(String uuid) {
        for (int i = 0; i < storageList.size(); i++) {
            if (storageList.get(i).getUuid().equals(uuid)) {
                return i;
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
        storageList.set((Integer) key, resume);
    }

    @Override
    protected void doSave(Resume resume, Object key) {
        storageList.add(resume);
    }

    @Override
    protected void doDelete(Object key) {
        storageList.remove(((Integer) key).intValue());
    }

    @Override
    protected Resume doGet(Object key) {
        return storageList.get((Integer) key);
    }

    @Override
    protected List<Resume> doCopyStorage() {
        return new ArrayList<>(storageList);
    }

    @Override
    public void clear() {
        storageList.clear();
    }

    @Override
    public int size() {
        return storageList.size();
    }
}
