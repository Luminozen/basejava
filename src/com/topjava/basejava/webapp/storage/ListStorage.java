package com.topjava.basejava.webapp.storage;

import com.topjava.basejava.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage<Integer> {

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
    protected boolean isExist(Integer key) {
        return key != null;
    }

    @Override
    protected void doUpdate(Resume resume, Integer key) {
        storageList.set(key, resume);
    }

    @Override
    protected void doSave(Resume resume, Integer key) {
        storageList.add(resume);
    }

    @Override
    protected void doDelete(Integer key) {
        storageList.remove(key.intValue());
    }

    @Override
    protected Resume doGet(Integer key) {
        return storageList.get(key);
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
