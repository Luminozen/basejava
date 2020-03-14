package com.topjava.basejava.webapp.storage;

import com.topjava.basejava.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void update(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index == -1) {
            System.out.println("Resume with uuid " + resume.getUuid() + " not exist");
        } else {
            storage[index] = resume;
        }
    }

    public void save(Resume resume) {
        if (size >= STORAGE_LIMIT) {
            System.out.println("Storage is full");
        } else if (getIndex(resume.getUuid()) != -1) {
            System.out.println("Resume with uuid " + resume.getUuid() + " already exist");
        } else {
            storage[size] = resume;
            size++;
        }
    }



    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index == -1) {
            System.out.println("Resume with uuid " + uuid + " not exist");
        } else {
            storage[index] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    protected int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid()))
                return i;
        }
        return -1;
    }
}
