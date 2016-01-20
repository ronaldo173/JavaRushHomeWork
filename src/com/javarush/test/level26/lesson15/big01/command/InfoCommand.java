package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;

import java.util.ResourceBundle;

/**
 * Created by Santer on 19.01.2016.
 */
class InfoCommand implements Command {

    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.path + "info_en");
    @Override
    public void execute() {
        boolean anyMoney = false;
        ConsoleHelper.writeMessage(res.getString("before"));
        for (CurrencyManipulator manipulator : CurrencyManipulatorFactory.getAllCurrencyManipulators()) {
            if (manipulator.hasMoney()) {
                anyMoney = true;
                ConsoleHelper.writeMessage(manipulator.getCurrencyCode() + " - " + manipulator.getTotalAmount());
            }
        }
        if (!anyMoney) {
            ConsoleHelper.writeMessage(res.getString("no.money"));
        }
    }
}
/*
1. В каждую команду добавь поле private ResourceBundle res, которое инициализируй соответствующим ресурсом

2. Для каждого нового ресурса замени все строки в соответствующей команде.

before=Information:
no.money=No money available.
 */