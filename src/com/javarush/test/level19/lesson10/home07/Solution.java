package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки. Не использовать try-with-resources

Пример выходных данных:
длинное,короткое,аббревиатура
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName1 = args[0], fileName2 = args[1];

        BufferedReader reader = new BufferedReader(new FileReader(fileName1));
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName2));
        String s;
        ArrayList<String> tempArr = new ArrayList<>();

        //читаем с файла 1 и кладем если длина >6 в лист tempArr
        while ((s = reader.readLine()) != null) {
            String[] temp = s.split(" ");
            for (int i1 = 0; i1 < temp.length; i1++) {
                String i = temp[i1];
                if (i.length() > 6) {
                    tempArr.add(i + ",");
                }
            }
        }
        reader.close();

        ///записываем из листа, обрезая послднюю запятую
        tempArr.set(tempArr.size() - 1, tempArr.get(tempArr.size() - 1).substring(0, tempArr.get(tempArr.size() - 1).length() - 1));
        for (String a : tempArr) {
            writer.write(a);
        }
        writer.close();

    }
}
