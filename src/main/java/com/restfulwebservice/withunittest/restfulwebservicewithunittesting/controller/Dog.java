package com.restfulwebservice.withunittest.restfulwebservicewithunittesting.controller;


class Animal {
}
class Mammal{
}

public class Dog extends Mammal {

    private Singleton singleton;

    public static void main(String args[]) {
        //Animal a = new Animal();
        Mammal m = new Mammal();
        Dog d = new Dog();
        //System.out.println(m instanceof Animal);
        System.out.println(d instanceof Mammal);
        //System.out.println(d instanceof Animal);

        Akhil akhil = new Akhil();
        System.out.println(akhil instanceof Human);
        Singleton singleton =new Singleton();
        System.out.println(singleton instanceof Human); //is-a
    }
}