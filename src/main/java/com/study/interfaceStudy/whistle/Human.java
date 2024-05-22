package com.study.interfaceStudy.whistle;

public class Human extends Animal implements Whistle {
    @Override
    public void eat() {
        System.out.println("Human: 냠냠냠");
    }

    @Override
    public void whistle() {
        System.out.println("Human: 😗😗😗💨");
    }
}