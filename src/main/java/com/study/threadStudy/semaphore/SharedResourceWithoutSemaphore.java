package com.study.threadStudy.semaphore;

class SharedResourceWithoutSemaphore implements SharedResource {
    private int count = 0;

    @Override
    public void increment() {
        try {
            Thread.sleep(10);
            count++;
            System.out.println("Thread " + Thread.currentThread().getId() + " incremented count to " + count);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
