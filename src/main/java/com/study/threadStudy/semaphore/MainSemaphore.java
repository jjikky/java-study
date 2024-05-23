package com.study.threadStudy.semaphore;

public class MainSemaphore {
    public static void main(String[] args) throws InterruptedException {
        runThreads(new SharedResourceWithCountingSemaphore(3));
        runThreads(new SharedResourceWithBinarySemaphore());
        runThreads(new SharedResourceWithoutSemaphore());
    }

    private static void runThreads(SharedResource sharedResource) throws InterruptedException {
        int MAX_THREADS = 200;
        System.out.println("[실행]"+ sharedResource.getClass().getSimpleName());
        Thread[] threads = new Thread[MAX_THREADS];
        for (int i = 0; i < MAX_THREADS; i++) {
            threads[i] = new Thread(new Worker(sharedResource));
            threads[i].start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
        System.out.println("[완료]"+ sharedResource.getClass().getSimpleName());
        System.out.println();
    }
}