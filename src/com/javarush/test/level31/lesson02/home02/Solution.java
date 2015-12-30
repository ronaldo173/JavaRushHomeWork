package com.javarush.test.level31.lesson02.home02;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/* Находим все файлы
Реализовать логику метода getFileTree, который должен в директории root найти список всех файлов включая вложенные.
Используйте очередь, рекурсию не используйте.
Верните список всех путей к найденным файлам, путь к директориям возвращать не надо.
Путь должен быть абсолютный.
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {

        List<String> list = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            File childFile = new File(queue.poll());
            if (childFile.isDirectory()) {
                for (File file : childFile.listFiles()) {
                    queue.add(file.getAbsolutePath());
                }
            } else if (childFile.isFile()) {
                list.add(childFile.getAbsolutePath());
            }
        }
        return list;
    }

    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\Santer\\Desktop\\Development\\JavaRush\\JavaRushHomeWork\\tempJRfiles\\check";
        List<String> fileTree = getFileTree(path);
        for (String s : fileTree) {
            System.out.println(s);
        }
    }
}
