package com.javarush.test.level19.lesson08.task04;

/* Решаем пример
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна выводить на консоль решенный пример
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Возможные операции: + - *
Шаблон входных данных и вывода: a [знак] b = c
Отрицательных и дробных чисел, унарных операторов - нет.

Пример вывода:
3 + 6 = 9
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleOut = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        testString.printSomething();
        String s = outputStream.toString();

        System.setOut(consoleOut);

        s = s.replace("=", "");
        String[] primer = s.split(" ");

        int a = Integer.parseInt(primer[0]);
        int b = Integer.parseInt(primer[2]);
        int result;
        if (primer[1].equals("+")) {
            result = a + b;
        } else if (primer[1].equals("-")) {
            result = a - b;
        } else result = a * b;

        System.out.println(a + " " + primer[1] + " " + b + " = " + result);

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

