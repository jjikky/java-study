package com.study.threadStudy._volatile;

public class VolatileTest {
        volatile boolean running = true;
//    boolean running = true;

    public void test() {
        // thread 1
        new Thread(() -> {
            int counter = 0;
            while (running) {
                counter++;
            }
            System.out.println("Thread 1 finished. Counted up to " + counter);
        }
        ).start();

        // thread 2
        new Thread(() -> {
            try {
                // thread 1 시작 될 때 까지 대기
                Thread.sleep(100);
            } catch (InterruptedException ignored) {
                // catch block
            }
            System.out.println("Thread 2 finishing");
            running = false;
        }
        ).start();
    }

    public static void main(String[] args) {
        new VolatileTest().test();
    }
}