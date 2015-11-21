package com.javarush.test.level19.lesson10.home01;

/* Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName = args[0];
        //HashMap<String, Double> map=new HashMap<>();
        TreeMap<String, Double> map = new TreeMap<>();

        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String s;
        while ((s = reader.readLine()) != null) {
            String name = s.split(" ")[0];
            Double amount = Double.parseDouble(s.split(" ")[1]);

            if (map.containsKey(name)) {
                for (Map.Entry<String, Double> i : map.entrySet()) {
                    if (i.getKey().equals(name)) {
                        i.setValue(i.getValue() + amount);
                    }
                }
            } else {
                map.put(name, amount);
            }
        }
        reader.close();

        for (Map.Entry<String, Double> i : map.entrySet()) {
            System.out.println(i.getKey() + " " + i.getValue());
        }
        //System.out.println(map.toString());

    }
}
