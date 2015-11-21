package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую часть.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] files = new String[3];
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            files[i] = reader.readLine();
        }
        FileInputStream fileInputStream = new FileInputStream(files[0]);
        while (fileInputStream.available() > 0) {
            arrayList.add(fileInputStream.read());
        }

        FileOutputStream fileOutputStream = new FileOutputStream(files[1]);
        FileOutputStream fileOutputStream2 = new FileOutputStream(files[2]);
        byte[] buffer = new byte[1000];
        int count = 0;
        if (arrayList.size() % 2 == 0) {
            count = arrayList.size() / 2;
        } else {
            count = (arrayList.size() / 2) + 1;
        }
        for (int i = 0; i < count; i++) {
            fileOutputStream.write(arrayList.get(i));
        }
        for (int i = count; i < arrayList.size(); i++) {
            fileOutputStream2.write(arrayList.get(i));
        }
        reader.close();
        fileInputStream.close();
        fileOutputStream.close();
        fileOutputStream2.close();


    }
}
