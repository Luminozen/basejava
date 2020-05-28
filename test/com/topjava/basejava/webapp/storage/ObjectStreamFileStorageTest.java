package com.topjava.basejava.webapp.storage;

import com.topjava.basejava.webapp.storage.serialization.ObjectStreamSerializaton;

public class ObjectStreamFileStorageTest extends AbstractStorageTest {

    public ObjectStreamFileStorageTest() {
        super(new FileStorage(STORAGE_DIR, new ObjectStreamSerializaton()));
    }
}
