package com.javarush.test.level14.lesson08.bonus03;

/**
 * Created by Саша on 28.07.2015.
 */
public class testSing {
    private static testSing ourInstance = new testSing();

    private testSing() {
    }

    public static testSing getInstance() {
        return ourInstance;
    }
}
