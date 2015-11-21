package com.javarush.test.level04.lesson16.home02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* Среднее такое среднее
Ввести с клавиатуры три числа, вывести на экран среднее из них. Т.е. не самое большое и не самое маленькое.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        int a1, a2, a3;
        a1 = Integer.parseInt(buf.readLine());
        a2 = Integer.parseInt(buf.readLine());
        a3 = Integer.parseInt(buf.readLine());

        ArrayList<Integer> arr = new ArrayList<Integer>();
        arr.add(a1);
        arr.add(a2);
        arr.add(a3);
        Collections.sort(arr);

        System.out.println(arr.get(1));
    }
}
