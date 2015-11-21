package com.javarush.test.level20.lesson02.task03;

import java.io.*;
import java.util.Map;
import java.util.Properties;

/* Знакомство с properties
В методе fillInPropertiesMap считайте имя файла с консоли и заполните карту properties данными из файла.
Про .properties почитать тут - http://ru.wikipedia.org/wiki/.properties
Реализуйте логику записи в файл и чтения из файла для карты properties.
*/
public class Solution {
    private static Properties properties;
    private static String fileName;

    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        solution.fillInPropertiesMap();
    }

    public void fillInPropertiesMap() throws IOException {
        //implement this method - реализуйте этот метод
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ) {
            fileName = reader.readLine();
            System.out.println("fileName: " + fileName);//test
        }

        properties = new Properties();
        properties.load(new FileInputStream(fileName));
        System.out.println(properties);
//        for (Map.Entry<Object, Object> prop : properties.entrySet()) {
//            System.out.println(prop.getKey() + " " + prop.getValue());
//        }

}

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
    }
}
