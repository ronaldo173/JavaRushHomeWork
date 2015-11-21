package com.javarush.test.level26.lesson15.big01;

import java.util.ArrayList;

/**
 * Created by Саша on 21.09.2015.
 */
public class CurrencyManipulatorFactory {
    private static ArrayList<CurrencyManipulator> manipulators = new ArrayList<>();
    private static CurrencyManipulator currencyManipulator = null;

    private CurrencyManipulatorFactory() {
    }

    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode) {
        if (!manipulators.contains(currencyManipulator) && currencyManipulator == null) {
            currencyManipulator = new CurrencyManipulator(currencyCode);
            manipulators.add(currencyManipulator);
        }

        return currencyManipulator;
    }
}
/*
2. Валют может быть несколько, поэтому нам понадобится фабрика, которая будет создавать и хранить манипуляторы.
Создадим класс CurrencyManipulatorFactory со статическим методом getManipulatorByCurrencyCode(String currencyCode).
В этом методе будем создавать нужный манипулятор, если он еще не существует, либо возвращать ранее созданный.
Подумайте, где лучше хранить все манипуляторы.
Сделайте так, чтобы невозможно было создавать объекты CurrencyManipulatorFactory класса
 */