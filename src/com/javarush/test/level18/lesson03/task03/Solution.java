package com.javarush.test.level18.lesson03.task03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* Самые частые байты
Ввести с консоли имя файла
Найти байт или байты с максимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        FileInputStream fileInputStream = new FileInputStream(fileName);

        ArrayList<Integer> arrayList = new ArrayList<>();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        while (fileInputStream.available() > 0) {
            arrayList.add(fileInputStream.read());
        }
        for (int i = 0; i < arrayList.size(); i++) {
            hashMap.put(arrayList.get(i), Collections.frequency(arrayList, arrayList.get(i)));
        }

        int max = 0;
        for (Map.Entry<Integer, Integer> a : hashMap.entrySet()) {
            //System.out.println(a.getKey() + " -раз-> " + a.getValue());
            if (a.getValue() > max) {
                max = a.getValue();
            }
        }
        for (Map.Entry<Integer, Integer> a : hashMap.entrySet()) {
            if (a.getValue().equals(max)) {
                System.out.print(a.getKey() + " ");
            }
        }

        reader.close();
        fileInputStream.close();
    }
}
