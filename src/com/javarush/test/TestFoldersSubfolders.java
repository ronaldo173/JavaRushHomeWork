package com.javarush.test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Santer on 30.12.2015.
 */
public class TestFoldersSubfolders {
    private static List<File> list;

    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\Santer\\Desktop\\Development\\JavaRush\\JavaRushHomeWork\\tempJRfiles\\";

        List<File> files = getAllFiles(path);
        for (File file : files) {
            System.out.println(file);
        }

    }

    private static List<File> getAllFiles(String path) {
        if (list == null) {
            list = new ArrayList<>();
        }
        File file = new File(path);
        if (file.isDirectory()) {
            for (File file1 : file.listFiles()) {
                getAllFiles(file1.getAbsolutePath());
            }
        } else list.add(file);

        return list;
    }

    private static void rename(String path, String newName) {
        Path path1 = new File(path).toPath();

        try {
            Files.move(path1, path1.resolveSibling(newName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void deleteEmptySubFOlders(String path) {
        File file = new File(path);

        if (file.isDirectory()) {
            if (file.listFiles().length == 0) {
                file.delete();
            } else {
                for (File file1 : file.listFiles()) {
                    deleteEmptySubFOlders(file1.getAbsolutePath());
                }
            }
        }
    }
}
