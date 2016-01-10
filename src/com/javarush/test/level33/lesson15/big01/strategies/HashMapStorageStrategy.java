package com.javarush.test.level33.lesson15.big01.strategies;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Santer on 10.01.2016.
 */
public class HashMapStorageStrategy implements StorageStrategy {
    private HashMap<Long, String> data = new HashMap<>();

    @Override
    public boolean containsKey(Long key) {
        return data.containsKey(key);
    }

    @Override
    public boolean containsValue(String value) {
        return data.containsValue(value);
    }

    @Override
    public void put(Long key, String value) {
        data.put(key, value);
    }

    @Override
    public Long getKey(String value) {
        Long res = null;
        for (Map.Entry<Long, String> entry : data.entrySet()) {
            if (entry.getValue().equals(value)) {
                res = entry.getKey();
            }
        }
        return res;
    }

    @Override
    public String getValue(Long key) {
        return data.get(key);
    }
}
/*
Давай напишем наше первое хранилище (стратегию хранилища). Внутри оно будет
содержать обычный HashMap. Все стратегии будем хранить в пакете strategies.
5.1.	Создай класс HashMapStorageStrategy, реализующий интерфейс StorageStrategy.
5.2.	Добавь в класс поле HashMap<Long, String> data. В нем будут храниться наши
данные.
5.3.	Реализуй в классе все необходимые методы. Реализации методов должны
использовать поле data. Дополнительные поля не создавать.

 */