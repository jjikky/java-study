package com.study.threadStudy.threadSyc;

public class Family {
    // 공유 자원 (냉장고)
    private static class 냉장고 {
        // synchronized 키워드가 없다면 냉장고는 아무나 마구잡이로 열 수 있게 된다.
        // 이 작업이 필요한 스레드 들이 이 앞에서 대기
        public synchronized void use(String name) {
            System.out.println(name + "이(가) 냉장고를 사용하고 있습니다.");
            try {
                Thread.sleep(1000); // 1초간 냉장고 사용
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name + "이(가) 냉장고 사용을 마쳤습니다.");
        }
    }

    private static 냉장고 공용냉장고 = new 냉장고();

    // mom 스레드
    public static class Mom extends Thread {
        public void run() {
            for (int i = 0; i < 3; i++) {
                공용냉장고.use("mom");
            }
        }
    }

    // dad 스레드
    public static class Dad extends Thread {
        public void run() {
            for (int i = 0; i < 3; i++) {
                공용냉장고.use("dad");
            }
        }
    }

    // son 스레드
    public static class Son extends Thread {
        public void run() {
            for (int i = 0; i < 3; i++) {
                공용냉장고.use("son");
            }
        }
    }

    public static void main(String[] args) {
        // 각 가족 구성원 스레드 생성
        Mom momThread = new Mom();
        Dad dadThread = new Dad();
        Son sonThread = new Son();

        // Thread 시작
        momThread.start();
        dadThread.start();
        sonThread.start();

        // 모든 스레드가 종료될 때까지 대기
        try {
            momThread.join();
            dadThread.join();
            sonThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("모든 가족 구성원이 냉장고 사용을 마쳤습니다.");
    }
}
