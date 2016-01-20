package com.javarush.test.level38.lesson10.home02;

public @interface Date {
    //напиши свой код
    int year();

    int month();

    int day();

    int minute();

    int second();

    int hour();
}
/*
date = @Date(year = 2011, month = 5,
 day = 30, hour = 18, minute = 35, second = 18)
 */