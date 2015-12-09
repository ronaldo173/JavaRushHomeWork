package com.javarush.test.level22.lesson13.task03;

/* Проверка номера телефона
Метод checkTelNumber должен проверять, является ли аргумент telNumber валидным номером телефона.
Критерии валидности:
1) если номер начинается с '+', то он содержит 12 цифр
2) если номер начинается с цифры или открывающей скобки, то он содержит 10 цифр
3) может содержать 0-2 знаков '-', которые не могут идти подряд
4) может содержать 1 пару скобок '(' и ')'  , причем если она есть, то она расположена левее знаков '-'
5) скобки внутри содержат четко 3 цифры
6) номер не содержит букв
7) номер заканчивается на цифру

Примеры:
+380501234567 - true
+38(050)1234567 - true
+38050123-45-67 - true
050123-4567 - true

+38)050(1234567 - false
+38(050)1-23-45-6-7 - false
050ххх4567 - false
050123456 - false
(0)501234567 - false
*/
public class Solution {

    public static boolean checkTelNumber(String telNumber) {

        return (telNumber.matches("^\\+(\\d[\\-\\(\\)]?){11}\\d$") || telNumber.matches("^[\\(\\d]-?(\\d[\\-\\)]?){8}\\d$"))
                && telNumber.matches("^(\\+)?(\\d)*(\\(\\d{3}\\))?(\\d+-?\\d+-?)?\\d+$");
    }

    public static boolean testReg(String telNumber) {

//        return stringForTest.matches("^\\+{1}[0-9\\-]{12,14}") || stringForTest.matches("^\\d{1}[0-9\\-]{9,}")
//                || stringForTest.matches("^\\({1}\\d{3}\\){1}(\\d[\\-]){7,}")
//                && stringForTest.matches(".*\\d$") && stringForTest.matches(".*\\-?\\d{1,}\\-?");
        return (telNumber.matches("^\\+(\\d[\\-\\(\\)]?){11}\\d$") || telNumber.matches("^[\\(\\d]-?(\\d[\\-\\)]?){8}\\d$"))
                && telNumber.matches("^(\\+)?(\\d)*(\\(\\d{3}\\))?(\\d+-?\\d+-?)?\\d+$");
    }

    public static void main(String[] args) {
//        System.out.println(checkTelNumber("+380501234567"));
//        System.out.println(checkTelNumber("+38(050)1234567"));
//        System.out.println(checkTelNumber("+38050123-45-67"));
//        System.out.println(checkTelNumber("050123-4567"));
//
//        String temp = "0501234567";
//        System.out.println(temp + " " + checkTelNumber(temp));
//        String temp2 = "(0501234567";
//        System.out.println(temp2 + " " + checkTelNumber(temp2));


        System.out.println("+380501234567 " + testReg("+380501234567"));
        System.out.println("+38(050)1234567 " + testReg("+38(050)1234567"));
        System.out.println("+38050123-45-67 " + testReg("+38050123-45-67"));
        System.out.println("050123-4567 " + testReg("050123-4567"));
        System.out.println("(050)1-234567 " + testReg("(050)1-234567"));

    }
}
