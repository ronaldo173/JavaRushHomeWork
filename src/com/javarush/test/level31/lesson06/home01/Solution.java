package com.javarush.test.level31.lesson06.home01;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
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
        if (args.length < 2) {
            return;
        }
        String fileName = args[0];
        String zipPath = args[1];

        Path pathName = Paths.get(fileName);
        Path pathToFile = Paths.get(zipPath);

        if (!pathToFile.toFile().exists()) {
            Files.createFile(pathToFile);
        }
        if (pathName.toFile().exists()) {
            return;
        }

        addToZip(pathToFile, pathName);

    }

    public static void addToZip(Path zipFile, Path newFile) throws IOException {
        Path tempZip = Files.createTempFile("temp", ".zip");
        String tempRelativeWithoutNew = "new/" + zipFile.getParent().relativize(newFile);
        Path relativePath = Paths.get(tempRelativeWithoutNew);

        try (ZipOutputStream zipOutputStream = new ZipOutputStream(Files.newOutputStream(tempZip))) {
            try (ZipInputStream zipInputStream = new ZipInputStream(Files.newInputStream(zipFile))) {

                ZipEntry zipEntry = zipInputStream.getNextEntry();
                while (zipEntry != null) {
                    Path pathOfFileInZip = Paths.get(zipEntry.getName());
                    if (!pathOfFileInZip.equals(relativePath)) {
                        zipOutputStream.putNextEntry(zipEntry);
                        copyData(zipInputStream, zipOutputStream);
                    }
                    zipEntry = zipInputStream.getNextEntry();
                }
                zipInputStream.closeEntry();
            }
            FileInputStream fileInputStream = new FileInputStream(newFile.toFile());
            ZipEntry zipEntry = new ZipEntry(relativePath.toString());
            zipOutputStream.putNextEntry(zipEntry);
            copyData(fileInputStream, zipOutputStream);
            zipOutputStream.closeEntry();

        }
        Files.move(tempZip, zipFile, StandardCopyOption.REPLACE_EXISTING);
    }

    private static void copyData(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] buffer = new byte[1024];
        int len;
        while ((len = inputStream.read(buffer)) > 0) {
            outputStream.write(buffer, 0, len);
        }
    }

}
