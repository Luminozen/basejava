package com.topjava.basejava.webapp.storage;

import com.topjava.basejava.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MapResumeStorage extends AbstractStorage<Resume> {
    private Map<String, Resume> storageMap = new TreeMap<>(String::compareTo);

    @Override
    protected Resume getKey(String uuid) {
        return storageMap.get(uuid);
    }

    @Override
    protected boolean isExist(Resume resumeSK) {
        return resumeSK != null;
    }

    @Override
    protected void doUpdate(Resume resume, Resume resumeSK) {
        storageMap.replace(resumeSK.getUuid(), resume);
    }

    @Override
    protected void doSave(Resume resume, Resume resumeSK) {
        storageMap.put(resume.getUuid(), resume);
    }

    @Override
    protected void doDelete(Resume resumeSK) {
        storageMap.remove(resumeSK.getUuid());
    }

    @Override
    protected Resume doGet(Resume resumeSK) {
        return resumeSK;
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
