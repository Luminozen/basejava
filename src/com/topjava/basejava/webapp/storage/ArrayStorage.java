package com.topjava.basejava.webapp.storage;

import com.topjava.basejava.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage implements Storage {
    private static final int STORAGE_LIMIT = 10_000;
    private Resume[] storage = new Resume[STORAGE_LIMIT];
    private int size = 0;
    private int uuidPointer = 0;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void update(Resume resume) {
        if (isContain(resume.getUuid())) {
            storage[uuidPointer] = resume;
            return;
        }
        System.out.println("Storage dont contain this resume " + resume.getUuid());
    }

    public void save(Resume resume) {
        if (storage[storage.length - 1] == null) {
            if (isContain(resume.getUuid())) {
                System.out.println("Storage already contain this resume " + resume.getUuid());
            } else {
                storage[size] = resume;
                size++;
            }
        } else {
            System.out.println("Storage is full");
        }
    }

    public Resume get(String uuid) {
        if (isContain(uuid)) {
            return storage[uuidPointer];
        }
        System.out.println("Storage dont contain this resume " + uuid);
        return null;
    }

    public void delete(String uuid) {
        if (isContain(uuid)) {
            if (size - 1 - uuidPointer >= 0)
                System.arraycopy(storage, uuidPointer + 1, storage, uuidPointer, size - 1 - uuidPointer);
            storage[size - 1] = null;
            size--;
        } else {
            System.out.println("Storage dont contain this resume " + uuid);
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public int size() {
        return size;
    }

    private boolean isContain(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                uuidPointer = i;
                return true;
            }
        }
        return false;
    }
}
