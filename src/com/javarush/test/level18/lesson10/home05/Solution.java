package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать через пробел во второй файл
Закрыть потоки. Не использовать try-with-resources
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
-3.49 - -3
-3.50 - -3
-3.51 - -4
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
        ArrayList<Integer> numb = new ArrayList<>();
        String str;
        String[] strArr;
        double res;

        BufferedReader reader1File1 = new BufferedReader(new FileReader(fileName1));
        while ((str = reader1File1.readLine()) != null) {
            strArr = str.split(" ");
            for (String s : strArr) {
                res = Math.round(Double.parseDouble(s));
                numb.add((int) res);
            }
        }
        reader1File1.close();

        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName2));
        for (int i = 0; i < numb.size(); i++) {
            writer.write(numb.get(i) + " ");
        }
        writer.close();

    }
}
