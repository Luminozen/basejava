package com.topjava.basejava.webapp.storage;

import com.topjava.basejava.webapp.common.ResumeTestData;
import com.topjava.basejava.webapp.exception.ExistStorageException;
import com.topjava.basejava.webapp.exception.NotExistStorageException;
import com.topjava.basejava.webapp.model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public abstract class AbstractStorageTest {
    protected final static File STORAGE_DIR = new File("C:\\Users\\gosha\\MyGit\\basejava\\files");
    protected Storage storage;

    private final static String UUID_1 = "uuid1";
    private final static Resume RESUME_1 = ResumeTestData.createResume(UUID_1, "Person1");

    private final static String UUID_2 = "uuid2";
    private final static Resume RESUME_2 = ResumeTestData.createResume(UUID_2, "Person2");

    private final static String UUID_3 = "uuid3";
    private final static Resume RESUME_3 = ResumeTestData.createResume(UUID_3, "Person3");

    private final static String UUID_4 = "uuid4";
    private final static Resume RESUME_4 = ResumeTestData.createResume(UUID_4, "Person4");


    public AbstractStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() throws Exception {
        storage.clear();
        storage.save(RESUME_1);
        storage.save(RESUME_2);
        storage.save(RESUME_3);
    }

    @Test
    public void clear() {
        storage.clear();
        assertEquals(0, storage.size());
    }

    @Test
    public void save() {
        storage.save(RESUME_4);
        assertEquals(4, storage.size());
        Assert.assertEquals(RESUME_4, storage.get(UUID_4));
    }

    @Test(expected = ExistStorageException.class)
    public void saveExist() {
        storage.save(RESUME_1);
    }

    @Test
    public void update() {
        Resume resumeTest = new Resume(UUID_2, "new_Person");
        storage.update(resumeTest);
        assertTrue(resumeTest.equals(storage.get(UUID_2)));
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExist() {
        storage.update(RESUME_4);
    }

    @Test(expected = NotExistStorageException.class)
    public void delete() {
        storage.delete(UUID_1);
        Assert.assertEquals(2, storage.size());
        storage.get(UUID_1);
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNotExist() {
        storage.delete(UUID_4);
    }

    @Test
    public void get() {
        Assert.assertEquals(RESUME_1, storage.get(UUID_1));
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() {
        storage.get("dummy");
    }

    @Test
    public void getAllSorted() {
        List <Resume> storageTest = storage.getAllSorted();
        List <Resume> storageEqual = List.of(RESUME_1, RESUME_2, RESUME_3);
        Assert.assertEquals(storageEqual, storageTest);
    }

    @Test
    public void size() {
        Assert.assertEquals(3, storage.size());
    }
}
