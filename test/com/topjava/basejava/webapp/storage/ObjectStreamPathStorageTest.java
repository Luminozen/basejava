package com.topjava.basejava.webapp.storage;

public class ObjectStreamPathStorageTest extends AbstractStorageTest {

    public ObjectStreamPathStorageTest() {
        super(new ObjectStreamFileStorage(STORAGE_DIR));
    }
}
