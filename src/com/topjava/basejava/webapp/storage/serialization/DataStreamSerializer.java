package com.topjava.basejava.webapp.storage.serialization;
import com.topjava.basejava.webapp.model.*;
import java.io.*;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Collection;
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

            writeCollection(dos, contacts.entrySet(), entry -> {
                dos.writeUTF(entry.getKey().name());
                dos.writeUTF(entry.getValue());
            });

            writeCollection(dos, sections.entrySet(), entry -> {
                SectionType type = entry.getKey();
                switch (type) {
                    case PERSONAL:
                    case OBJECTIVE:
                        dos.writeUTF(entry.getKey().name());
                        dos.writeUTF(((TextSection) entry.getValue()).getContent());
                        break;
                    case ACHIEVEMENT:
                    case QUALIFICATIONS:
                        dos.writeUTF(entry.getKey().name());
                        writeCollection(dos, ((ListSection) entry.getValue()).getContent(), dos::writeUTF);
                        break;
                    case EXPERIENCE:
                    case EDUCATION:
                        dos.writeUTF(entry.getKey().name());
                        writeCollection(dos, ((OrganisationSection) entry.getValue()).getOrganizations(), item -> {
                            dos.writeUTF(item.getHomePage().getTitle());
                            dos.writeUTF(item.getHomePage().getUrl());
                            writeCollection(dos, item.getPositions(), position -> {
                                dos.writeUTF(position.getPosition());
                                dos.writeUTF(position.getStartDate().toString());
                                dos.writeUTF(position.getEndDate().toString());
                                dos.writeUTF(position.getDescription());
                            });
                        });
                }
            });
        }
    }

    @Override
    public Resume doRead(InputStream is) throws IOException {
        try (DataInputStream dis = new DataInputStream(is)) {
            Resume resume = new Resume(dis.readUTF(), dis.readUTF());
            readItems(dis, () -> resume.addContact(ContactsType.valueOf(dis.readUTF()), dis.readUTF()));
            readItems(dis, () -> {
                SectionType type = SectionType.valueOf(dis.readUTF());
                resume.addSection(type, readSection(dis, type));
            });
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
                return new ListSection(readList(dis, dis::readUTF));
            case EXPERIENCE:
            case EDUCATION:
                return new OrganisationSection(readList(dis, ()->new Organization(
                        new Link(dis.readUTF(), dis.readUTF()), readList(dis, ()->new Organization.Position(
                                dis.readUTF(), YearMonth.parse(dis.readUTF()), YearMonth.parse(dis.readUTF()), dis.readUTF()
                        )))
                ));
        }
        return null;
    }

    private interface ElementWriter<T> {
        void write(T t) throws IOException;
    }

    private interface ElementProcessor {
        void process() throws IOException;
    }

    private interface ElementReader<T> {
        T read() throws IOException;
    }

    private <T> void writeCollection(DataOutputStream dos, Collection<T> collection, ElementWriter<T> writer) throws IOException {
        dos.writeInt(collection.size());
        for (T item : collection) {
            writer.write(item);
        }
    }

    private void readItems(DataInputStream dis, ElementProcessor processor) throws IOException {
        int size = dis.readInt();
        for (int i = 0; i < size; i++) {
            processor.process();
        }
    }

    private <T> List<T> readList(DataInputStream dis, ElementReader<T> reader) throws IOException {
        int size = dis.readInt();
        List<T> list = new ArrayList<>();
        for (int i = 0; i < size; i++){
            list.add(reader.read());
        }
        return list;
    }
}
