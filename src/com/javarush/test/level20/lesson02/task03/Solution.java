package com.javarush.test.level20.lesson02.task03;

import java.io.*;
import java.util.*;

/* Знакомство с properties
В методе fillInPropertiesMap считайте имя файла с консоли и заполните карту properties данными из файла.
Про .properties почитать тут - http://ru.wikipedia.org/wiki/.properties
Реализуйте логику записи в файл и чтения из файла для карты properties.
*/
public class Solution {
    private static Map<String, String> mapProperty;
    private static String fileName, savedFileName;
    private static File saveFile;

    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        solution.fillInPropertiesMap();

        savedFileName = "saved" + fileName;
        saveFile = new File(savedFileName);
        if (!saveFile.exists()) {
            saveFile.createNewFile();
        }

        try (FileOutputStream fileOutputStream = new FileOutputStream(saveFile)) {
            solution.save(fileOutputStream);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void fillInPropertiesMap() throws IOException {
        //implement this method - реализуйте этот метод
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ) {
            fileName = reader.readLine();
            System.out.println("fileName: " + fileName);//test
        }
        try (
                InputStream inputStreamProp = new FileInputStream(fileName)
        ) {
            load(inputStreamProp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        try (
                PrintWriter printWriter = new PrintWriter(outputStream)) {
            for (Map.Entry<String, String> prop : mapProperty.entrySet()) {
                String stringForFile = prop.getKey() + " = " + prop.getValue();
//                System.out.println(stringForFile); //test
                printWriter.println(stringForFile);
            }
        }
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties tempProp;
        tempProp = new Properties();
        mapProperty = new LinkedHashMap<>();

        tempProp.load(inputStream);
        List<String> list = new ArrayList<>(tempProp.stringPropertyNames());
        Collections.reverse(list);
        System.out.println(list);

        for (String s : list) {
            mapProperty.put(s, tempProp.getProperty(s));
        }
    }
}
