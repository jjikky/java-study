package com.study.threadStudy.semaphore;

import java.util.concurrent.Semaphore;

class SharedResourceWithCountingSemaphore implements SharedResource {
    private int count = 0;
    private Semaphore semaphore;

    public SharedResourceWithCountingSemaphore(int permits) {
        semaphore = new Semaphore(permits);
    }

    public void increment() {
        try {
            Thread.sleep(10);
            semaphore.acquire();
            count++;
            System.out.println("Thread " + Thread.currentThread().getId() + "카운트 증가 됨: " + count);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }
}