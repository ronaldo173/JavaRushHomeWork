package com.javarush.test.level33.lesson15.big01.strategies;

import com.javarush.test.level33.lesson15.big01.ExceptionHandler;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Created by Santer on 11.01.2016.
 */
public class FileBucket {
    private Path path;

    public FileBucket() {
        try {
            this.path = Files.createTempFile(null, null);

            if (path.toFile().exists()) {
                path.toFile().delete();
            }
            Files.createFile(path);
        } catch (Exception e) {
            ExceptionHandler.log(e);
        }
        path.toFile().deleteOnExit();
    }

    public long getFileSize() {
        try {
            return Files.size(path);
        } catch (IOException e) {
            ExceptionHandler.log(e);
        }
        return 0;
    }

    public void putEntry(Entry entry) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(path.toFile());
             ObjectOutputStream out = new ObjectOutputStream(fileOutputStream)) {
            out.writeObject(entry);

        } catch (Exception e) {
            ExceptionHandler.log(e);
        }
    }

    public Entry getEntry() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(path.toFile()))) {
            {
                return (Entry) in.readObject();
            }
        } catch (Exception e) {
            ExceptionHandler.log(e);
        }
        return null;
    }

    public void remove() {
        path.toFile().delete();
    }

}
/*
Напишем еще одну стратегию, назовем ее FileStorageStrategy. Она будет очень похожа
на стратегию OurHashMapStorageStrategy, но в качестве ведер (англ. buckets) будут
файлы. Я знаю, ты знаешь о каких buckets идет речь, если нет – повтори внутреннее
устройство HashMap.
9.1.	Создай класс FileBucket в пакете strategies.
9.2.	Добавь в класс поле Path path. Это будет путь к файлу.
9.3.	Добавь в класс конструктор, он должен:
9.3.1.	Инициализировать path временным файлом. Файл должен быть размещен
в директории для временных файлов и иметь случайное имя. Подсказка:
Files.createTempFile.
9.3.2.	Создавать новый файл, используя path. Если такой файл уже есть, то
заменять его.
9.3.3.	Обеспечивать удаление файла при выходе из программы. Подсказка:
deleteOnExit().
9.4.	Добавь в класс методы:
9.4.1.	long getFileSize(), он должен возвращать размер файла на который
указывает path.
9.4.2.	void putEntry(Entry entry) - должен сериализовывать переданный entry в
файл. Учти, каждый entry может содержать еще один entry.
9.4.3.	Entry getEntry() - должен забирать entry из файла. Если файл имеет нулевой
размер, вернуть null.
9.4.4.	void remove() – удалять файл на который указывает path.
Конструктор и методы не должны кидать исключения.
 */