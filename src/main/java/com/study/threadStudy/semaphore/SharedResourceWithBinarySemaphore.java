package com.study.threadStudy.semaphore;

import java.util.concurrent.Semaphore;

class SharedResourceWithBinarySemaphore implements SharedResource {
    private int count = 0;
    private final Semaphore semaphore;

    public SharedResourceWithBinarySemaphore() {
        semaphore = new Semaphore(1);
    }

    @Override
    public void increment() {
        try {
            Thread.sleep(10);
            semaphore.acquire();
            count++;
            System.out.println("Thread " + Thread.currentThread().getId() + " incremented count to " + count);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }
}