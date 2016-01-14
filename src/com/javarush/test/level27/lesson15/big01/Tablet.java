package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.kitchen.Order;
import javafx.beans.InvalidationListener;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Santer on 14.01.2016.
 */
public class Tablet implements javafx.beans.Observable {
    private static Logger logger = Logger.getLogger(Tablet.class.getName());
    private final int number;

    public Tablet(int number) {
        this.number = number;
    }

    public void createOrder() {
        try {
            Order order = new Order(this);
            ConsoleHelper.writeMessage(order.toString());
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Console is unavailable.");
            e.printStackTrace();
        }
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Tablet{" +
                "number=" + number +
                '}';
    }

    @Override
    public void addListener(InvalidationListener listener) {

    }

    @Override
    public void removeListener(InvalidationListener listener) {

    }
}
/*
3. Метод void update(Observable observable, Object arg), который необходимо реализовать, принимает два параметра.
-observable - объект, который отправил нам значение
-arg - само значение, в нашем случае - это объект Order
На данном этапе мы сымитируем обработку и выведем в консоль "Start cooking - " + order


 */