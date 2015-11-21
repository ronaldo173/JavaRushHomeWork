package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        TreeSet<String> set = new TreeSet();
        String name = reader.readLine();
        while (!name.equals("end")) {
            set.add(name);
            name = reader.readLine();
        }

        String fullFileName = set.first();
        fullFileName = fullFileName.substring(0, fullFileName.lastIndexOf("."));
        //System.out.println(fullFileName);
        //System.out.println(set);

        File file = new File(fullFileName);
        FileWriter writer = new FileWriter(file);


        for (String s : set) {
            FileReader readerFromFile = new FileReader(s);
            int c;
            while ((c = readerFromFile.read()) != -1) {
                writer.write((char) c);
            }
            readerFromFile.close();
        }

        reader.close();
        writer.close();


    }
}
