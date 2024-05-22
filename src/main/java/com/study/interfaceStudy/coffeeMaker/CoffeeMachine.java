package com.study.interfaceStudy.coffeeMaker;

public class CoffeeMachine {
    private CoffeeMaker coffeeMaker;

    public CoffeeMachine(CoffeeMaker coffeeMaker) {
        this.coffeeMaker = coffeeMaker;
    }

    public void makeCoffee() {
        coffeeMaker.brew();
    }
}