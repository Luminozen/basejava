package com.topjava.basejava.webapp.common;

public class MainConcurrency {
    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            synchronized (lock1) {
                System.out.println("1: 1");
                synchronized (lock2) {
                    System.out.println("1: 2");
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (lock2) {
                System.out.println("2: 2");
                synchronized (lock1) {
                    System.out.println("2: 1");
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}
