package com.topjava.basejava.webapp.storage.serialization;

import com.topjava.basejava.webapp.model.*;
import com.topjava.basejava.webapp.util.XmlParser;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class XmlStreamSerializer implements StreamSerializer {
    XmlParser xmlParser;

    public XmlStreamSerializer(){
        xmlParser = new XmlParser(Resume.class, Link.class, Organization.class,
                ListSection.class, TextSection.class, OrganisationSection.class, Organization.Position.class);
    }
    @Override
    public void doWrite(Resume resume, OutputStream os) throws IOException {
        try(Writer writer = new OutputStreamWriter(os, StandardCharsets.UTF_8)){
            xmlParser.marshall(resume, writer);
        }
    }

    @Override
    public Resume doRead(InputStream is) throws IOException {
        try(Reader reader = new InputStreamReader(is, StandardCharsets.UTF_8)){
            return xmlParser.unmarshall(reader);
        }
    }
}
