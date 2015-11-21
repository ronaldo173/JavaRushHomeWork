package com.javarush.test.level07.lesson09.task03;

import java.util.ArrayList;

/* Слово «именно»
1. Создай список из слов «мама», «мыла», «c».
2. После каждого слова вставь в список строку, содержащую слово «именно».
3. Используя цикл for вывести результат на экран, каждый элемент списка с новой строки.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("мама");
        arrayList.add("мыла");
        arrayList.add("раму");


        for (int i = 1; i < arrayList.size() + 1; i = i + 2) {
            arrayList.add(i, "именно");
        }
        for (String i : arrayList) System.out.println(i);

    }
}
