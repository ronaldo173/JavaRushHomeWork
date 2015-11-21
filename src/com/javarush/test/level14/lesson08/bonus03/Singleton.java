package com.javarush.test.level14.lesson08.bonus03;

/**
 * Created by Саша on 28.07.2015.
 */
public class Singleton {
    static final Singleton singleton = new Singleton();

    private Singleton() {
    }

    static final Singleton getInstance() {
        return singleton;
    }
}
