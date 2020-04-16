package com.topjava.basejava.webapp.storage;

import com.topjava.basejava.webapp.model.Resume;

import java.util.*;

public class MapStorage extends AbstractStorage<String> {

    protected Map<String, Resume> storageMap = new TreeMap<>(String::compareTo);

    @Override
    protected String getKey(String uuid) {
        return uuid;
    }

    @Override
    protected boolean isExist(String uuid) {
        return storageMap.containsKey(uuid);
    }

    @Override
    protected void doUpdate(Resume resume, String uuid) {
        storageMap.replace(uuid, resume);
    }

    @Override
    protected void doSave(Resume resume, String uuid) {
        storageMap.put(uuid, resume);
    }

    @Override
    protected void doDelete(String uuid) {
        storageMap.remove(uuid);
    }

    @Override
    protected Resume doGet(String uuid) {
        return storageMap.get(uuid);
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
