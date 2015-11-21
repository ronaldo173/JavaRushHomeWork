package com.javarush.test.level13.lesson11.home03;

/* Чтение файла
1. Считать с консоли имя файла.
2. Вывести в консоль(на экран) содержимое файла.
3. Не забыть закрыть файл и поток.
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //InputStreamReader stream=new InputStreamReader(reader.readLine());
        InputStream in = null;
        try {
            in = new FileInputStream(reader.readLine());
            while (in.available() > 0) {
                System.out.print((char) in.read());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
