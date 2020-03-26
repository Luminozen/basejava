package com.topjava.basejava.webapp.storage;

import com.topjava.basejava.webapp.model.Resume;

import java.util.HashMap;
import java.util.Map;

public class MapStorage extends AbstractStorage {

    protected Map<String, Resume> storageMap = new HashMap<>();
    private String notExistKey;

    @Override
    protected Object getKey(String uuid) {
        notExistKey = uuid;
        for (Map.Entry<String, Resume> entry : storageMap.entrySet()) {
            Object key = entry.getKey();
            if (key.equals(uuid)) {
                notExistKey = null;
                return key;
            }
        }
        return notExistKey;
    }

    @Override
    protected boolean isExist(Object key) {
        return notExistKey == null;
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
    public Resume[] getAll() {
        return storageMap.values().toArray(new Resume[storageMap.size()]);
    }

    @Override
    public int size() {
        return storageMap.size();
    }
}
