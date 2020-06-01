package com.topjava.basejava.webapp.storage;

import com.topjava.basejava.webapp.storage.serialization.XmlStreamSerializer;

public class XmlStreamPathStorageTest extends AbstractStorageTest {
    public XmlStreamPathStorageTest() {
        super(new PathStorage(STORAGE_DIR.getAbsolutePath(), new XmlStreamSerializer()));
    }
}
