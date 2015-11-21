package com.javarush.test.level14.lesson08.bonus01;

import java.util.ArrayList;
import java.util.List;

/* Нашествие эксепшенов
Заполни массив exceptions 10 различными эксепшенами.
Первое исключение уже реализовано в методе initExceptions.
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //it's first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            String a = null;
            System.out.println(a);
        } catch (Exception e) {
            exceptions.add(e);
        }

        for (int i = 0; i < 9; i++) {
            try {
                int[] arr = new int[10];
                System.out.println(arr[11]);
            } catch (Exception e) {
                exceptions.add(e);
            }
        }
    }
}
