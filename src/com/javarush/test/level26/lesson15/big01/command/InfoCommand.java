package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;

/**
 * Created by Santer on 19.01.2016.
 */
class InfoCommand implements Command {
    @Override
    public void execute() {
        boolean anyMoney = false;
        for (CurrencyManipulator manipulator : CurrencyManipulatorFactory.getAllCurrencyManipulators()) {
            if (manipulator.hasMoney()) {
                anyMoney = true;
                ConsoleHelper.writeMessage(manipulator.getCurrencyCode() + " - " + manipulator.getTotalAmount());
            }
        }
        if (!anyMoney) {
            ConsoleHelper.writeMessage("No money available.");
        }
    }
}
/*
2.2. В InfoCommand в цикле выведите [код валюты - общая сумма денег для выбранной валюты]
Запустим прогу и пополним счет на EUR 100 2 и USD 20 6, и посмотрим на INFO.
Все работает правильно?
 EUR - 200
 USD - 120
Отлично!
 */