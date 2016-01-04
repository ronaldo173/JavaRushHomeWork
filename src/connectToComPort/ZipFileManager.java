package connectToComPort;

import com.javarush.test.level31.lesson15.big01.FileManager;
import com.javarush.test.level31.lesson15.big01.exception.PathIsNotFoundException;
import org.junit.Test;

import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
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

    public void createZip(Path source) throws Exception {
        if (!zipFile.getParent().toFile().exists()) {
            zipFile.toFile().createNewFile();
        }
        try (ZipOutputStream zipOutputStream = new ZipOutputStream(Files.newOutputStream(zipFile))
        ) {
            if (Files.isRegularFile(source)) {

                addNewZipEntry(zipOutputStream, source.getParent(), source.getFileName());

            } else if (Files.isDirectory(source)) {
                FileManager fileManager = new FileManager(source);
                List<Path> fileNames = fileManager.getFileList();

                for (Path path : fileNames) {
                    addNewZipEntry(zipOutputStream, source, path);
                }
            } else {
                throw new PathIsNotFoundException();
            }
        }
    }

    private void addNewZipEntry(ZipOutputStream zipOutputStream, Path filePath,
                                Path fileName) throws Exception {
        try (InputStream inputStream = Files.newInputStream(filePath.resolve(fileName))) {
            ZipEntry entry = new ZipEntry(fileName.toString());
            zipOutputStream.putNextEntry(entry);

            copyData(inputStream, zipOutputStream);
            zipOutputStream.closeEntry();
        }
    }

    private void copyData(InputStream in, OutputStream out) throws Exception {
        int sizeOfBuf;
        byte[] buff = new byte[1024];

        while ((sizeOfBuf = in.read(buff, 0, 1024)) > -1) {
            out.write(buff, 0, sizeOfBuf);
        }
        out.flush();
    }

    @Test
    public void test() {
        System.out.println("1");
    }
}

