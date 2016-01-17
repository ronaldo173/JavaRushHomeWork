package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Santer on 17.01.2016.
 */
public class Waitor implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        ConsoleHelper.writeMessage((Order) arg + " was cooked by " + o);
    }
}
/*
3. Метод void update пусть выведет в консоль следующее:
order + " was cooked by " + cook
 */