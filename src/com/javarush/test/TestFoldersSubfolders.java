package com.javarush.test;

import java.io.File;

/**
 * Created by Santer on 30.12.2015.
 */
public class TestFoldersSubfolders {
    public static void main(String[] args) {
        String path = "C:\\Users\\Santer\\Desktop\\Development\\JavaRush\\JavaRushHomeWork\\tempJRfiles";
        deleteEmptySubFOlders(path);
    }

    private static void deleteEmptySubFOlders(String path) {
        File file = new File(path);
    }
}
