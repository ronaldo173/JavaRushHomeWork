package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Santer on 14.01.2016.
 */
public class ConsoleHelper {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws IOException {
        return reader.readLine();
    }

    public static List<Dish> getAllDishesForOrder() throws IOException {
        List<Dish> list = new ArrayList<>();

        writeMessage("choose dish: ");
        writeMessage(Dish.allDishesToString());

        String temp = readString();

        while (!temp.equals("exit")) {
            list.add(Dish.valueOf(temp));
            temp = readString();
        }
        return list;
    }
}
/*
Создайте класс ConsoleHelper с единственным BufferedReader, через который будете работать с консолью.
Запомните, этот класс не хранит никаких данных и состояний, поэтому все методы будут статическими.
Создайте в нем три метода:
-writeMessage(String message) - для вывода message в консоль
-String readString() - для чтения строки с консоли
-List<Dish> getAllDishesForOrder() - просит ползователя выбрать блюдо и добавляет его в список. Введенное 'exit' означает завершение заказа.
исключения пробрасывайте выше, на этом уровне не понятно, что с ними делать.
 */