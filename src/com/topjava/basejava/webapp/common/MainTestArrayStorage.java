package com.topjava.basejava.webapp.common;

import com.topjava.basejava.webapp.model.Resume;
import com.topjava.basejava.webapp.storage.ArrayStorage;
import com.topjava.basejava.webapp.storage.SortedArrayStorage;

/**
 * Test for your com.topjava.basejava.webapp.storage.ArrayStorage implementation
 */
/*public class MainTestArrayStorage {
    static final ArrayStorage ARRAY_STORAGE = new ArrayStorage();
    static final SortedArrayStorage SORTED_ARRAY_STORAGE = new SortedArrayStorage();

    public static void main(String[] args) {
        Resume r1 = new Resume("uuid1");
        Resume r2 = new Resume("uuid2");
        Resume r3 = new Resume("uuid3");
        Resume r4 = new Resume("uuid4");
        Resume r5 = new Resume("uuid5");

        /*SORTED_ARRAY_STORAGE.save(r1);
        SORTED_ARRAY_STORAGE.save(r5);
        SORTED_ARRAY_STORAGE.save(r4);
        SORTED_ARRAY_STORAGE.save(r3);
        SORTED_ARRAY_STORAGE.save(r2);
        printAll();

        SORTED_ARRAY_STORAGE.delete(r2.getUuid());
        printAll();
        SORTED_ARRAY_STORAGE.delete(r4.getUuid());
        printAll();
        SORTED_ARRAY_STORAGE.delete(r5.getUuid());
        printAll();
        SORTED_ARRAY_STORAGE.delete(r1.getUuid());
        printAll();*/

        /*ARRAY_STORAGE.save(r1);
        ARRAY_STORAGE.save(r2);
        ARRAY_STORAGE.save(r3);
        printAll();
        //ARRAY_STORAGE.save(r1);

        System.out.println("Get r1: " + ARRAY_STORAGE.get(r1.getUuid()));*/

        //Test update resume
        /*System.out.println("Before update");
        printAll();
        System.out.println("After update");
        r1.setUuid("uuid10");
        ARRAY_STORAGE.update(r1);
        printAll();
        ///////////////////////

        System.out.println("Size: " + ARRAY_STORAGE.size());

        //System.out.println("Get dummy: " + ARRAY_STORAGE.get("dummy"));

        printAll();
        ARRAY_STORAGE.delete(r1.getUuid());
        //ARRAY_STORAGE.delete(r4.getUuid());
        printAll();
        ARRAY_STORAGE.clear();
        printAll();

        System.out.println("Size: " + ARRAY_STORAGE.size());
    }

    static void printAll() {
        System.out.println("\nGet All");
        for (Resume r : ARRAY_STORAGE.getAll()) {
            System.out.println(r);
        }
    }
}*/
