package com.javarush.test.level07.lesson09.task01;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Три массива
1. Введи с клавиатуры 20 чисел, сохрани их в список и рассортируй по трём другим спискам:
Число делится на 3 (x%3==0), делится на 2 (x%2==0) и все остальные.
Числа, которые делятся на 3 и на 2 одновременно, например 6, попадают в оба списка.
2. Метод printList должен выводить на экран все элементы списка  с новой строки.
3. Используя метод printList выведи эти три списка на экран. Сначала тот, который для x%3, потом тот, который для x%2, потом последний.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> arrDiv3 = new ArrayList<Integer>();
        ArrayList<Integer> arrDiv2 = new ArrayList<Integer>();
        ArrayList<Integer> arrElse = new ArrayList<Integer>();

        for (int i = 0; i < 20; i++) {
            arrayList.add(Integer.parseInt(buf.readLine()));
        }
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) % 3 == 0) {
                arrDiv3.add(arrayList.get(i));
            }
            if (arrayList.get(i) % 2 == 0) {
                arrDiv2.add(arrayList.get(i));
            } else if (arrayList.get(i) % 3 != 0 && arrayList.get(i) % 2 != 0) arrElse.add(arrayList.get(i));
        }
        ///print
        printList(arrDiv3);
        //System.out.println("BLABLALBA----------------");
        printList(arrDiv2);
        //System.out.println("BLABLALBA----------------");
        printList(arrElse);

    }

    public static void printList(List<Integer> list) {
        //напишите тут ваш код
        for (int i : list) System.out.println(i);

    }
}
