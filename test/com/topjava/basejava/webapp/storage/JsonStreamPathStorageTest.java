package com.topjava.basejava.webapp.storage;

import com.topjava.basejava.webapp.storage.serialization.JsonStreamSerializer;

public class JsonStreamPathStorageTest extends AbstractStorageTest {
    public JsonStreamPathStorageTest() {
        super(new PathStorage(STORAGE_DIR.getAbsolutePath(), new JsonStreamSerializer()));
    }
}
