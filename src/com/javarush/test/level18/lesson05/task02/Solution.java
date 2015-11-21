package com.javarush.test.level18.lesson05.task02;

/* Подсчет запятых
С консоли считать имя файла
Посчитать в файле количество символов ',', количество вывести на консоль
Закрыть потоки. Не использовать try-with-resources

Подсказка: нужно сравнивать с ascii-кодом символа ','
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));

        ArrayList<String> arrayList = new ArrayList<>();
        String s;
        while ((s = fileReader.readLine()) != null) {
            arrayList.add(s);
        }
        int count = 0;
        for (String i : arrayList) {
            char[] arrTemp = i.toCharArray();
            for (int j = 0; j < arrTemp.length; j++) {
                if (arrTemp[j] == ',') count++;
            }
        }
        System.out.println(count);
        reader.close();
        fileReader.close();

    }
}
