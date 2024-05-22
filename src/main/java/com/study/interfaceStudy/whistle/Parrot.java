package com.study.interfaceStudy.whistle;

public class Parrot extends Animal implements Whistle {
    @Override
    public void eat() {
        System.out.println("Parrot 냠냠냠.");
    }

    @Override
    public void whistle() {
        System.out.println("Parrot : 😚😚😚");
    }
}