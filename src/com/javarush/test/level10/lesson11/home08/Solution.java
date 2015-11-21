package com.javarush.test.level10.lesson11.home08;

import java.util.ArrayList;

/* Массив списков строк
Создать массив, элементами которого будут списки строк. Заполнить массив любыми данными и вывести их на экран.
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String>[] arrayOfStringList = createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList() {

        //напишите тут ваш код
        String s = "ta tat at";
        ArrayList<String>[] lists = new ArrayList[2];
        ArrayList<String> a1 = new ArrayList<String>();
        a1.add(s);
        ArrayList<String> a2 = new ArrayList<String>();
        a2.add(s);
        lists[0] = a1;
        lists[1] = a2;


        return lists;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList) {
        for (ArrayList<String> list : arrayOfStringList) {
            for (String s : list) {
                System.out.println(s);
            }
        }
    }
}