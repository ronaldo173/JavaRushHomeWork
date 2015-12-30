package com.javarush.test;

import java.util.*;

/**
 * Created by Santer on 30.12.2015.
 */
public class TestDifferent {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 100000000; i++) {
            int number = (int) Math.round(Math.random() * 5.5);
            list.add(number);
        }

//        System.out.println(list);
        System.out.println("Max freequency of 1 : " + Collections.frequency(list, 1));
        System.out.println("Max freequency of 2 : " + Collections.frequency(list, 2));
        System.out.println("Max freequency of 3 : " + Collections.frequency(list, 3));
        System.out.println("Max freequency of 4 : " + Collections.frequency(list, 4));
        System.out.println("Max freequency of 5 : " + Collections.frequency(list, 5));

        Comparator<Map.Entry<String, Integer>> myComparator = new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        };
        Map<String, Integer> map = new TreeMap<>();
        List<Map.Entry<String, Integer>> listOfMap = new ArrayList<>();


        for (int i = 1; i <= 5; i++) {
            map.put("СУШИ НОМЕР: " + i, Collections.frequency(list, i));
        }

        listOfMap.addAll(map.entrySet());
        Collections.sort(listOfMap, myComparator);


        for (Map.Entry<String, Integer> stringIntegerEntry : listOfMap) {
            System.out.println(stringIntegerEntry.getKey() + " --- " + stringIntegerEntry.getValue());
        }
    }
}
