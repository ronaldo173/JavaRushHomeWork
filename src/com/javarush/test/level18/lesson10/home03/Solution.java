package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать содержимое третьего файла
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] files = new String[3];
        for (int i = 0; i < 3; i++) {
            files[i] = reader.readLine();
        }
        FileInputStream fileInputStream2 = new FileInputStream(files[1]);
        FileInputStream fileInputStream3 = new FileInputStream(files[2]);
        FileOutputStream fileOutputStream1 = new FileOutputStream(files[0], true);

        byte[] buffer2 = new byte[fileInputStream2.available()];
        fileInputStream2.read(buffer2);
        fileInputStream2.close();

        byte[] buffer3 = new byte[fileInputStream3.available()];
        fileInputStream3.read(buffer3);
        fileInputStream3.close();

        fileOutputStream1.write(buffer2);
        fileOutputStream1.write(buffer3);
        fileOutputStream1.close();
        reader.close();


    }
}
