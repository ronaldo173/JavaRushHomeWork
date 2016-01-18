package com.javarush.test.level26.lesson15.big01;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Alex on 18.01.2016.
 */
public class CurrencyManipulator {
    /**
     * example USD
     */
    private String currencyCode;
    /**
     * denominations - это Map<номинал, количество>
     */
    private Map<Integer, Integer> denominations = new HashMap<>();

    public CurrencyManipulator(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }
}
/*
1. Создадим класс CurrencyManipulator, который будет хранить всю информацию про выбранную валюту.
String currencyCode - код валюты, например, USD. Состоит из трех букв
Map<Integer, Integer> denominations - это Map<номинал, количество>
Чтобы можно было посмотреть, к какой валюте относится манипулятор, добавим геттер для currencyCode
Очевидно, что манипулятор никак не может функционировать без названия валюты,
поэтому добавим конструктор с этим параметром и проинициализируем currencyCode
 */