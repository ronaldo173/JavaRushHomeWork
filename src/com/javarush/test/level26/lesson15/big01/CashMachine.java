package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.command.CommandExecutor;

/**
 * Created by Alex on 18.01.2016.
 */
public class CashMachine {
    public static void main(String[] args) {

        Operation operation = null;
        do {
            operation = ConsoleHelper.askOperation();
            CommandExecutor.execute(operation);

        } while (operation != Operation.EXIT);


    }
}
/*

1. Перенесите логику из main в DepositCommand и InfoCommand
Проверим, что там стало с main? Цикл, в котором спрашиваем операцию у пользователя, а потом вызываем метод у CommandExecutor.
И так до бесконечности... надо бы придумать условие выхода из цикла.
Исправь цикл, чтоб он стал do-while. Условие выхода - операция EXIT.

2. Давайте запустим прогу и пополним счет на EUR 100 2 и USD 20 6, и посмотрим на INFO.
Ничего не понятно, т.к. создались 2 манипулятора: первый для EUR, второй для USD.
Давайте улучшим логику InfoCommand. Надо вывести баланс по каждому манипулятору.
 */