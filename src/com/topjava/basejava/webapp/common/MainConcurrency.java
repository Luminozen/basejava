package com.topjava.basejava.webapp.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MainConcurrency {
    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();
    private static final Lock lock = new ReentrantLock();
    private int counter = 0;

    public static void main(String[] args) throws InterruptedException {

        final MainConcurrency mainConcurrency = new MainConcurrency();
        CountDownLatch latch = new CountDownLatch(10000);
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        for (int i = 0; i < 10000; i++) {
            executorService.submit(() ->
            {
                for (int j = 0; j < 100; j++) {
                    mainConcurrency.inc();
                }
                latch.countDown();
            });
        }
        latch.await(20, TimeUnit.SECONDS);
        executorService.shutdown();
        System.out.println(mainConcurrency.counter);

        /*Thread thread1 = new Thread(() -> {
            deadLock(lock1, lock2, 1);
        });

        Thread thread2 = new Thread(() -> {
            synchronized (lock2) {
                deadLock(lock2, lock1, 2);
            }
        });



        thread1.start();
        thread2.start();*/
    }

    public static void deadLock(Object lock1, Object lock2, int id) {
        synchronized (lock1) {
            System.out.println(id + ": 1");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lock2) {
                System.out.println(id + ": 2");
            }
        }
    }

    public void inc() {
        lock.lock();
        counter++;
        lock.unlock();
    }



}
