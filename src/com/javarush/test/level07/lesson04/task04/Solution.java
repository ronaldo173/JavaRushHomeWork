package com.javarush.test.level07.lesson04.task04;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Массив из чисел в обратном порядке
1. Создать массив на 10 чисел.
2. Ввести с клавиатуры 10 чисел и записать их в массив.
3. Расположить элементы массива в обратном порядке.
4. Вывести результат на экран, каждое значение выводить с новой строки.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

        int[] arrInt = new int[10];
        for (int i = 0; i < arrInt.length; i++) {
            arrInt[i] = Integer.parseInt(buf.readLine());

        }
        for (int i = 0; i < arrInt.length / 2; i++) {
            int temp = arrInt[i];
            arrInt[i] = arrInt[arrInt.length - 1 - i];
            arrInt[arrInt.length - 1 - i] = temp;
        }

        for (int i : arrInt) {
            System.out.println(i);
        }


    }
}
