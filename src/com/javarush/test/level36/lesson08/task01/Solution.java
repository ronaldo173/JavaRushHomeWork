package com.javarush.test.level36.lesson08.task01;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;
import java.util.TreeSet;

/* Использование TreeSet
Первым параметром приходит имя файла: файл1.
файл1 содержит только буквы латинского алфавита, пробелы, знаки препинания, тире, символы перевода каретки.
Отсортировать буквы по алфавиту и вывести на экран первые 5 различных букв в одну строку без разделителей.
Если файл1 содержит менее 5 различных букв, то вывести их все.
Буквы различного регистра считаются одинаковыми.
Регистр выводимых букв не влияет на результат.
Закрыть потоки.

Пример 1 данных входного файла:
zBk yaz b-kN
Пример 1 вывода:
abkny

Пример 2 данных входного файла:
caAC
A, aB? bB
Пример 2 вывода:
abc

Подсказка: использовать TreeSet
*/
public class Solution {
    public static void main(String[] args) throws IOException {

        if (args.length < 1) {
            return;
        }

        String result = sortByLetters(Paths.get(args[0]));
        System.out.println(result);
    }

    private static String sortByLetters(Path path) {
        File file = path.toFile();
        StringBuilder builder = new StringBuilder();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String temp = bufferedReader.readLine();

            while (temp != null) {
                String[] split = temp.split("\\W");
                for (String s : split) {
                    builder.append(s);
                }
                temp = bufferedReader.readLine();
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return getSortedLettersFromString(builder);
    }

    private static String getSortedLettersFromString(StringBuilder builder) {
        StringBuilder result = new StringBuilder();
        Set<java.lang.Character> set = new TreeSet<>();

        for (char c : builder.toString().toCharArray()) {
            set.add(Character.toLowerCase(c));
        }
        for (Character character : set) {
            result.append(character);
        }

        if (result.length() < 5) {
            return result.toString();
        }
        return result.substring(0, 5);
    }
}
