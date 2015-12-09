package com.javarush.test.level15.lesson12.home04;

/**
 * Created by Саша on 30.07.2015.
 */
public class Moon implements Planet {
    private static Moon moon;

    ;

    private Moon() {
    }

    public static Moon getInstance() {
        if (moon == null) {
            moon = new Moon();
        }
        return moon;
    }
}
