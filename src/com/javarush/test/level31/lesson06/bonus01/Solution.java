package com.javarush.test.level31.lesson06.bonus01;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* Разархивируем файл
В метод main приходит список аргументов.
Первый аргумент - имя результирующего файла resultFileName, остальные аргументы - имена файлов fileNamePart.
Каждый файл (fileNamePart) - это кусочек zip архива. Нужно разархивировать целый файл, собрав его из кусочков.
Записать разархивированный файл в resultFileName.
Архив внутри может содержать файл большой длины, например, 50Mb.
Внутри архива может содержаться файл с любым именем.

Пример входных данных. Внутри архива находится один файл с именем abc.mp3:
C:/result.mp3
C:/pathToTest/test.zip.003
C:/pathToTest/test.zip.001
C:/pathToTest/test.zip.004
C:/pathToTest/test.zip.002
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length < 2) {
            System.err.println("error args");
            return;
        }
        String[] argsArr = args;
        File result = new File(args[0]);
        if (!result.exists()) {
            result.createNewFile();
        }

        byte[] buffer = new byte[1024];
        List<File> fileList = new ArrayList<>();

        for (int i = 1; i < argsArr.length; i++) {
            fileList.add(new File(args[i]));
        }

        Collections.sort(fileList);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        for (File file : fileList) {
            FileInputStream fis = new FileInputStream(file);

            while (fis.read(buffer) > -1) {
                baos.write(buffer);
                baos.flush();
            }
        }

        ZipInputStream zipInputStream = new ZipInputStream(new ByteArrayInputStream(baos.toByteArray()));
        FileOutputStream fileOutputStream = new FileOutputStream(result);

        ZipEntry zipEntry = zipInputStream.getNextEntry();
        while (zipEntry != null) {
            int count;
            while ((count = zipInputStream.read(buffer)) > -1) {
                fileOutputStream.write(buffer, 0, count);
                fileOutputStream.flush();
            }

            zipEntry = zipInputStream.getNextEntry();
        }
        fileOutputStream.close();
    }
}
