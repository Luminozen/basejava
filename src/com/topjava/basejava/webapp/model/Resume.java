package com.topjava.basejava.webapp.model;

import java.util.*;

import static java.util.UUID.randomUUID;

/**
 * Initial resume class
 */
public class Resume implements Comparable<Resume> {

    // Unique identifier
    private final String uuid;
    private final String fullName;

    private final Map <ContactsType, String> contacts = new EnumMap<>(ContactsType.class);
    private final Map <SectionType, Section> sections = new EnumMap<>(SectionType.class);

    public Resume(String fullName) {
        this(UUID.randomUUID().toString(), fullName);
    }

    public Resume(String uuid, String fullName) {
        Objects.requireNonNull(uuid, "uuid must not be null");
        Objects.requireNonNull(fullName, "fullname must not be null");
        this.uuid = uuid;
        this.fullName = fullName;
    }


    public String getUuid() {
        return uuid;
    }

    public void setContact(ContactsType type, String value) {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Resume resume = (Resume) o;

        if (!uuid.equals(resume.uuid)) return false;
        return fullName.equals(resume.fullName);
    }

    @Override
    public int hashCode() {
        int result = uuid.hashCode();
        result = 31 * result + fullName.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return uuid + '(' + fullName + ')';
    }

    @Override
    public int compareTo(Resume resume) {
        int cmpResult = fullName.compareTo(resume.fullName);
        return cmpResult != 0 ? cmpResult : uuid.compareTo(resume.uuid);
    }
}
