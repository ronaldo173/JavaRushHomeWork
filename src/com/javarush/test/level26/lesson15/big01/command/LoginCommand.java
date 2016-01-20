package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.ResourceBundle;

/**
 * Created by Santer on 20.01.2016.
 */
public class LoginCommand implements Command {
    private ResourceBundle validCreditCards = ResourceBundle.getBundle(CashMachine.path + "verifiedCards");
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.path + "login_en");

    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage(res.getString("before"));
        while (true) {
            ConsoleHelper.writeMessage(res.getString("specify.data"));
            ConsoleHelper.writeMessage(res.getString("try.again.with.details"));
            String cardNum = ConsoleHelper.readString();
            String pin = ConsoleHelper.readString();

            if (!checkValid(cardNum, pin)) {
                ConsoleHelper.writeMessage(res.getString("try.again.or.exit"));
                continue;
            }

            if (verificate(cardNum, pin)) {
                ConsoleHelper.writeMessage(String.format(res.getString("success.format"), cardNum));
                break;
            } else {
                ConsoleHelper.writeMessage(String.format(res.getString("not.verified.format"), cardNum));
                continue;
            }
        }
    }

    private boolean verificate(String cardNum, String pin) {
        if (validCreditCards.containsKey(cardNum) && validCreditCards.getString(cardNum).equals(pin)) {
            return true;
        }

        return false;
    }

    private boolean checkValid(String cardNum, String pin) {
        if (cardNum == null || pin == null || cardNum.length() != 12 || pin.length() != 4) {
            return false;
        }
        return true;
    }
}
/*
 + before=Logging in...
+specify.data=Please specify your credit card number and pin code or type 'EXIT' for exiting.
+success.format=Credit card [%s] is verified successfully!
+not.verified.format=Credit card [%s] is not verified.
+try.again.or.exit=Please try again or type 'EXIT' for urgent exiting
try.again.with.details=Please specify valid credit card number - 12 digits, pin code - 4 digits.
 */