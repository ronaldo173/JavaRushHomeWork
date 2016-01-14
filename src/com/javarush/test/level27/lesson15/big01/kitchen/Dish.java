package com.javarush.test.level27.lesson15.big01.kitchen;

/**
 * Created by Santer on 14.01.2016.
 */
public enum Dish {
    Fish, Steak, Soup, Juice, Water;

    public static String allDishesToString() {
        String result = "";

        for (Dish dish : Dish.values()) {
            result += dish + ", ";
        }
        return result.substring(0, result.length() - 2);
    }
}
/*
5. Чтобы пользователь мог выбрать себе блюда, нужно их все ему отобразить. Для этого в Dish создайте метод
public static String allDishesToString(), который сформирует строку из всех блюд.
Пример, "Fish, Steak, Soup, Juice, Water". Формируйте строку динамически.

 */