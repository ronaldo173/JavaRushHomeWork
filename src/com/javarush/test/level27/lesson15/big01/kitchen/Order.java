package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.Tablet;

import java.io.IOException;
import java.util.List;

/**
 * Created by Santer on 14.01.2016.
 */
public class Order {
    private Tablet tablet;
    private List<Dish> dishes;

    public Order(Tablet tablet) {
        try {
            this.tablet = tablet;
            this.dishes = ConsoleHelper.getAllDishesForOrder();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        String result = "";

        if (dishes == null) {
            return result;
        }
        if (dishes.isEmpty()) {
            return result;
        } else {
            return "Your order: " + dishes + " of Tablet{number=" + tablet.getNumber() + "}";
        }
    }
}
/*
3. Вернемся к классу Order: в нем есть ссылка на планшет, и еще есть список выбранных блюд.
Создайте поле dishes - список блюд. Инициализируйте его в конструкторе, вызвав метод getAllDishesForOrder из ConsoleHelper.

4. Перепишите метод toString в классе Order. Пусть он возвращает пустую строку, если нет блюд в заказе, иначе
вывод должен быть аналогичный примеру в порядке добавления блюд. Используйте ConsoleHelper.
Пример:
Your order: [Juice, Fish] of Tablet{number=5}

 */