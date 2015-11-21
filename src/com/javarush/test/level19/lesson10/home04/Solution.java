package com.javarush.test.level19.lesson10.home04;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* Ищем нужные строки
Считать с консоли имя файла.
Вывести в консоль все строки из файла, которые содержат всего 2 слова из списка words
Закрыть потоки. Не использовать try-with-resources

Пример: words содержит слова А, Б, В
Строки:
В Б А Д  //3 слова из words, не подходит
Д А Д    //1 слово из words, не подходит
Д А Б Д  //2 слова - подходит, выводим
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        String s;
        //cчитываю с файла
        while ((s = fileReader.readLine()) != null) {
            int count = 0;
            String str[] = s.split(" ");
            Set<String> set = new HashSet<>();//////заполняю сет уникальными словами из строки
            for (String i : str) {
                set.add(i);
            }
            for (String i : words) {
                if (set.contains(i)) count++;/////////если сет содержит слово из списка count++
            }

            if (count == 2) {
                System.out.println(s);
            }

            //count=0;str=null;set.removeAll(set);
        }
        fileReader.close();

    }
}
