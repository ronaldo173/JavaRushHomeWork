package com.javarush.test.level14.lesson08.home05;

/**
 * Created by Саша on 28.07.2015.
 */
public class Mouse implements CompItem {
    @Override
    public String getName() {
        return getClass().getSimpleName();
    }
}
