package com.javarush.test.level33.lesson15.big01;


import com.javarush.test.level33.lesson15.big01.strategies.HashMapStorageStrategy;
import com.javarush.test.level33.lesson15.big01.strategies.StorageStrategy;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Santer on 10.01.2016.
 */
public class Solution {
    public static Set<Long> getIds(Shortener shortener, Set<String> strings) {
        Set<Long> set = new HashSet<>();
        for (String string : strings) {
            set.add(shortener.getId(string));
        }
        return set;
    }

    public static Set<String> getStrings(Shortener shortener, Set<Long> keys) {
        Set<String> set = new HashSet<>();
        for (Long key : keys) {
            set.add(shortener.getString(key));
        }
        return set;
    }

    public static void testStrategy(StorageStrategy strategy, long elementsNumber) {
        System.out.println(strategy.getClass().getSimpleName());
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < elementsNumber; i++) {
            set.add(Helper.generateRandomString());
        }
        Shortener shortener = new Shortener(strategy);

        Long t1 = new Date().getTime();
        Set<Long> setId = getIds(shortener, set);
        Long t2 = new Date().getTime();
        Helper.printMessage(String.valueOf(t2 - t1));

        Long t3 = new Date().getTime();
        Set<String> setGetStrings = getStrings(shortener, setId);
        Long t4 = new Date().getTime();
        Helper.printMessage(String.valueOf(t4 - t3));

        boolean isEqualsCOllections = true;
        for (String setGetString : setGetStrings) {
            if (!set.contains(setGetString)) {
                isEqualsCOllections = false;
            }
        }
        if (isEqualsCOllections) {
            Helper.printMessage("Тест пройден.");
        } else {
            Helper.printMessage("Тест не пройден.");
        }
    }

    public static void main(String[] args) {
        testStrategy(new HashMapStorageStrategy(), 10000);
    }
}
/*
Первая стратегия готова, пришло время ее протестить. Для этого:
6.1.	Создай класс Solution.
6.2.	Добавь в класс Solution реализации вспомогательных статических методов:
6.2.1.	Set<Long> getIds(Shortener shortener, Set<String> strings). Этот метод должен
для переданного множества строк возвращать множество
идентификаторов. Идентификатор для каждой отдельной строки нужно
получить, используя  shortener.
6.2.2.	Set<String> getStrings(Shortener shortener, Set<Long> keys). Метод будет
возвращать множество строк, которое соответствует переданному
множеству идентификаторов.
При реальном использовании Shortener, задача получить из множества строк
множество идентификаторов и наоборот скорее всего не встретится, это нужно
исключительно для тестирования.

6.2.3.	testStrategy(StorageStrategy strategy, long elementsNumber). Метод будет
тестировать работу переданной стратегии на определенном количестве
элементов elementsNumber. Реализация метода должна:
6.2.3.1.	Выводить имя класса стратегии. Имя не должно включать имя пакета.
6.2.3.2.	Генерировать тестовое множество строк, используя Helper и заданное
количество элементов elementsNumber.
6.2.3.3.	Создавать объект типа Shortener, используя переданную стратегию.

6.2.3.4.	Замерять и выводить время необходимое для отработки метода getIds
для заданной стратегии и заданного множества элементов. Время
вывести в миллисекундах. При замере времени работы метода можно
пренебречь переключением процессора на другие потоки, временем,
которое тратится на сам вызов, возврат значений и вызов методов
получения времени (даты). Замер времени произведи с
использованием объектов типа Date.
6.2.3.5.	Замерять и выводить время необходимое для отработки метода
getStrings для заданной стратегии и полученного в предыдущем пункте
множества идентификаторов.
6.2.3.6.	Сравнивать одинаковое ли содержимое множества строк, которое было
сгенерировано и множества, которое было возвращено методом
getStrings. Если множества одинаковы, то выведи "Тест пройден.",
иначе "Тест не пройден.".
6.2.4.	Добавь метод main(). Внутри метода протестируй стратегию
HashMapStorageStrategy с помощью 10000 элементов.
6.3.	Проверь, что программа работает и тест пройден.
 */