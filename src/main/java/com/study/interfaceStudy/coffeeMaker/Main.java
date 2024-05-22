package com.study.interfaceStudy.coffeeMaker;

public class Main {
    public static void main(String[] args) {
        CoffeeMaker basicMachine = new BasicCoffeeMachine();
        CoffeeMaker advancedMachine = new AdvancedCoffeeMachine();

        CoffeeMachine coffeeMachine1 = new CoffeeMachine(basicMachine);
        coffeeMachine1.makeCoffee(); // 커피를 내립니다.

        CoffeeMachine coffeeMachine2 = new CoffeeMachine(advancedMachine);
        coffeeMachine2.makeCoffee(); // 고급 커피를 내립니다.
    }
}
