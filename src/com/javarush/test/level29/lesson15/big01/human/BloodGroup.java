package com.javarush.test.level29.lesson15.big01.human;

/**
 * Created by Santer on 26.12.2015.
 */
public class BloodGroup {
    private static BloodGroup bloodGroup;
    private final int code;

    private BloodGroup(int code) {
        this.code = code;
    }

    public static BloodGroup first() {
        bloodGroup = new BloodGroup(1);
        return bloodGroup;
    }

//    public static BloodGroup getBloodGroup() {
//        return bloodGroup;
//    }

    public static BloodGroup second() {
        bloodGroup = new BloodGroup(2);
        return bloodGroup;
    }

    public static BloodGroup third() {
        bloodGroup = new BloodGroup(3);
        return bloodGroup;
    }

    public static BloodGroup fourth() {
        bloodGroup = new BloodGroup(4);
        return bloodGroup;
    }

    public int getCode() {
        return code;
    }
}

/*
9.4.	Замена кодирования типа классом.
9.4.1.	Объяви публичный класс группы крови BloodGroup внутри пакета human.
9.4.2.	Добавь в класс BloodGroup константное поле int code, приватный конструктор,
принимающий int и инициализирующий поле code, геттер для поля класса.
9.4.3.	Добавь в класс BloodGroup статические методы first(), second(), third() и fourth(),
создающие и возвращающие объекты типа BloodGroup с правильным кодом внутри (1,
2, 3 и 4 соответственно).
9.4.4.	Примени в классе Human новый тип BloodGroup.

 */