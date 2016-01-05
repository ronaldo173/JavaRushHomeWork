package com.javarush.test.level31.lesson15.big01;

import com.javarush.test.level31.lesson15.big01.exception.PathIsNotFoundException;
import com.javarush.test.level31.lesson15.big01.exception.WrongZipFileException;

import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

public class ZipFileManager {
    // Полный путь zip файла
    private final Path zipFile;

    public ZipFileManager(Path zipFile) {
        this.zipFile = zipFile;
    }

    public void createZip(Path source) throws Exception {
        // Проверяем, существует ли директория, где будет создаваться архив
        // При необходимости создаем ее
        Path zipDirectory = zipFile.getParent();
        if (Files.notExists(zipDirectory))
            Files.createDirectories(zipDirectory);

        // Создаем zip поток
        try (ZipOutputStream zipOutputStream = new ZipOutputStream(Files.newOutputStream(zipFile))) {

            if (Files.isDirectory(source)) {
                // Если архивируем директорию, то нужно получить список файлов в ней
                FileManager fileManager = new FileManager(source);
                List<Path> fileNames = fileManager.getFileList();

                // Добавляем каждый файл в архив
                for (Path fileName : fileNames)
                    addNewZipEntry(zipOutputStream, source, fileName);

            } else if (Files.isRegularFile(source)) {

                // Если архивируем отдельный файл, то нужно получить его директорию и имя
                addNewZipEntry(zipOutputStream, source.getParent(), source.getFileName());
            } else {

                // Если переданный source не директория и не файл, бросаем исключение
                throw new PathIsNotFoundException();
            }
        }
    }

    private void addNewZipEntry(ZipOutputStream zipOutputStream, Path filePath, Path fileName) throws Exception {
        Path fullPath = filePath.resolve(fileName);
        try (InputStream inputStream = Files.newInputStream(fullPath)) {
            ZipEntry entry = new ZipEntry(fileName.toString());

            zipOutputStream.putNextEntry(entry);

            copyData(inputStream, zipOutputStream);

            zipOutputStream.closeEntry();
        }
    }

    private void copyData(InputStream in, OutputStream out) throws Exception {
        byte[] buffer = new byte[8 * 1024];
        int len;
        while ((len = in.read(buffer)) > 0) {
            out.write(buffer, 0, len);
        }
    }

    public List<FileProperties> getFilesList() throws Exception {
        if (!Files.isRegularFile(zipFile)) {
            throw new WrongZipFileException();
        }

        List<FileProperties> filePropertiesList = new ArrayList<>();

        ZipFile zipFil = new ZipFile(zipFile.toFile());
        Enumeration<? extends ZipEntry> entries = zipFil.entries();
        while (entries.hasMoreElements()) {
            ZipEntry entry = entries.nextElement();
            try (InputStream inputStream = zipFil.getInputStream(entry)) {
                filePropertiesList.add(new FileProperties(entry.getName(), entry.getSize(), entry.getCompressedSize(), entry.getMethod()));
            }
        }
        zipFil.close();

        return filePropertiesList;
    }

//    public static void main(String[] args) throws Exception {
//        ZipFileManager zipFileManager = new ZipFileManager(Paths.get("C:\\Users\\Santer\\Desktop\\Development\\JavaRush\\JavaRushHomeWork\\tempJRfiles\\res.zip"));
//        List<FileProperties> filesList = zipFileManager.getFilesList();
//
//        for (FileProperties fileProperties : filesList) {
//            System.out.println(fileProperties);
//        }
//    }
}
/*
﻿Задание 13.

Продолжим наш путь к получению содержимого файла архива. Напишем метод getFilesList() в классе
ZipFileManager. Он будет возвращать список файлов в архиве, вернее список свойств этих файлов (класс
свойств FileProperties мы уже реализовали). Итак:
1.	Добавь метод List<FileProperties> getFilesList() throws Exception в класс ZipFileManager
2.	Внутри метода проверь является ли содержимое zipFile обычным файлом с помощью
подходящего метода класса Files. Если это не файл, брось исключение WrongZipFileException().
3.	Создай список с элементами типа FileProperties, в него мы будем складывать свойства файлов
4.	Создай входящий поток ZipInputStream, для файла из переменной zipFile. Как и в прошлые разы, оберни его создание
в try-with-resources
5.	Пройдись по всем элементам ZipEntry потока ZipInputStream
6.	Для каждого элемента ZipEntry вычитай его содержимое, иначе у нас не будет информации о его
размере. Нельзя узнать размер файла в архиве, не вычитав его. Это очень легко сделать с
помощью функции copyData, используя временный буфер типа ByteArrayOutputStream.
7.	Получи имя, размер, сжатый размер и метод сжатия элемента архива. Посмотри, что еще можно
узнать о нем.
8.	Создай объект класса FileProperties, используя полученные данные о файле.
9.	Добавь созданный объект из п.8 в список из п.3
10.	После выхода из цикла верни собранную информацию вызвавшему методу.
 */
