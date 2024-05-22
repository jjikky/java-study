package com.study.interfaceStudy.whistle;

public class MainAnimalCase {
    public static void main(String[] args) {
        Human human = new Human();
        human.eat();
        human.whistle();

        Parrot parrot = new Parrot();
        parrot.eat();
        parrot.whistle();
    }
}