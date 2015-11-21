package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки. Не использовать try-with-resources

Пример вывода:
, 19
- 7
f 361
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName;
        fileName = args[0];
//        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
//        fileName=reader.readLine();
//        reader.close();
        FileInputStream fileInputStream = new FileInputStream(fileName);

        byte[] buffer = new byte[fileInputStream.available()];
        char[] buffer2 = new char[0];


        while (fileInputStream.available() > 0) {
            fileInputStream.read(buffer);
            buffer2 = new String(buffer).toCharArray();
        }
        fileInputStream.close();

        Map<Character, Integer> map = new TreeMap<>();
        //for(byte a: buffer) map.put(a, 1);


        int count = 0;
        for (char a : buffer2) {
            for (char a1 : buffer2) {
                if (a == a1) {
                    count++;
                }
            }
            map.put(a, count);
            count = 0;
        }

        for (Map.Entry<Character, Integer> a : map.entrySet()) {
            System.out.println(a.getKey() + " " + a.getValue());
        }

    }
}
