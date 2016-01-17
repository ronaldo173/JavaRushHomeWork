package com.javarush.test.level27.lesson15.big01.kitchen;

/**
 * Created by Santer on 14.01.2016.
 */
public enum Dish {
    Fish(25), Steak(30), Soup(15), Juice(5), Water(3);

    private int duration;

    Dish(int i) {
        this.duration = i;
    }

    public static String allDishesToString() {
        String result = "";

        for (Dish dish : Dish.values()) {
            result += dish + ", ";
        }
        return result.substring(0, result.length() - 2);
    }

    public int getDuration() {
        return duration;
    }
}
/*
1. Предположим, у нас известно время приготовления каждого блюда в минутах. Захардкодим его в классе Dish.
1.1. Измените создание элементов энама - Fish(25), Steak(30), Soup(15), Juice(5), Water(3);
1.2. Создайте поле private int duration с геттером.
Чтобы создать геттер, нажмите Alt+Insert и выберите пункт Getter. Далее выберите имя поля и нажмите OK(Enter).

 */