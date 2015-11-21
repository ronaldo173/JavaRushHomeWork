package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        String s = null;
        ArrayList<String> arrayListLines = new ArrayList<>();
        ArrayList<String> arrayList = new ArrayList<>();

        while ((s = fileReader.readLine()) != null) {
            arrayListLines.add(s);
        }
        fileReader.close();

        for (String i : arrayListLines) {

            i = i.replaceAll("\\W", " ");
//            System.out.println(i);
            String[] strings = i.split(" ");
            for (int j = 0; j < strings.length; j++) {
                arrayList.add(strings[j]);
            }
        }
        System.out.println(Collections.frequency(arrayList, "world"));
//        System.out.println(arrayList);

    }
}
