package com.javarush.test.level05.lesson12.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* Задача по алгоритмам
Написать программу, которая:
1. вводит с консоли число N > 0
2. потом вводит N чисел с консоли
3. выводит на экран максимальное из введенных N чисел.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //int maximum = ;

        //напишите тут ваш код
        int N = Integer.parseInt(reader.readLine());
        ArrayList<Integer> arr = new ArrayList<Integer>();

        while (N > 0) {
            arr.add(Integer.parseInt(reader.readLine()));
            N--;
        }
        Collections.sort(arr);


        System.out.println(arr.get(arr.size() - 1));
    }
}
