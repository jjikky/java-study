package com.study.interfaceStudy.pay;

// 결제 서비스 클래스
public class PaymentService {
    // 의존성 주입을 위한 인터페이스 필드
    private PaymentProcessor paymentProcessor;

    // 생성자 주입 방식으로 의존성 주입
    public PaymentService(PaymentProcessor paymentProcessor) {
        this.paymentProcessor = paymentProcessor;
    }

    public void makePayment(double amount) {
        // 결제 시도!
        paymentProcessor.processPayment(amount);
        // 결제 완료!
        // -> 이 시점 부터 결제가 완료 되었다는 코드를 작성..
    }
}
