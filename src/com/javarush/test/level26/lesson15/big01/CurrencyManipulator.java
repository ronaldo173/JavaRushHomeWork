package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.util.*;

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

    public boolean isAmountAvailable(int sum) {
        if (getTotalAmount() >= sum) {
            return true;
        }
        return false;
    }

    public Map<Integer, Integer> withdrawAmount(int expectedAmount) throws NotEnoughMoneyException {

        int sum = expectedAmount;
        Map<Integer, Integer> temp = new HashMap<>();
        temp.putAll(denominations);
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : temp.entrySet()) {
            list.add(entry.getKey());
        }

        Collections.sort(list);
        Collections.reverse(list);

        TreeMap<Integer, Integer> result = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

        for (Integer integer : list) {
            int key = integer;
            int value = temp.get(key);

            while (true) {
                if (sum < key || value <= 0) {
                    temp.put(key, value);
                    break;
                }
                sum -= key;
                value--;

                if (result.containsKey(key)) {
                    result.put(key, result.get(key) + 1);
                } else result.put(key, 1);
            }
        }

        if (sum > 0) {
            throw new NotEnoughMoneyException();
        } else for (Map.Entry<Integer, Integer> entry : result.entrySet()) {
            ConsoleHelper.writeMessage("\t" + entry.getKey() + " - " + entry.getValue());

            denominations.clear();
            denominations.putAll(temp);
            ConsoleHelper.writeMessage("Transaction was successful!");
        }

        return result;
    }

}
/*
2.1. Внимание!!! Метод withdrawAmount должен возвращать минимальное количество банкнот, которыми набирается запрашиваемая сумма.
Используйте Жадный алгоритм (use google).
Если есть несколько вариантов, то использовать тот, в котором максимальное количество банкнот высшего номинала.
Если для суммы 600 результат - три банкноты: 500 + 50 + 50 = 200 + 200 + 200, то выдать первый вариант.
Пример, надо выдать 600
В манипуляторе есть следующие банкноты:
500 - 2
200 - 3
100 - 1
50 - 12
Результат должен быть таким:
500 - 1
100 - 1
т.е. всего две банкноты (это минимальное количество банкнот) номиналом 500 и 100.

2.2. Мы же не можем одни и те же банкноты выдавать несколько раз, поэтому
если мы нашли вариант выдачи денег (п.2.1. успешен), то вычесть все эти банкноты из карты в манипуляторе.

2.3. метод withdrawAmount должен кидать NotEnoughMoneyException, если купюрами невозможно выдать запрашиваемую сумму.
Пример, надо выдать 600
В манипуляторе есть следующие банкноты:
500 - 2
200 - 2
Результат - данными банкнотами невозможно выдать запрашиваемую сумму. Кинуть исключение.
Не забудьте, что в некоторых случаях картой кидается ConcurrentModificationException.
 */