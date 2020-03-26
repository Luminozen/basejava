package com.topjava.basejava.webapp.storage;

import com.topjava.basejava.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected Integer getKey(String uuid) {
        Resume searchKey = new Resume(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }

    @Override
    protected void insertResume(Resume resume, int index) {
        int posInsert = -index - 1;
        System.arraycopy(storage, posInsert, storage, posInsert + 1, size - posInsert);
        storage[posInsert] = resume;
    }

    @Override
    protected void fillEmptySpace(int index) {
        System.arraycopy(storage, index + 1, storage, index, size - index - 1);
    }

}
