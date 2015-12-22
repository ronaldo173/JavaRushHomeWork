package com.javarush.test.level20.lesson02.task03;

import java.io.*;
import java.util.*;

/* Знакомство с properties
В методе fillInPropertiesMap считайте имя файла с консоли и заполните карту properties данными из файла.
Про .properties почитать тут - http://ru.wikipedia.org/wiki/.properties
Реализуйте логику записи в файл и чтения из файла для карты properties.
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public static void main(String[] args) throws Exception {

    }

    public void fillInPropertiesMap() {
        try {
            BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
            String fileName = console.readLine();
            FileInputStream fin = new FileInputStream(fileName);
            Properties props = new Properties();
            props.load(fin);
            for (Map.Entry<Object, Object> pairs : props.entrySet()) {
                properties.put((String) pairs.getKey(), (String) pairs.getValue());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void save(OutputStream outputStream) throws Exception {
        Properties props = new Properties();
        for (Map.Entry<String, String> pairs : properties.entrySet()) {
            props.put(pairs.getKey(), pairs.getValue());
        }
        props.store(outputStream, "");
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties props = new Properties();
        props.load(inputStream);

        for (Map.Entry<Object, Object> pairs : props.entrySet()) {
            properties.put((String) pairs.getKey(), (String) pairs.getValue());
        }
    }
}