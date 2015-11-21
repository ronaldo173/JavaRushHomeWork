package com.javarush.test.level05.lesson12.bonus02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* Нужно добавить в программу новую функциональность
Задача: Программа вводит два числа с клавиатуры и выводит минимальное из них на экран.
Новая задача: Программа вводит пять чисел с клавиатуры и выводит минимальное из них на экран.
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        ArrayList<Integer> arr = new ArrayList<Integer>();
        arr.add(a);
        arr.add(b);
        arr.add(Integer.parseInt(reader.readLine()));
        arr.add(Integer.parseInt(reader.readLine()));
        arr.add(Integer.parseInt(reader.readLine()));
        Collections.sort(arr);

        int minimum = arr.get(0);

        System.out.println("Minimum = " + minimum);
    }


    public static int min(int a, int b) {
        return a < b ? a : b;
    }

}
