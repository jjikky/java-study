package com.study.interfaceStudy.cafe;

public class Cafe {
    public static void main(String[] args) {
        Beverage[] beverages = { new Coffee(), new Tea() };

        for (Beverage beverage : beverages) {
            beverage.prepare(); // 메뉴판(인터페이스)에서 음료를 준비합니다.
        }
    }
}
