package com.study.threadStudy.threadBasic;

public class MainThreadHome {
    public static void main(String[] args) {
        // 가족 구성원이 해야하는 작업을 생성
        Task cleaning = new Task("집 청소");
        Task cooking = new Task("요리");
        Task takingOutTrash = new Task("쓰레기 버리기");
        Task laundry = new Task("세탁");

        // 각 작업을 수행할 사람(스레드)을 생성
        Thread father = new Thread(cleaning);
        Thread mother = new Thread(cooking);
        Thread son = new Thread(takingOutTrash);
        Thread daughter = new Thread(laundry);

        // 각 구성원의 작업을 시작
        // 스레드 객체에서 start() 함수를 실행하면 JVM에 의해서 스레드가 만들어지게 된다.
        // 그 후 JVM 은 생성한 스레드 내부에 `@Override` 된 run() 메서드를 호출한다.
        father.start();
        mother.start();
        son.start();
        daughter.start();
    }
}