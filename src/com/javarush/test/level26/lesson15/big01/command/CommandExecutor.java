package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.Operation;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Santer on 19.01.2016.
 */
public class CommandExecutor {
    private static Map<Operation, Command> map;

    static {
        map = new HashMap<>();
        map.put(Operation.DEPOSIT, new DepositCommand());
        map.put(Operation.EXIT, new ExitCommand());
        map.put(Operation.INFO, new InfoCommand());
        map.put(Operation.WITHDRAW, new WithdrawCommand());
    }

    private CommandExecutor() {
    }

    public static final void execute(Operation operation) {
        map.get(operation).execute();
    }
}
/*
4. Создадим public класс CommandExecutor, через который можно будет взаимодействовать со всеми командами.
Создадим ему статическую карту Map<Operation, Command>, которую проинициализируем всеми известными нам операциями и командами.

4.1 Создадим метод public static final void execute(Operation operation), который будет дергать метод execute у нужной команды.
Реализуйте эту логику.
4.2. Расставьте правильно модификаторы доступа учитывая, что единственная точка входа - это метод execute.

Проверяем, чтоб структура соответствовала тестам на сервере.
Логику будем переносить в следующем таске.
 */