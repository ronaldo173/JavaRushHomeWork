package com.javarush.test.level07.lesson06.task02;

/* 5 строчек: «101», «102», «103», «104», «105»
1. Создай список строк.
2. Добавь в него 5 строчек: «101», «102», «103», «104», «105».
3. Удали первую, среднюю и последнюю.
4. Используя цикл выведи на экран его содержимое, каждое значение с новой строки.
5. Выведи его размер. (После удаления одного элемента индексы остальных меняются.
Например, если удалить 0-й элемент, то тот, который был 1-м, станет 0-м. И т.д.)
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("101");
        arrayList.add("102");
        arrayList.add("103");
        arrayList.add("104");
        arrayList.add("105");
        arrayList.remove(0);
        arrayList.remove((arrayList.size() - 1) / 2);
        arrayList.remove(arrayList.size() - 1);

        for (String i : arrayList) System.out.println(i);
        System.out.println(arrayList.size());

    }
}
