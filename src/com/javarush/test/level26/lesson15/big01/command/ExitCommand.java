package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

/**
 * Created by Santer on 19.01.2016.
 */
class ExitCommand implements Command {
    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage("sure want exit? y/n");
        String s = ConsoleHelper.readString();
        if (s.equals("y")) {
            ConsoleHelper.writeMessage("Poka poka");
        }
    }
}
/*
1. Реализуйте следующую логику в команде ExitCommand:
1.1. Спросить, действительно ли пользователь хочет выйти - варианты <y,n>.
1.2. Если пользователь подтвердит свои намерения, то попрощаться с ним.
 */