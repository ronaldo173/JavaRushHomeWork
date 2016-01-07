package com.javarush.test.level32.lesson02.task01;

import java.io.IOException;
import java.io.RandomAccessFile;

/* Запись в файл
В метод main приходят три параметра:
1) fileName - путь к файлу
2) number - число, позиция в файле
3) text - текст
Записать text в файл fileName начиная с позиции number.
Если файл слишком короткий, то записать в конец файла.
*/
public class Solution {
    public static void main(String... args) throws IOException {
        if (args.length < 3) {
            return;
        }

        String fileName = args[0];
        int numOfStart = Integer.parseInt(args[1]);
        String text = args[2].toString();
        RandomAccessFile randomAccessFile = new RandomAccessFile(fileName, "rw");

        try {
            if (randomAccessFile.length() < numOfStart) {
                randomAccessFile.seek(randomAccessFile.length());
                randomAccessFile.writeBytes(text);
            } else {
                randomAccessFile.seek(numOfStart);
                randomAccessFile.writeBytes(text);
            }
        } finally {
            randomAccessFile.close();
        }

    }
}
