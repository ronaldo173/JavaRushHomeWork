package com.javarush.test.level18.lesson05.task04;

/* Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1, fileName2;
        fileName1 = reader.readLine();
        fileName2 = reader.readLine();

        FileInputStream fileInputStream = new FileInputStream(fileName1);
        ArrayList<Integer> arrayList = new ArrayList<>();

        while (fileInputStream.available() > 0) {
            arrayList.add(0, fileInputStream.read());
        }

        FileOutputStream fileOutputStream = new FileOutputStream(fileName2);
        for (int i = 0; i < arrayList.size(); i++) {
            fileOutputStream.write(arrayList.get(i));
        }
        fileInputStream.close();
        fileOutputStream.close();
        reader.close();

    }
}
