package com.javarush.test.level31.lesson15.big01.command;

import com.javarush.test.level31.lesson15.big01.ConsoleHelper;
import com.javarush.test.level31.lesson15.big01.ZipFileManager;
import com.javarush.test.level31.lesson15.big01.exception.PathIsNotFoundException;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Santer on 03.01.2016.
 */
public class ZipExtractCommand extends ZipCommand {
    @Override
    public void execute() throws Exception {
        try {
            ConsoleHelper.writeMessage("Распаковка архива.");
            ZipFileManager zipFileManager = getZipFileManager();

            ConsoleHelper.writeMessage("Введите путь для распаковки:");
            Path sourcePath = Paths.get(ConsoleHelper.readString());
            zipFileManager.extractAll(sourcePath);

            ConsoleHelper.writeMessage("Распаковано!");

        } catch (PathIsNotFoundException e) {
            ConsoleHelper.writeMessage("Вы неверно указали имя файла или директории.");

        }

    }
}
/*
4.	Реализуй метод execute() класса ZipExtractCommand, по аналогии с таким же методом класса
ZipCreateCommand, сделай такой же блок try-catch, только поменяй сообщения выводимые
пользователю, чтобы он понял, что сейчас мы будем распаковывать архив, и что нужно ввести
полное имя архива и директорию, куда будем распаковывать. Не забудь вызвать метод extractAll
класса ZipFileManager, а не createZip, как это было в ZipCreateCommand
5.	Запускай программу и наслаждайся результатом распаковки
 */