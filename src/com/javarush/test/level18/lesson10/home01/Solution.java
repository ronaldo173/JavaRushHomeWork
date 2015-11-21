package com.javarush.test.level18.lesson10.home01;

/* Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв)
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.AbstractList;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        String s = args[0];
        char[] alphabet = new char[26];
        AbstractList<Integer> characters = new ArrayList<>();
        int count = 0;

        for (int i = 0; i < alphabet.length; i++) {
            alphabet[i] = (char) ('a' + i);
        }

        FileInputStream fileInputStream = new FileInputStream(s);
        while (fileInputStream.available() > 0) {
            characters.add(fileInputStream.read());
        }
        fileInputStream.close();

        for (int a : characters) {
            for (int i = 0; i < alphabet.length; i++) {
                if (a == alphabet[i]) {
                    count++;
                }
            }
        }
        System.out.println(count);

    }
}
