package com.javarush.test.level18.lesson08.task04;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/* UnsupportedFileName
Измените класс TxtInputStream так, чтобы он работал только с txt-файлами (*.txt)
Например, first.txt или name.1.part3.txt
Если передан не txt-файл, например, file.txt.exe, то конструктор должен выбрасывать исключение UnsupportedFileNameException
*/

public class TxtInputStream extends FileInputStream {
    public TxtInputStream(String fileName) throws FileNotFoundException, UnsupportedFileNameException {
        super(fileName);

        char[] name = fileName.toCharArray();
        ArrayList<Character> format = new ArrayList<>();
        for (int i = name.length - 1; i > name.length - 5; i--) {
            format.add(0, name[i]);
        }
        String s = "";
        for (int i = 0; i < format.size(); i++) {
            s += format.get(i);
        }
//        System.out.println(s);
        if (!s.equals(".txt")) {
            throw new UnsupportedFileNameException();
        }
    }

    //test
//    public static void main(String[] args) throws IOException, UnsupportedFileNameException {
//        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
//        TxtInputStream txtInputStream=new TxtInputStream(reader.readLine());
//    }


}

