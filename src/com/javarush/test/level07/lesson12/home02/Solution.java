package com.javarush.test.level07.lesson12.home02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Переставить M первых строк в конец списка
Ввести с клавиатуры 2 числа N  и M.
Ввести N строк и заполнить ими список.
Переставить M первых строк в конец списка.
Вывести список на экран, каждое значение с новой строки.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //напишите тут ваш код
        int N = Integer.parseInt(reader.readLine());
        int M = Integer.parseInt(reader.readLine());
        ArrayList<String> arrayList = new ArrayList<String>();
        for (int i = 0; i < N; i++) {
            arrayList.add(reader.readLine());
        }
        /*
        for (int i = 0; i < M; i++)
        {
            //swap
            String temp= arrayList.get(i);
            arrayList.remove(i);
            arrayList.add(temp);
        }
        */
        ArrayList<String> result = new ArrayList<String>();
        for (int i = 0; i < arrayList.size() - M; i++) {
            result.add(0, arrayList.get(arrayList.size() - 1 - i));
        }
        for (int i = 0; i < M; i++) {
            result.add(arrayList.get(i));
        }

        for (String s : result) System.out.println(s);
    }
}
