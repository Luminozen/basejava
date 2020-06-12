package com.topjava.basejava.webapp.storage.serialization;

import com.topjava.basejava.webapp.model.*;

import java.io.*;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DataStreamSerializer implements StreamSerializer {
    @Override
    public void doWrite(Resume resume, OutputStream os) throws IOException {
        try (DataOutputStream dos = new DataOutputStream(os)) {
            Map<ContactsType, String> contacts = resume.getContacts();
            Map<SectionType, AbstractSection> sections = resume.getSections();

            dos.writeUTF(resume.getUuid());
            dos.writeUTF(resume.getFullName());
            dos.writeInt(contacts.size());
            for (Map.Entry<ContactsType, String> entry : contacts.entrySet()) {
                dos.writeUTF(entry.getKey().name());
                dos.writeUTF(entry.getValue());
            }

            dos.writeInt(sections.size());
            for (Map.Entry<SectionType, AbstractSection> entry : sections.entrySet()) {
                SectionType type = entry.getKey();
                switch (type) {
                    case PERSONAL:
                    case OBJECTIVE:
                        dos.writeUTF(entry.getKey().name());
                        dos.writeUTF(((TextSection) entry.getValue()).getContent());
                        break;
                    case ACHIEVEMENT:
                    case QUALIFICATIONS:
                        List<String> items = ((ListSection) entry.getValue()).getContent();
                        dos.writeUTF(entry.getKey().name());
                        dos.writeInt(items.size());
                        for (String item : items) {
                            dos.writeUTF(item);
                        }
                        break;
                    case EXPERIENCE:
                    case EDUCATION:
                        List<Organization> organizations = ((OrganisationSection) entry.getValue()).getOrganizations();
                        dos.writeUTF(entry.getKey().name());
                        dos.writeInt(organizations.size());
                        writeOrganizations(dos, organizations);
                        break;
                }
            }
        }
    }

    @Override
    public Resume doRead(InputStream is) throws IOException {
        try (DataInputStream dis = new DataInputStream(is)) {
            Resume resume = new Resume(dis.readUTF(), dis.readUTF());
            int size = dis.readInt();
            SectionType type;
            for (int i = 0; i < size; i++) {
                resume.addContact(ContactsType.valueOf(dis.readUTF()), dis.readUTF());
            }

            size = dis.readInt();
            for (int i = 0; i < size; i++) {
                type = SectionType.valueOf(dis.readUTF());
                resume.addSection(type, readSection(dis, type));
            }

            return resume;
        }
    }

    public AbstractSection readSection(DataInputStream dis, SectionType type) throws IOException {
        switch (type) {
            case PERSONAL:
            case OBJECTIVE:
                return new TextSection(dis.readUTF());
            case QUALIFICATIONS:
            case ACHIEVEMENT:
                return new ListSection(readList(dis, dis.readInt()));
            case EXPERIENCE:
            case EDUCATION:
                return new OrganisationSection(readOrganizations(dis, dis.readInt()));
        }
        return null;
    }

    public List<String> readList(DataInputStream dis, int size) throws IOException {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(dis.readUTF());
        }
        return list;
    }

    public void writeOrganizations(DataOutputStream dos, List<Organization> list) throws IOException {
        List<Organization.Position> positions;
        Link homePage;
        for (Organization item : list) {
            positions = item.getPositions();
            homePage = item.getHomePage();
            dos.writeUTF(homePage.getTitle());
            dos.writeUTF(homePage.getUrl());
            dos.writeInt(positions.size());
            for(Organization.Position position: positions) {
                dos.writeUTF(position.getPosition());
                dos.writeUTF(position.getStartDate().toString());
                dos.writeUTF(position.getEndDate().toString());
                dos.writeUTF(position.getDescription());
            }
        }
    }

    public List<Organization> readOrganizations(DataInputStream dis, int size) throws IOException {
        List<Organization> organizations = new ArrayList<>();
        for(int i = 0; i < size; i++) {
            Link homePage = new Link(dis.readUTF(), dis.readUTF());
            organizations.add(new Organization(homePage, readPositions(dis, dis.readInt())));
        }
        return organizations;
    }

    public List<Organization.Position> readPositions(DataInputStream dis, int size) throws IOException {
        List<Organization.Position> positions = new ArrayList<>();
        for(int i = 0; i < size; i++) {
            positions.add(new Organization.Position(dis.readUTF(), YearMonth.parse(dis.readUTF()), YearMonth.parse(dis.readUTF()), dis.readUTF()));
        }
        return  positions;
    }
}
