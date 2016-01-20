package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Alex on 18.01.2016.
 */
public class ConsoleHelper {
    private static ResourceBundle res = ResourceBundle.getBundle(CashMachine.path + "common_en");
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }


    public static String readString() throws InterruptOperationException {
        String result = null;
        try {
            result = reader.readLine();
            if (res.getString("operation.EXIT").equalsIgnoreCase(result)) {
                throw new InterruptOperationException();
            }
        } catch (IOException e) {
            //NONE
        }
        return result;
    }

    public static String askCurrencyCode() throws InterruptOperationException {
        writeMessage(res.getString("choose.currency.code"));
        String result = readString();

        while (true) {
            if (result.length() == 3) {
                break;
            }
            writeMessage(res.getString("invalid.data"));
            writeMessage(res.getString("choose.currency.code"));
            result = readString();
        }
        return result.toUpperCase();
    }

    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException {
        writeMessage(res.getString("choose.denomination.and.count.format"));

        String[] result = readString().split(" ");

        while (true) {
            int i1 = 0;
            int i2 = 0;

            try {
                i1 = Integer.parseInt(result[0]);
                i2 = Integer.parseInt(result[1]);

                if (i1 > 0 && i2 > 0 && result.length == 2) {
                    break;
                }
            } catch (Exception e) {//NONE}
            }

            writeMessage(res.getString("invalid.data"));
            writeMessage(res.getString("choose.denomination.and.count.format"));
            result = readString().split(" ");
        }
        return result;
    }
    /*

before=Depositing...
success.format=%d %s was deposited successfully
invalid.data=Please specify valid data.
 */

    public static Operation askOperation() throws InterruptOperationException {
        Operation operation = null;
        writeMessage(res.getString("choose.operation"));
        writeMessage("choose operation :1 - INFO, 2 - DEPOSIT, 3 - WITHDRAW, 4 - EXIT;");

        while (true) {
            String opString = readString();
            if (checkValue1234(opString)) {
                operation = Operation.getAllowableOperationByOrdinal(Integer.parseInt(opString));
                break;
            } else {
                writeMessage(res.getString("invalid.data"));
                writeMessage("choose operation :1 - INFO, 2 - DEPOSIT, 3 - WITHDRAW, 4 - EXIT;");
            }
        }
        return operation;
    }

    private static boolean checkValue1234(String opString) {
        Pattern p = Pattern.compile("^[1-4]$");
        Matcher m = p.matcher(opString);
        return m.matches();
    }
}
/*
the.end=Terminated. Thank you for visiting JavaRush cash machine. Good luck.
choose.operation=Please choose an operation desired or type 'EXIT' for exiting
operation.INFO=INFO
operation.DEPOSIT=DEPOSIT
operation.WITHDRAW=WITHDRAW
operation.EXIT=EXIT
+invalid.data=Please specify valid data.
+choose.currency.code=Please choose a currency code, for example USD
+choose.denomination.and.count.format=Please specify integer denomination and integer count. For example '10 3' means 30 %s
 */