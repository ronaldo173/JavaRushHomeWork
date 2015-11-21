package com.javarush.test.level19.lesson10.bonus01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Отслеживаем изменения
Считать в консоли 2 имени файла - file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME
Пример:
[Файл 1]
строка1
строка2
строка3

[Файл 2]
строка1
строка3
строка4

[Результат - список lines]
SAME строка1
REMOVED строка2
SAME строка3
ADDED строка4
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {

        BufferedReader nameReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader readerFile1 = new BufferedReader(new FileReader(nameReader.readLine()));
        BufferedReader readerFile2 = new BufferedReader(new FileReader(nameReader.readLine()));
        nameReader.close();

        ArrayList<String> file1 = new ArrayList<>();
        ArrayList<String> file2 = new ArrayList<>();
        String s = null;
        while ((s = readerFile1.readLine()) != null) {
            file1.add(s);
        }
        readerFile1.close();
        while ((s = readerFile2.readLine()) != null) {
            file2.add(s);
        }
        readerFile2.close();


        for (String i : file1) {
            if (file2.contains(i)) {
                lines.add(new LineItem(Type.SAME, i));
            } else if (!file2.contains(i)) {
                lines.add(new LineItem(Type.REMOVED, i));
            }
        }
        for (String i : file2) {
            if (!file1.contains(i)) {
                lines.add(new LineItem(Type.ADDED, i));
            }
        }


        System.out.println(file1);
        System.out.println(file2);
        for (LineItem l : lines) {
            System.out.println(l.type + " " + l.line);
        }
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
//         НЕ РАБОТАЕТ