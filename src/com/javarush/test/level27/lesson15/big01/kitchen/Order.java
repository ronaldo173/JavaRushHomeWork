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

    public Order(Tablet tablet) throws IOException {

            this.tablet = tablet;
            this.dishes = ConsoleHelper.getAllDishesForOrder();


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

    public int getTotalCookingTime() {
        int res = 0;

        for (Dish dish : dishes) {
            res += dish.getDuration();
        }
        return res;
    }

    public boolean isEmpty() {
        return dishes.isEmpty();
    }
}
/*
3. Запустим приложение и сразу введем 'exit'. Вывод получился не очень красивым.
Сделайте так, что если в заказе нет блюд, то чтобы он не отправлялся повару. Найдите это место и реализуйте логику.
В классе Order создайте вспомогательный метод  boolean isEmpty(), который будет определять, есть ли какие либо блюда в заказе.
Подсказка: используйте одноименный метод

4. Запустим приложение и введем 'fff', 'Soup' и 'exit'. В итоге наш заказ - Your order: [Soup], а 'fff' проигнорировано.
Давай уведомим пользователя, что блюда 'fff' нет. Выведем аналогичную фразу
fff is not detected
 */