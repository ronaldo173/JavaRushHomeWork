package com.javarush.test.level26.lesson15.big01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Alex on 18.01.2016.
 */
public class ConsoleHelper {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() {
        String result = null;
        try {
            result = reader.readLine();
        } catch (IOException e) {
            //NONE
        }
        return result;
    }

    public static String askCurrencyCode() {
        writeMessage("hi, enter askCurrencyCode, 3 symbols");
        String result = readString();

        while (true) {
            if (result.length() == 3) {
                break;
            }
            writeMessage("please, try again(3letter)");
            writeMessage("hi, enter askCurrencyCode, 3 symbols");
            result = readString();
        }
        return result.toUpperCase();
    }

    public static String[] getValidTwoDigits(String currencyCode) {
        writeMessage("hi, enter 2 digits, >0");

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

            writeMessage("please try again");
            writeMessage("hi, enter 2 digits, >0");
            result = readString().split(" ");
        }
        return result;
    }

    public static Operation askOperation() {
        Operation operation = null;
        writeMessage("choose operation :1 - INFO, 2 - DEPOSIT, 3 - WITHDRAW, 4 - EXIT;");

        while (true) {
            try {
                operation = Operation.getAllowableOperationByOrdinal(Integer.parseInt(readString()));
                break;
            } catch (Exception e) {
                writeMessage("error, try again");
                writeMessage("choose operation : 1 INFO, 2 - DEPOSIT, 3 - WITHDRAW, 4 - EXIT;");
            }
        }
        return operation;
    }
}
/**
 * 2. В классе ConsoleHelper реализуйте логику статического метода Operation askOperation()
 * Спросить у пользователя операцию.
 * Если пользователь вводит 1, то выбирается команда INFO, 2 - DEPOSIT, 3 - WITHDRAW, 4 - EXIT;
 * Используйте метод, описанный в п.1.
 * Обработай исключение - запроси данные об операции повторно.
 **/