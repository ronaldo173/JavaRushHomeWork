package com.javarush.test.level27.lesson15.big01.kitchen;


import com.javarush.test.level27.lesson15.big01.ConsoleHelper;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Santer on 14.01.2016.
 */
public class Cook extends Observable implements Observer   {
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
        ConsoleHelper.writeMessage("Start cooking - " + order );

        setChanged();
        notifyObservers(order);

    }

}
/*
Сверим выводы в консоль. Пример моего вывода:
Your order: [Water] of Tablet{number=5}
Start cooking - Your order: [Water] of Tablet{number=5}
Your order: [Water] of Tablet{number=5} was cooked by Amigo
 */