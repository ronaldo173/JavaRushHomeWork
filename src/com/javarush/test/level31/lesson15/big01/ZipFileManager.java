package com.javarush.test.level31.lesson15.big01;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created by Santer on 02.01.2016.
 */
public class ZipFileManager {
    private Path zipFile;

    public ZipFileManager(Path zipFile) {
        this.zipFile = zipFile;
    }

    public void createZip(Path sourse) throws Exception {


        try (ZipOutputStream zipOutputStream = new ZipOutputStream(Files.newOutputStream(zipFile))
        ) {
            ZipEntry zipEntry = new ZipEntry(sourse.getFileName().toString());
            zipOutputStream.putNextEntry(zipEntry);

            try (InputStream inputStream = Files.newInputStream(sourse)) {
                byte[] buffer = new byte[1024];
                int readBytes;
                while ((readBytes = inputStream.read(buffer, 0, 1024)) > -1) {
                    zipOutputStream.write(buffer, 0, readBytes);
                }

                zipOutputStream.flush();
            }
            zipOutputStream.closeEntry();
        }
    }
}
