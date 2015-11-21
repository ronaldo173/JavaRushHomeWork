package com.javarush.test.level26.lesson15.big01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Саша on 21.09.2015.
 */
public class ConsoleHelper {
    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() {
        String res = "";
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            res = reader.readLine();
        } catch (IOException e) {

        } finally {
            try {
                reader.close();
            } catch (IOException e) {

            }
        }
        return res;
    }

    public static String askCurrencyCode() {
        writeMessage("Enter Currency code please:");
        String res = "";

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            while ((res = reader.readLine()).length() != 3) {
                System.out.println("Incorrect data, try again please!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return res.toUpperCase();
    }

    public static String[] getValidTwoDigits(String currencyCode) {
        writeMessage("Please enter 2integers > 0: ");
        String str = "";
        String[] result = new String[2];
        str = readString();

        return result;
    }
}

/*
Задание 4
1. Выберем операцию, с которой мы сможем начать.
Подумаем. В банкомате еще денег нет, поэтому INFO и WITHDRAW протестить не получится.
Начнем с операции DEPOSIT - поместить деньги.
Считаем с консоли код валюты, потом считаем номинал и количество банкнот, а потом добавим их в манипулятор.

2. Чтобы считать код валюты, добавим статический метод String askCurrencyCode() в ConsoleHelper.
Этот метод должен предлагать пользователю ввести код валюты, проверять, что код содержит 3 символа.
Если данные некорректны, то сообщить об этом пользователю и повторить.
Если данные валидны, то перевести код в верхний регистр и вернуть.

3. Чтобы считать номинал и количество банкнот, добавим статический метод String[] getValidTwoDigits(String currencyCode) в ConsoleHelper.
Этот метод должен предлагать пользователю ввести два целых положительных числа.
Первое число - номинал, второе - количество банкнот.
Никаких валидаторов на номинал нет. Т.е. 1200 - это нормальный номинал.
Если данные некорректны, то сообщить об этом пользователю и повторить.
Пример вводимых данных:
200 5

4. В классе CurrencyManipulator создайте метод void addAmount(int denomination, int count),
который добавит введенные номинал и количество банкнот

 */