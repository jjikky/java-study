package com.study.threadStudy.raceCondition;

public class RaceConditionExample {
    private static int counter = 0;
    private static final Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000000; i++) {
                incrementCounter();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000000; i++) {
                incrementCounter();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("최종 counter 값: " + counter);
    }

    private static void incrementCounter() {
        counter++;
    }
}