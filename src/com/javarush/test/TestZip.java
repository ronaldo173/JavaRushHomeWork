package com.javarush.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created by Santer on 01.01.2016.
 */
public class TestZip {
    public static void main(String[] args) throws IOException, InterruptedException {
        String path = "C:\\Users\\Santer\\Desktop\\Development\\JavaRush\\JavaRushHomeWork\\tempJRfiles\\testZ.txt";
        createZip(path);
    }

    private static void createZip(String path) throws IOException, InterruptedException {
        FileOutputStream zipFile = new FileOutputStream(path + ".zip");//create zip
        ZipOutputStream zipOutputStream = new ZipOutputStream(zipFile);

        zipOutputStream.putNextEntry(new ZipEntry("doc.txt"));//put in zip

        File file = new File(path);
        Files.copy(file.toPath(), zipOutputStream);

        zipOutputStream.close();
        zipFile.close();
    }
}
