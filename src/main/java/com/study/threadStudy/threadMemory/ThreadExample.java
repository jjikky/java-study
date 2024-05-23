package com.study.threadStudy.threadMemory;

// 공유 객체를 정의하는 클래스
class SharedCounter {
    // 카운터 변수를 공유합니다
    private int counter = 0;

    // 카운터를 증가시키는 메서드
    public synchronized void increment() {   // synchronized 설명은 뒤에 나온다.
        counter++;
        System.out.println(Thread.currentThread().getName() + " - 현재 카운터 값: " + counter);
    }

    // 현재 카운터 값을 반환하는 메서드
    public int getCounter() {
        return counter;
    }
}

// 스레드를 정의하는 클래스
class CounterThread extends Thread {
    // 공유 객체를 저장할 변수
    private SharedCounter sharedCounter;

    // 생성자에서 공유 객체를 받습니다
    public CounterThread(SharedCounter sharedCounter) {
        this.sharedCounter = sharedCounter;
    }

    // 스레드 실행 메서드
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            sharedCounter.increment();
            try {
                // 잠시 대기
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

// 메인 클래스
public class ThreadExample {
    public static void main(String[] args) {
        // 공유 객체 생성
        SharedCounter sharedCounter = new SharedCounter();

        // 여러 스레드 생성
        CounterThread thread1 = new CounterThread(sharedCounter);
        CounterThread thread2 = new CounterThread(sharedCounter);
        CounterThread thread3 = new CounterThread(sharedCounter);

        // 스레드 시작
        thread1.start();
        thread2.start();
        thread3.start();

        // 모든 스레드가 종료될 때까지 대기
        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 최종 카운터 값 출력
        System.out.println("최종 카운터 값: " + sharedCounter.getCounter());
    }
}