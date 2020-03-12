package com.topjava.basejava.webapp.storage;

import com.topjava.basejava.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    private int size = 0;
    private int uuidPointer = 0;

    public void clear() {
        Arrays.fill(storage, null);
        size = 0;
    }

    public void update(Resume r) {
        if (isContain(r.getUuid())) {
            storage[uuidPointer] = r;
        }
    }

    public void save(Resume r) {
        if (storage[storage.length-1] == null) {
            if (isContain(r.getUuid())) {
                System.out.println("Storage already contain this resume" + r.getUuid());
            } else {
                storage[size()] = r;
                size++;
            }
        } else {
            System.out.println("Storage is full");
        }
    }

    public Resume get(String uuid) {
        if (isContain(uuid)) {
            return storage[uuidPointer];
        } else {
            System.out.println("Storage dont contain this resume" + uuid);
            return null;
        }
    }

    public void delete(String uuid) {
        if (isContain(uuid)) {
            for (int j = uuidPointer; j < size - 1; j++) {
                storage[j] = storage[j + 1];
            }
            storage[size - 1] = null;
            size--;
        } else {
            System.out.println("Storage dont contain this resume" + uuid);
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        Resume[] resumes = Arrays.copyOf(storage, size);
        return resumes;
    }

    public int size() {
        return size;
    }

    boolean isContain(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                uuidPointer = i;
                return true;
            }
        }
        return false;
    }
}
