package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.ResourceBundle;

/**
 * Created by Santer on 19.01.2016.
 */
class ExitCommand implements Command {
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.path + "exit_en");
    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage(res.getString("exit.question.y.n"));
        String s = ConsoleHelper.readString();
        if (s.equals(res.getString("yes"))) {
            ConsoleHelper.writeMessage(res.getString("thank.message"));
        }
    }
}
/*
1. В каждую команду добавь поле private ResourceBundle res, которое инициализируй соответствующим ресурсом

2. Для каждого нового ресурса замени все строки в соответствующей команде.

exit.question.y.n=Do you really want to exit? <y,n>
yes=y
thank.m
 */