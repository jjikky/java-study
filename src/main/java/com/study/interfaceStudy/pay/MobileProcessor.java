package com.study.interfaceStudy.pay;

// 모바일 결제 구현
public class MobileProcessor implements PaymentProcessor {
    public void processPayment(double amount) {
        // 이 클래스에서 핸드폰 결제가 됐다고 치고!
        System.out.println("모바일 결제로 " + amount + "원을 결제합니다.");
    }
}