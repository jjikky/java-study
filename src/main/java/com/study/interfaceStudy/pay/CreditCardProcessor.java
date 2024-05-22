package com.study.interfaceStudy.pay;

// 신용카드 결제 구현
public class CreditCardProcessor implements PaymentProcessor {
    public void processPayment(double amount) {
        // 이 클래스에서 신용카드 결제가 됐다고 치고!
        System.out.println("신용카드로 " + amount + "원을 결제합니다.");
    }
}
