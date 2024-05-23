package com.study.threadStudy.threadBasic;

// 작업을 나타내는 클래스 (Runnable은 Thread에 배정된다.)
class Task implements Runnable {
    private String taskName;

    // 생성자
    public Task(String taskName) {
        this.taskName = taskName;
    }

    // run 메서드를 오버라이드하여 작업을 정의
    // 콜러측에서 start() 함수 실행 시 JVM에서 스레드를 할당하고 해당 객체의 run() 메서드를 실행 시키게 된다.
    @Override
    public void run() {
        System.out.println(taskName + "를 시작합니다.");
        try {
            // 작업을 수행하는 데 걸리는 시간(예: 2초)
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println(taskName + " 작업 중단됨");
        }
        System.out.println(taskName + "를 끝냈습니다.");
    }
}