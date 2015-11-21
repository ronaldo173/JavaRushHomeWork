package com.javarush.test.level18.lesson10.bonus01;

/* Шифровка
Придумать механизм шифровки/дешифровки

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName
где
fileName - имя файла, который необходимо зашифровать/расшифровать
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
-e - ключ указывает, что необходимо зашифровать данные
-d - ключ указывает, что необходимо расшифровать данные
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName, fileOutputName;
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;


        fileName = args[1];
        fileOutputName = args[2];
        fileInputStream = new FileInputStream(fileName);
        fileOutputStream = new FileOutputStream(fileOutputName);
        byte[] buffer = new byte[fileInputStream.available()];
        if (args[0].equals("-e")) {
            if (fileInputStream.available() > 0) {
                fileInputStream.read(buffer);
                for (int i = 0; i < buffer.length; i++) {
                    buffer[i] = (byte) (buffer[i] + 1);
                }

                fileOutputStream.write(buffer);
            }
        } else {
            if (fileInputStream.available() > 0) {
                fileInputStream.read(buffer);
                for (int i = 0; i < buffer.length; i++) {
                    buffer[i] = (byte) (buffer[i] - 1);
                }
                fileOutputStream.write(buffer);
            }
        }
        fileInputStream.close();
        fileOutputStream.close();
    }


}
