package com.javarush.test.level27.lesson15.big01.kitchen;


import com.javarush.test.level27.lesson15.big01.ConsoleHelper;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Santer on 14.01.2016.
 */
public class Cook extends Observable implements Observer {
    private String name;

    public Cook(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void update(Observable o, Object arg) {
        Order order = (Order) arg;
        if (!order.isEmpty()) {

            ConsoleHelper.writeMessage("Start cooking - " + order + ", cooking time " + order.getTotalCookingTime() + "min");
            setChanged();
            notifyObservers(order);
        }
    }

}
/*
2.4. Добавим нашему повару вывод в консоль этой информации. Пусть теперь выводится аналогичное сообщение:
Start cooking - Your order: [Soup, Juice, Water] of Tablet{number=5}, cooking time 23min
 */