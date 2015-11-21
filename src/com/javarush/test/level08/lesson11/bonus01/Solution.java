package com.javarush.test.level08.lesson11.bonus01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Номер месяца
Программа вводит с клавиатуры имя месяца и выводит
его номер на экран в виде: «May is 5 month».
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String month = bufferedReader.readLine();
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("January");
        arrayList.add("February");
        arrayList.add("March");

        arrayList.add("April");
        arrayList.add("May");
        arrayList.add("June");
        arrayList.add("July");
        arrayList.add("August");
        arrayList.add("September");

        arrayList.add("October");
        arrayList.add("November");
        arrayList.add("December");

        int n = arrayList.indexOf(month) + 1;


        System.out.println(month + " is " + n + " month");
    }

}
