package com.topjava.basejava.webapp.storage;

import com.topjava.basejava.webapp.model.Resume;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Array based storage for Resumes
 */
public class SortedArrayStorage extends AbstractArrayStorage {

    private final static Comparator<Resume> RESUME_COMPARATOR = Comparator.comparing(Resume::getUuid);

    @Override
    protected Integer getKey(String uuid) {
        Resume searchKey = new Resume(uuid, "Person");
        return Arrays.binarySearch(storage, 0, size, searchKey, RESUME_COMPARATOR);
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
