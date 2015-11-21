package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName = args[0];
        HashMap<String, Double> map = new HashMap<>();

        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String s;
        while ((s = reader.readLine()) != null) {
            String name = s.split(" ")[0];
            Double zna4enie = Double.parseDouble(s.split(" ")[1]);
            if (map.containsKey(name)) {
                for (Map.Entry<String, Double> a : map.entrySet()) {
                    if (a.getKey().equals(name)) {
                        a.setValue(a.getValue() + zna4enie);
                    }
                }
            } else {
                map.put(name, zna4enie);
            }
        }
        reader.close();

        double max = 0;
        String maxName = null;
        for (Map.Entry<String, Double> a : map.entrySet()) {
            if (a.getValue() > max) {
                max = a.getValue();
                maxName = a.getKey();
            }
        }
        System.out.println(maxName);
    }
}
