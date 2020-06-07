package com.topjava.basejava.webapp.common;

public class MainConcurrency {
    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            deadLock(lock1, lock2, 1);
        });

        Thread thread2 = new Thread(() -> {
            synchronized (lock2) {
                deadLock(lock2, lock1, 2);
            }
        });



        thread1.start();
        thread2.start();
    }

    public static void deadLock(Object lock1, Object lock2, int id) {
        synchronized (lock1) {
                System.out.println(id+": 1");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lock2) {
                    System.out.println(id+": 2");
                }
        }
    }
}
