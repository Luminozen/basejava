package com.topjava.basejava.webapp.storage.serialization;

import com.topjava.basejava.webapp.model.ContactsType;
import com.topjava.basejava.webapp.model.Resume;

import java.io.*;
import java.util.Map;

public class DataStreamSerializer implements StreamSerializer {
    @Override
    public void doWrite(Resume resume, OutputStream os) throws IOException {
        try(DataOutputStream dos = new DataOutputStream(os)) {
            Map<ContactsType, String> contacts = resume.getContacts();
            dos.writeUTF(resume.getUuid());
            dos.writeUTF(resume.getFullName());
            dos.writeInt(contacts.size());
            for(Map.Entry<ContactsType, String> entry:contacts.entrySet()) {
                dos.writeUTF(entry.getKey().name());
                dos.writeUTF(entry.getValue());
            }
        }
    }

    @Override
    public Resume doRead(InputStream is) throws IOException {
        try(DataInputStream dis = new DataInputStream(is)){
            Resume resume = new Resume(dis.readUTF(), dis.readUTF());
            int sizeContacts = dis.readInt();
            for(int i = 0; i < sizeContacts; i++) {
                resume.addContact(ContactsType.valueOf(dis.readUTF()), dis.readUTF());
            }
            return null;
        }
    }
}
