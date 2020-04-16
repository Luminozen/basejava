package com.topjava.basejava.webapp.storage;

import com.topjava.basejava.webapp.exception.ExistStorageException;
import com.topjava.basejava.webapp.exception.NotExistStorageException;
import com.topjava.basejava.webapp.model.Resume;

import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

public abstract class AbstractStorage<SK> implements Storage {
    private static final Logger LOG = Logger.getLogger(AbstractStorage.class.getName());

    protected abstract SK getKey(String uuid);

    protected abstract boolean isExist(SK uuid);

    protected abstract void doUpdate(Resume resume, SK key);

    protected abstract void doSave(Resume resume, SK key);

    protected abstract void doDelete(SK key);

    protected abstract Resume doGet(SK key);

    protected abstract List<Resume> doCopyStorage();
    @Override
    public void update(Resume resume) {
        LOG.info("Update " + resume);
        SK key = getExist(resume.getUuid());
        doUpdate(resume, key);
    }

    @Override
    public void save(Resume resume) {
        LOG.info("Save " + resume);
        SK key = getNotExist(resume.getUuid());
        doSave(resume,key);
    }

    @Override
    public Resume get(String uuid) {
        LOG.info("Get " + uuid);
        SK key = getExist(uuid);
        return doGet(key);
    }

    @Override
    public void delete(String uuid) {
        LOG.info("Delete " + uuid);
        SK key = getExist(uuid);
        doDelete(key);
    }

    private SK getExist(String uuid) {
        SK key =  getKey(uuid);
        if (!isExist(key)) {
            LOG.warning("Resume " + uuid + " not exist");
            throw new NotExistStorageException(uuid);
        }
        return key;
    }

    private SK getNotExist(String uuid) {
        SK key =  getKey(uuid);
        if (isExist(key)) {
            LOG.warning("Resume " + uuid + " already exist");
            throw new ExistStorageException(uuid);
        }
        return key;
    }

    @Override
    public List<Resume> getAllSorted(){
        LOG.info("getAllSorted");
        List<Resume> copyStorage = doCopyStorage();
        Collections.sort(copyStorage);
        return copyStorage;
    }

}
