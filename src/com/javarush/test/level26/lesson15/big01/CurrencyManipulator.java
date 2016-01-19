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

    public void addAmount(int denomination, int count) {
        if (denominations.containsKey(denomination))
            denominations.put(denomination, denominations.get(denomination) + count);
        else
            denominations.put(denomination, count);
    }

    public int getTotalAmount() {
        int sum = 0;
        for (Map.Entry<Integer, Integer> entry : denominations.entrySet()) {
            sum = sum + entry.getKey() * entry.getValue();
        }
        return sum;
    }

    public boolean hasMoney() {
        return denominations.isEmpty() ? false : true;
    }
}
/*
3. Запустим прогу и сразу первой операцией попросим INFO. Ничего не вывело? Непорядок.
Добавьте в манипулятор метод boolean hasMoney(), который будет показывать, добавлены ли какие-то банкноты или нет.

4. В InfoCommand используйте метод п.3. и выведите фразу "No money available.", если нет денег в банкомате.

 */