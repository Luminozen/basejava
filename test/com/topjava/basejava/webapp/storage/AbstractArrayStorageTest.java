package com.topjava.basejava.webapp.storage;

import com.topjava.basejava.webapp.exception.ExistStorageException;
import com.topjava.basejava.webapp.exception.NotExistStorageException;
import com.topjava.basejava.webapp.exception.StorageException;
import com.topjava.basejava.webapp.model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public abstract class AbstractArrayStorageTest {

    private Storage storage;

    private final static String UUID_1 = "uuid1";
    private final static Resume RESUME_1 = new Resume(UUID_1);

    private final static String UUID_2 = "uuid2";
    private final static Resume RESUME_2 = new Resume(UUID_2);

    private final static String UUID_3 = "uuid3";
    private final static Resume RESUME_3 = new Resume(UUID_3);

    private final static String UUID_4 = "uuid4";
    private final static Resume RESUME_4 = new Resume(UUID_4);

    public AbstractArrayStorageTest(Storage storage) {
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
    }

    @Test
    public void save() {
        storage.save(RESUME_4);
    }

    @Test(expected = ExistStorageException.class)
    public void saveExist() {
        storage.save(RESUME_1);
    }

    /*@Test(expected = ArrayIndexOutOfBoundsException.class)
    public void saveOverflow() throws ArrayIndexOutOfBoundsException {
        try {
            for (int i = 3; i < AbstractArrayStorage.STORAGE_LIMIT; i++) {
                storage.save(new Resume());
            }
        }
        catch (StorageException e) {
            Assert.fail();
        }
        storage.save(new Resume());
    }*/

    @Test
    public void update() {
        Resume RESUME_TEST = new Resume("uuid2");
        storage.update(RESUME_TEST);
        assertSame(RESUME_TEST, storage.get(UUID_2));
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExist() {
        storage.update(RESUME_4);
    }

    @Test
    public void delete() {
        storage.delete(RESUME_1.getUuid());
        Assert.assertEquals(2, storage.size());
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNotExist() {
        storage.delete(RESUME_4.getUuid());
    }

    @Test
    public void get() {
        //storage.get(RESUME_1.getUuid());
        Assert.assertEquals(RESUME_1,storage.get(RESUME_1.getUuid()));
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() {
        storage.get("dummy");
    }

    @Test
    public void getAll() {
        Resume[] STORAGE_TEST = storage.getAll();
        Assert.assertEquals(3, STORAGE_TEST.length);
        Assert.assertEquals(RESUME_1, STORAGE_TEST[0]);
        Assert.assertEquals(RESUME_2, STORAGE_TEST[1]);
        Assert.assertEquals(RESUME_3, STORAGE_TEST[2]);
    }

    @Test
    public void size() {
        Assert.assertEquals(3, storage.size());
    }
}