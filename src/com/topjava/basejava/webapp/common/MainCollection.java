package com.topjava.basejava.webapp.common;

import com.topjava.basejava.webapp.model.Resume;
import com.topjava.basejava.webapp.storage.ListStorage;
import com.topjava.basejava.webapp.storage.MapStorage;

import java.util.*;

public class MainCollection {
    private final static String UUID_1 = "uuid1";
    private final static Resume RESUME_1 = new Resume(UUID_1);

    private final static String UUID_2 = "uuid2";
    private final static Resume RESUME_2 = new Resume(UUID_2);

    private final static String UUID_3 = "uuid3";
    private final static Resume RESUME_3 = new Resume(UUID_3);

    private final static String UUID_4 = "uuid4";
    private final static Resume RESUME_4 = new Resume(UUID_4);



    public static void main(String[] args) {

        Collection<Resume> collection = new ArrayList<>();
        Map<String, Resume> map = new HashMap<>();

        collection.add(RESUME_1);
        collection.add(RESUME_2);
        collection.add(RESUME_3);
        collection.add(RESUME_4);

        Iterator<Resume> iterator = collection.iterator();

        while (iterator.hasNext()) {
            Resume resume = iterator.next();
            System.out.println(resume);
            if (Objects.equals(resume.getUuid(), UUID_1)) {
                iterator.remove();
            }
        }

        System.out.println(collection.toString());

        map.put(UUID_1, RESUME_1);
        map.put(UUID_2, RESUME_2);
        map.put(UUID_3, RESUME_3);
        map.put(UUID_4, RESUME_4);

        map.remove(UUID_1);

        for (Map.Entry<String, Resume> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue().hashCode());
        }
    }

    public static void printAll(MapStorage LIST_STORAGE) {
        System.out.println("\nGet All");
        for (Resume r : LIST_STORAGE.getAllSorted()) {
            System.out.println(r);
        }
    }
}
