package com.javarush.test.level26.lesson15.big01;

/**
 * Created by Alex on 18.01.2016.
 */
public class CurrencyManipulatorFactory {
    private static CurrencyManipulator currencyManipulator;

    private CurrencyManipulatorFactory() {
    }

    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode) {
        if (currencyManipulator == null) {
            currencyManipulator = new CurrencyManipulator(currencyCode);
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