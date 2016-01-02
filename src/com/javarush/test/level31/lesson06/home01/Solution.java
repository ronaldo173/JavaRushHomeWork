package com.javarush.test.level31.lesson06.home01;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* Добавление файла в архив
В метод main приходит список аргументов.
Первый аргумент - полный путь к файлу fileName.
Второй аргумент - путь к zip-архиву.
Добавить файл (fileName) внутрь архива в директорию 'new'.
Если в архиве есть файл с таким именем, то заменить его.

Пример входных данных:
C:/result.mp3
C:/pathToTest/test.zip

Файлы внутри test.zip:
a.txt
b.txt

После запуска Solution.main архив test.zip должен иметь такое содержимое:
new/result.mp3
a.txt
b.txt

Подсказка: нужно сначала куда-то сохранить содержимое всех энтри,
а потом записать в архив все энтри вместе с добавленным файлом.
Пользоваться файловой системой нельзя.
*/
public class Solution {
    public static void main(String[] args) throws IOException {

        String fileName = args[0];
        String zipPath = args[1];

        addFilesToExistingArchive(zipPath, fileName);
    }

    private static void addFilesToExistingArchive(String zipPath, String fileName) throws IOException {
        File zipFile = new File(zipPath);
        //create temp file
        File tempFile = new File(zipPath.substring(0, zipPath.length() - 4) + "_temp" + zipPath.substring(zipPath.length() - 4));
        //rename our file to temp
        zipFile.renameTo(tempFile);

        FileInputStream fileInputStream = new FileInputStream(tempFile);
        ZipInputStream zipInputStream = new ZipInputStream(fileInputStream);
        ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(zipFile));

        //add new file
        File fileForAdd = new File(fileName);
        ZipEntry entryOfNewFile = new ZipEntry("new/" + fileForAdd.getName());
        zipOutputStream.putNextEntry(entryOfNewFile);
        Files.copy(fileForAdd.toPath(), zipOutputStream);
        //make split array of new path file to check it then
        String[] splitNewFile = entryOfNewFile.getName().split("\\\\|/");
//        System.out.println(entryOfNewFile.getName());

        //add other files
        ZipEntry zipEntry = null;
        byte[] buff = new byte[4096];
        while ((zipEntry = zipInputStream.getNextEntry()) != null) {

            ZipEntry entryForAdd = new ZipEntry(zipEntry.getName());
            String[] split = entryForAdd.getName().split("\\\\|/");
            //check if added file contains in old archive, it will be instead of all
            if (!Arrays.deepEquals(split, splitNewFile)) {
                zipOutputStream.putNextEntry(entryForAdd);
                int len;
                while ((len = zipInputStream.read(buff)) > 0) {
                    zipOutputStream.write(buff, 0, len);
                }
            }
        }

        zipInputStream.close();
        fileInputStream.close();
        zipOutputStream.close();
        tempFile.delete();
    }
}
