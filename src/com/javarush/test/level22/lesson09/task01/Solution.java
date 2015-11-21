package com.javarush.test.level22.lesson09.task01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* Обращенные слова
В методе main с консоли считать имя файла, который содержит слова, разделенные пробелами.
Найти в тексте все пары слов, которые являются обращением друг друга. Добавить их в result.
Порядок слов first/second не влияет на тестирование.
Использовать StringBuilder.
Пример, "мор"-"ром", "трос"-"сорт"
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();
    public static List<Pair> result2 = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        ArrayList<String> arrayList = new ArrayList<>();

        while (fileReader.ready()) {
            String s[] = fileReader.readLine().split(" ");
            for (String i : s) {
                arrayList.add(i);
            }
        }
        fileReader.close();

        for (String i : arrayList) {
            StringBuilder iRev = new StringBuilder(i);
            iRev = iRev.reverse();

            if (arrayList.contains(iRev.toString())) {
                result2.add(new Pair(i, iRev.toString()));
            }
            for (Pair pair : result2) {
                if (!result.contains(pair)) {
                    result.add(pair);
                }
            }
        }

        System.out.println(arrayList);
        for (Pair i : result) {
            System.out.println(i);
        }
    }

    public static class Pair {
        String first;
        String second;

        public Pair(String s1, String s2) {
            this.first = s1;
            this.second = s2;
        }


        @Override
        public String toString() {
            return first == null && second == null ? "" :
                    first == null && second != null ? second :
                            second == null && first != null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
