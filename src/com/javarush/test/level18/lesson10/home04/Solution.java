package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
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

        FileInputStream fileInputStream = new FileInputStream(fileName2);
        FileInputStream fileInputStream2 = new FileInputStream(fileName1);


        ArrayList<Integer> arrayList = new ArrayList<>();
        while (fileInputStream.available() > 0) {
            arrayList.add(fileInputStream.read());
        }
        while (fileInputStream2.available() > 0) {
            arrayList.add(fileInputStream2.read());
        }

        FileOutputStream fileOutputStream = new FileOutputStream(fileName1);
        for (int i = 0; i < arrayList.size(); i++) {
            fileOutputStream.write(arrayList.get(i));
        }
        reader.close();
        fileInputStream.close();
        fileInputStream2.close();
        fileOutputStream.close();
        //System.out.println(arrayList);


    }
}
