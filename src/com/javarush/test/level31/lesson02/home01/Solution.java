package com.javarush.test.level31.lesson02.home01;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.*;

/* Проход по дереву файлов
1. На вход метода main подаются два параметра.
Первый - path - путь к директории, второй - resultFileAbsolutePath - имя файла, который будет содержать результат.
2. Для каждого файла в директории path и в ее всех вложенных поддиректориях выполнить следующее:
2.1. Если у файла длина в байтах больше 50, то удалить его.
2.2. Если у файла длина в байтах НЕ больше 50, то для всех таких файлов:
2.2.1. отсортировать их по имени файла в возрастающем порядке, путь не учитывать при сортировке
2.2.2. переименовать resultFileAbsolutePath в 'allFilesContent.txt'
2.2.3. в allFilesContent.txt последовательно записать содержимое всех файлов из п. 2.2.1. Тела файлов разделять "\n"
2.3. Удалить директории без файлов (пустые).
Все файлы имеют расширение txt.
*/
public class Solution {

    private static List<File> list;

    public static void main(String[] args) {
        if (args.length < 2) {
            return;
        }
        String path = args[0];
        String resultFileAbsolutePath = args[1];
        String newName = "allFilesContent.txt";
        File fileResult = new File(resultFileAbsolutePath);

        if (path.equals(resultFileAbsolutePath)) {
            return;
        }
        List<File> allFiles = getAllFilesByPath(path);
        if (allFiles.contains(fileResult)) {
            allFiles.remove(fileResult);
        }
        ifMore50bytesDeleteFilesOr(allFiles);
        if (allFiles.size() != 0) {
            sortList(allFiles);
            fileResult = rename(fileResult, newName);
            writeFilesToFileWithSeparator(allFiles, fileResult);
        }
        deleteEmptyFolders(path);
    }

    private static void deleteEmptyFolders(String path) {
        if (path == null) {
            return;
        }
        File file = new File(path);
        if (file.isDirectory()) {
            if (file.listFiles().length == 0) {
                file.delete();
            } else {
                for (File file1 : file.listFiles()) {
                    deleteEmptyFolders(file1.getAbsolutePath());
                }
            }
        }
    }

    private static void writeFilesToFileWithSeparator(List<File> allFiles, File fileResult) {
        for (File file : allFiles) {
            try (
                    BufferedReader reader = new BufferedReader(new FileReader(file));
                    BufferedWriter writer = new BufferedWriter(new FileWriter(fileResult, true))
            ) {
                while (reader.ready()) {
                    writer.write(reader.readLine());
                    writer.newLine();
                }
//                writer.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static File rename(File fileForRename, String newName) {
        String resPath = fileForRename.getAbsolutePath();
        Path path = Paths.get(resPath);
        Path move = null;
        try {
            move = Files.move(path, path.resolveSibling(newName), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
        fileForRename.delete();
        return move.toFile();
    }

    private static void sortList(List<File> allFiles) {
        Collections.sort(allFiles, new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
    }

    private static void ifMore50bytesDeleteFilesOr(List<File> allFiles) {

        Iterator<File> iterator = allFiles.iterator();
        while (iterator.hasNext()) {
            File next = iterator.next();
            if (next.length() > 50 && !next.isDirectory()) {
                next.delete();
                iterator.remove();
            }
        }
    }

    private static List<File> getAllFilesByPath(String path) {

        if (list == null) {
            list = new ArrayList<>();
        }
        File file = new File(path);
        if (file.isDirectory()) {
            for (File file1 : file.listFiles()) {
                getAllFilesByPath(file1.getAbsolutePath());
            }
        } else list.add(file);

        return list;
    }
}
