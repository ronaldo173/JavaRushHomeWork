package com.javarush.test.level19.lesson05.task01;

/* Четные байты
Считать с консоли 2 имени файла.
Вывести во второй файл все байты с четным индексом.
Пример: второй байт, четвертый байт, шестой байт и т.д.
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1, fileName2;
        fileName1 = reader.readLine();
        fileName2 = reader.readLine();
        reader.close();

        FileReader reader1 = new FileReader(fileName1);
        FileWriter writer = new FileWriter(fileName2);

        ArrayList<Integer> arrayList = new ArrayList<>();
        while (reader1.ready()) {
            arrayList.add(reader1.read());
        }
        reader1.close();
        for (int i = 1; i < arrayList.size(); i = i + 2) {
            writer.write(arrayList.get(i));
        }
        writer.close();


    }
}
