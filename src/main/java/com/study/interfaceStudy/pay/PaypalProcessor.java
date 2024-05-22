package com.study.interfaceStudy.pay;

public class PaypalProcessor implements PaymentProcessor{
    public void processPayment(double amount) {
        // 이 클래스에서 페이팔 결제가 됐다고 치고!
        System.out.println("PayPal로 " + amount + "원을 결제합니다.");
    }
}
