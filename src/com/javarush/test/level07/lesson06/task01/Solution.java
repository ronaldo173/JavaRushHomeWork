package com.javarush.test.level07.lesson06.task01;

/* 5 различных строчек в списке
1. Создай список строк.
2. Добавь в него 5 различных строчек.
3. Выведи его размер на экран.
4. Используя цикл выведи его содержимое на экран, каждое значение с новой строки.
*/


import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код

        ArrayList<String> a1 = new ArrayList<String>();
        a1.add("bla1");
        a1.add("bla2");
        a1.add("3");
        a1.add("bla4");
        a1.add("bla5");

        System.out.println(a1.size());
        for (String a : a1) System.out.println(a);

    }
}
