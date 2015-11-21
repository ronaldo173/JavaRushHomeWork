package com.javarush.test.level18.lesson10.home08;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        ArrayList<String> arrayList = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName;
        while (!(fileName = reader.readLine()).equals("exit")) {
            arrayList.add(fileName);
        }
        reader.close();
//        System.out.println(arrayList);
        for (String s : arrayList) {
            (new ReadThread(s)).start();
        }

//        for(Map.Entry<String, Integer> a: resultMap.entrySet()){
//            System.out.println(a.getKey() + " " + a.getValue());
//        }

    }

    public static class ReadThread extends Thread {
        private String fileName;

        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;
        }

        // implement file reading here - реализуйте чтение из файла тут
        public void run() {
            FileInputStream fileInputStream = null;
            ArrayList<Integer> arrayList = new ArrayList<>();
            int maxFrequency = 0;
            int byteAmount = 0;

            try {
                fileInputStream = new FileInputStream(this.fileName);
                while (fileInputStream.available() > 0) {
                    arrayList.add(fileInputStream.read());
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            for (int i = 0; i < arrayList.size(); i++) {
                int temp = Collections.frequency(arrayList, arrayList.get(i));
                if (maxFrequency < temp) {
                    maxFrequency = temp;
                    byteAmount = arrayList.get(i);
                }
            }
            resultMap.put(fileName, byteAmount);


        }
    }
}
