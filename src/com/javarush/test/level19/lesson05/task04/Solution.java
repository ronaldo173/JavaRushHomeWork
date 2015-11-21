package com.javarush.test.level19.lesson05.task04;

/* Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Заменить все точки "." на знак "!", вывести во второй файл.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String f1, f2;
        f1 = reader.readLine();
        f2 = reader.readLine();
        reader.close();

        BufferedReader bufferedReader = new BufferedReader(new FileReader(f1));
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<String> arrayList2 = new ArrayList<>();
        String s = null;
        while ((s = bufferedReader.readLine()) != null) {
            arrayList.add(s);
        }
        bufferedReader.close();

        for (String i : arrayList) {
//            arrayList2.add(i.replaceAll(".", "!"));
            i = i.replaceAll("\\.", "\\!");
            arrayList2.add(i);
        }

//        BufferedWriter writer=new BufferedWriter(new FileWriter(f2));
//        for (int i = 0; i < arrayList2.size(); i++) {
//            writer.write(arrayList2.get(i));
//        }writer.close();
        PrintWriter printWriter = new PrintWriter(new FileWriter(f2));
        for (String i : arrayList2) {
            printWriter.write(i);
        }
        printWriter.close();
    }
}
