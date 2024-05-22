package com.study.interfaceStudy.pay;

public class Main {
    public static void main(String[] args) {
        // PaymentProcessor: 결제 처리를 위한 인터페이스
        // CreditCardProcessor, PaypalProcessor, MobileProcessor: PaymentProcessor 인터페이스의 구현체들
        // PaymentService: 결제 서비스를 제공하며, PaymentProcessor타입의 의존성을 주입 받음

        PaymentProcessor creditCardProcessor = new CreditCardProcessor();
        PaymentProcessor paypalProcessor = new PaypalProcessor();
        PaymentProcessor mobileProcessor = new MobileProcessor();

        PaymentService creditCardPayment = new PaymentService(creditCardProcessor);
        PaymentService paypalPayment = new PaymentService(paypalProcessor);
        PaymentService mobilePayment = new PaymentService(mobileProcessor);

        creditCardPayment.makePayment(100.0);
        paypalPayment.makePayment(120.0);
        mobilePayment.makePayment(150.0);
    }
}
