package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level31.lesson15.big01.ConsoleHelper;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Santer on 14.01.2016.
 */
public class Cook implements Observer {
    private String name;

    public Cook(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Cook{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public void update(Observable o, Object arg) {
        ConsoleHelper.writeMessage("Start cooking - " + arg);
    }
}
/*
3. Метод void update(Observable observable, Object arg), который необходимо реализовать, принимает два параметра.
-observable - объект, который отправил нам значение
-arg - само значение, в нашем случае - это объект Order
На данном этапе мы сымитируем обработку и выведем в консоль "Start cooking - " + order

 */
