package com.javarush.test;

enum Days {
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
}

/**
 * Created by Santer on 03.01.2016.
 */
public class testEnum {
    public static void main(String[] args) {
        System.out.println(Days.values()[1]);
    }

}
