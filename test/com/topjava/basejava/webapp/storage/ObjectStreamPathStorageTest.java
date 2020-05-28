package com.topjava.basejava.webapp.storage;

import com.topjava.basejava.webapp.storage.serialization.ObjectStreamSerializaton;

public class ObjectStreamPathStorageTest extends AbstractStorageTest {

    public ObjectStreamPathStorageTest() {
        super(new PathStorage(STORAGE_DIR.getAbsolutePath(), new ObjectStreamSerializaton()));
    }
}
