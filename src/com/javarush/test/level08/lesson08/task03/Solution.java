package com.javarush.test.level08.lesson08.task03;

import java.util.HashMap;
import java.util.Map;

/* Одинаковые имя и фамилия
Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» - «Имя».
Проверить сколько людей имеют совпадающие с заданным имя или фамилию.
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        //напишите тут ваш код
        HashMap<String, String> map = new HashMap<String, String>();
        for (int i = 0; i < 10; i++) {
            int j = (i < 5) ? 10 : 20;
            map.put(Integer.toString(i), Integer.toString(j));
        }
        return map;

    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name) {
        //напишите тут ваш код
        int count = 0;

        for (Map.Entry<String, String> a : map.entrySet()) {
            if (a.getValue().equals(name)) count++;
        }
        return count;

    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String familiya) {
        //напишите тут ваш код
        int count = 0;
        for (Map.Entry<String, String> a : map.entrySet()) {
            if (a.getKey().equals(familiya)) count = 1;
        }
        return count;

    }
}
