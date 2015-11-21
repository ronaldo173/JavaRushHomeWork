package com.javarush.test.level08.lesson11.home05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Мама Мыла Раму. Теперь с большой буквы
Написать программу, которая вводит с клавиатуры строку текста.
Программа заменяет в тексте первые буквы всех слов на заглавные.
Вывести результат на экран.

Пример ввода:
  мама     мыла раму.

Пример вывода:
  Мама     Мыла Раму.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();

        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {

            arr[0] = Character.toUpperCase(arr[0]);
            Character a = arr[i];
            if (a.equals(' ')) {
                arr[i + 1] = Character.toUpperCase(arr[i + 1]);
            }
        }

        //напишите тут ваш код
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }


}
