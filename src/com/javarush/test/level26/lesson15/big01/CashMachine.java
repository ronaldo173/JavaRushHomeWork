package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.command.CommandExecutor;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

/**
 * Created by Alex on 18.01.2016.
 */
public class CashMachine {
    public static void main(String[] args) {

        Operation operation = null;
        try {
            CommandExecutor.execute(Operation.LOGIN);
            do {
                operation = ConsoleHelper.askOperation();

                CommandExecutor.execute(operation);


            } while (operation != Operation.EXIT);
        } catch (InterruptOperationException e) {
            ConsoleHelper.writeMessage("poka");
        }

    }
}
/*


 */