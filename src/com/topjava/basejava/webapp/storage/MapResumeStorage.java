package com.topjava.basejava.webapp.storage;

import com.topjava.basejava.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MapResumeStorage extends AbstractStorage {
    private Map<String, Resume> storageMap = new TreeMap<>(String::compareTo);

    @Override
    protected Object getKey(String uuid) {
        return storageMap.get(uuid);
    }

    @Override
    protected boolean isExist(Object resumeSK) {
        return storageMap.containsValue(resumeSK);
    }

    @Override
    protected void doUpdate(Resume resume, Object resumeSK) {
        storageMap.replace(((Resume)resumeSK).getUuid(), resume);
    }

    @Override
    protected void doSave(Resume resume, Object resumeSK) {
        storageMap.put(((Resume)resumeSK).getUuid(), resume);
    }

    @Override
    protected void doDelete(Object resumeSK) {
        storageMap.remove(((Resume)resumeSK).getUuid());
    }

    @Override
    protected Resume doGet(Object resumeSK) {
        return storageMap.get(((Resume)resumeSK).getUuid());
    }

    @Override
    protected List<Resume> doCopyStorage() {
        return new ArrayList<>(storageMap.values());
    }

    @Override
    public void clear() {
        storageMap.clear();
    }

    @Override
    public int size() {
        return storageMap.size();
    }
}
