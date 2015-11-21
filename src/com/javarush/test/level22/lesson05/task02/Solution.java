package com.javarush.test.level22.lesson05.task02;

/* Между табуляциями
Метод getPartOfString должен возвращать подстроку между первой и второй табуляцией.
На некорректные данные бросить исключение TooShortStringException.
Класс TooShortStringException не менять.
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        if (string == null) {
            throw new TooShortStringException();
        }
        int indexofTab = string.indexOf("\t");
        if (indexofTab == -1) {
            throw new TooShortStringException();
        }
        string = string.substring(indexofTab + 1);
        indexofTab = string.indexOf("\t");
        if (indexofTab == -1) {
            throw new TooShortStringException();
        }
        string = string.substring(0, indexofTab);

        return string;
    }

    public static void main(String[] args) throws TooShortStringException {
        String str = "JavaRush - 1 лучший сервис\t обучения \tJava.";
        System.out.println(getPartOfString(str));

    }

    public static class TooShortStringException extends Exception {
    }
}
