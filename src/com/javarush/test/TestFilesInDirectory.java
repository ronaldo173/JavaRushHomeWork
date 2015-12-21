package com.javarush.test;

import java.io.File;
import java.io.FilenameFilter;

/**
 * Created by Santer on 21.12.2015.
 */
public class TestFilesInDirectory {
    public String PATH_TO_DIR = "C:\\Users\\Santer\\Desktop\\Development\\JavaRush\\JavaRushHomeWork\\tempJRfiles";

    public static void main(String[] args) {

        TestFilesInDirectory testFilesInDirectory = new TestFilesInDirectory();
        File[] filesInDir = testFilesInDirectory.files(testFilesInDirectory.PATH_TO_DIR);

        for (File file : filesInDir) {
            if (testFilesInDirectory.maskaCheck(file, ".jpg")) {
                System.out.println(file.getAbsoluteFile());
            }
        }

        System.out.println("\n\nSecond way:");
        File[] filesSecondWay = testFilesInDirectory.filesSecondWay(testFilesInDirectory.PATH_TO_DIR, ".jpg");
        for (File file : filesSecondWay) {
            System.out.println(file.getAbsoluteFile());
        }
    }

    public File[] files(String path) {
//        try {
//            wait();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        File folder = new File(path);
        return folder.listFiles();
    }

    private boolean maskaCheck(File file, String regMaska) {
        if (file.isDirectory()) {
            return false;
        }
        String fileAbPath = file.getAbsolutePath();
        String fileRashirenie = fileAbPath.substring(fileAbPath.lastIndexOf("."));
        if (fileRashirenie.equals(regMaska)) {
            return true;
        }
        return false;
    }

    public File[] filesSecondWay(String dir, final String maska) {
        File directory = new File(dir);

        File[] result = directory.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(maska);
            }
        });

        return result;
    }
}
