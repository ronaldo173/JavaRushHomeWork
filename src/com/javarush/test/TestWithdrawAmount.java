package com.javarush.test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Santer on 19.01.2016.
 */
public class TestWithdrawAmount {
    /**
     * denominations - это Map<номинал, количество>
     */
    private static Map<Integer, Integer> mapStart = new HashMap<>();

    static {
        mapStart.put(500, 2);
        mapStart.put(200, 3);
        mapStart.put(100, 1);
        mapStart.put(50, 12);
    }

    public static void main(String[] args) {
        Map<Integer, Integer> map = withdrawAmount(10);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    public static Map<Integer, Integer> withdrawAmount(int expectedAmount) {


        return mapStart;
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