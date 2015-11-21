package com.javarush.test.level18.lesson03.task01;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* Максимальный байт
Ввести с консоли имя файла
Найти максимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(reader.readLine());
        int min = Integer.MIN_VALUE;
        while (inputStream.available() > 0) {
            // min= min < inputStream.read() ? inputStream.read(): min;
            int temp = inputStream.read();
            if (min < temp) {
                min = temp;
            }
        }
        System.out.println(min);
        inputStream.close();
        reader.close();

    }
}
