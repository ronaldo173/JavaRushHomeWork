package com.javarush.test.level30.lesson02.task01;

/* Осваиваем методы класса Integer
Используя метод Integer.parseInt(String, int) реализуйте логику метода convertToDecimalSystem,
который должен переводить переданную строку в десятичное число и возвращать его в виде строки.
*/
public class Solution {

    public static void main(String[] args) {

        System.out.println(convertToDecimalSystem("0x16")); //22
        System.out.println(convertToDecimalSystem("012"));  //10
        System.out.println(convertToDecimalSystem("0b10")); //2
        System.out.println(convertToDecimalSystem("-62"));   //62
    }

    public static String convertToDecimalSystem(String s) {

        char[] array = s.toCharArray();

        if (array.length > 2) {
            if (array[0] == '0' && array[1] == 'x') {
                return String.valueOf(Integer.parseInt(s.substring(2), 16));
            } else if (array[0] == '0' && isDigit(array[1])) {
                return String.valueOf(Integer.parseInt(s.substring(1), 8));
            } else if (array[0] == '0' && array[1] == 'b') {
                return String.valueOf(Integer.parseInt(s.substring(2), 2));
            }
        }

        return String.valueOf(Integer.parseInt(s));
    }

    private static boolean isDigit(char c) {

        return (c >= '0' && c <= '9');
    }
}
