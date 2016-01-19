package com.javarush.test.level26.lesson15.big01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Alex on 18.01.2016.
 */
public class ConsoleHelper {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() {
        String result = null;
        try {
            result = reader.readLine();
        } catch (IOException e) {
            //NONE
        }
        return result;

    }
}
/**
 * Задание 2
 * 1. Создадим в ConsoleHelper два статических метода:
 * 1.1 writeMessage(String message), который будет писать в консоль наше сообщение
 * 1.2 String readString(), который будет считывать с консоли строку и возвращать ее.
 * Если возникнет какое-то исключение при работе с консолью, то перехватим его и не будем обрабатывать.
 * Кстати, создадим только один экземпляр BufferedReader-а
 * <p/>
 * 2. Создадим пакет exception, в который поместим два checked исключения:
 * 2.1 InterruptOperationException будем кидать, когда нужно прервать текущую операцию и выйти из приложения
 * 2.2 NotEnoughMoneyException будем кидать, когда не сможем выдать запрашиваемую сумму
 **/