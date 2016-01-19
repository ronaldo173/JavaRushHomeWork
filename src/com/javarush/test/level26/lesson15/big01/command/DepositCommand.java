package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;

/**
 * Created by Santer on 19.01.2016.
 */
class DepositCommand implements Command {
    @Override
    public void execute() {

        String currencyCode = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);

        String[] validTwoDigits = ConsoleHelper.getValidTwoDigits(currencyCode);
        manipulator.addAmount(Integer.parseInt(validTwoDigits[0]), Integer.parseInt(validTwoDigits[1]));

    }
}
/*
  String currencyCode = ConsoleHelper.askCurrencyCode();
        String[] validTwoDigits = ConsoleHelper.getValidTwoDigits(currencyCode);

//        System.out.println(currencyCode);
//        System.out.println(Arrays.toString(validTwoDigits));

        CurrencyManipulator manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
        manipulator.addAmount(Integer.parseInt(validTwoDigits[0]), Integer.parseInt(validTwoDigits[1]));

        manipulator.getTotalAmount();
 */
/*
Пора привести в порядок наш main, уж очень там всего много, чего не должно быть.

1. Перенесите логику из main в DepositCommand и InfoCommand
Проверим, что там стало с main? Цикл, в котором спрашиваем операцию у пользователя, а потом вызываем метод у CommandExecutor.
И так до бесконечности... надо бы придумать условие выхода из цикла.
Исправь цикл, чтоб он стал do-while. Условие выхода - операция EXIT.

 */