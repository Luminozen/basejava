package com.topjava.basejava.webapp.storage;

import com.topjava.basejava.webapp.model.Resume;

import java.util.*;

public class MapStorage extends AbstractStorage {

    protected Map<String, Resume> storageMap = new TreeMap<>(String::compareTo);
    private String notExistKey;

    @Override
    protected String getKey(String uuid) {
        return uuid;
    }

    @Override
    protected boolean isExist(Object key) {
        return storageMap.containsKey(key);
    }

    @Override
    protected void doUpdate(Resume resume, Object key) {
        storageMap.replace((String) key, resume);
    }

    @Override
    protected void doSave(Resume resume, Object key) {
        storageMap.put((String) key, resume);
    }

    @Override
    protected void doDelete(Object key) {
        storageMap.remove(key);
    }

    @Override
    protected Resume doGet(Object key) {
        return storageMap.get(key);
    }

    @Override
    public void clear() {
        storageMap.clear();
    }

    @Override
    public int size() {
        return storageMap.size();
    }

    @Override
    protected List<Resume> doCopyStorage() {
        return new ArrayList<>(storageMap.values());
    }
}
