package com.javarush.test.level08.lesson08.task04;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Удалить всех людей, родившихся летом
Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: «фамилия» - «дата рождения».
Удалить из словаря всех людей, родившихся летом.
*/

public class Solution {
    public static void main(String[] args) {/*
        HashMap<String ,Date> map=createMap();
        removeAllSummerPeople(map);
        for(Map.Entry<String, Date> a:map.entrySet()){
            System.out.println(a.getKey()+ " " + a.getValue());
        }
        */
    }

    public static HashMap<String, Date> createMap() {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Stallone", new Date("JUNE 1 1980"));

        //напишите тут ваш код
        for (int i = 0; i < 9; i++) {
            map.put("name" + i, new Date(1993, i, 16));
        }
        return map;

    }

    public static void removeAllSummerPeople(HashMap<String, Date> map) {
        //напишите тут ваш код
        Iterator<Map.Entry<String, Date>> iter = map.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<String, Date> pair = iter.next();
            if (pair.getValue().getMonth() >= 5 && pair.getValue().getMonth() <= 7) {
                iter.remove();
            }
        }

    }
}
