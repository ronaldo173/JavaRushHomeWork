package com.javarush.test.level26.lesson15.big01;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Alex on 18.01.2016.
 */
public class CurrencyManipulatorFactory {
    ;
    private static Map<String, CurrencyManipulator> manipulatorMap = new HashMap<>();

    private CurrencyManipulatorFactory() {
    }

    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode) {
        if (manipulatorMap.containsKey(currencyCode)) {
            return manipulatorMap.get(currencyCode);
        } else {
            CurrencyManipulator currencyManipulator = new CurrencyManipulator(currencyCode);
            manipulatorMap.put(currencyCode, currencyManipulator);
            return currencyManipulator;
        }
    }

    public static Collection<CurrencyManipulator> getAllCurrencyManipulators() {
        return manipulatorMap.values();
    }
}
/*
2.1. В классе CurrencyManipulatorFactory создайте статический метод getAllCurrencyManipulators(), который вернет Collection всех манипуляторов.
У вас все манипуляторы хранятся в карте, не так ли? Если нет, то рефакторьте.
2.2. В InfoCommand в цикле выведите [код валюты - общая сумма денег для выбранной валюты]
Запустим прогу и пополним счет на EUR 100 2 и USD 20 6, и посмотрим на INFO.
Все работает правильно?
 EUR - 200
 USD - 120
Отлично!
 */