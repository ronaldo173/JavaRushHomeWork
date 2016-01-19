package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Alex on 18.01.2016.
 */
public class ConsoleHelper {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    /**
     * Это всё хорошо, но бывают случаи, когда срочно нужно прервать операцию, например, если пользователь ошибся с выбором операции.
     * Для этого у нас есть InterruptOperationException.
     * 2.Реализуйте следующую логику:
     * 2.1. Если пользователь в любом месте ввел текст 'EXIT' любым регистром, то выбросить InterruptOperationException.
     * 2.2. Найдите единственное место, куда нужно вставить эту логику. Реализуйте функционал в этом единственном методе.
     *
     * @return
     */
    public static String readString() throws InterruptOperationException {
        String result = null;
        try {
            result = reader.readLine();
            if ("exit".equalsIgnoreCase(result)) {
                throw new InterruptOperationException();
            }
        } catch (IOException e) {
            //NONE
        }
        return result;
    }

    public static String askCurrencyCode() throws InterruptOperationException {
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

    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException {
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

    public static Operation askOperation() throws InterruptOperationException {
        Operation operation = null;
        writeMessage("choose operation :1 - INFO, 2 - DEPOSIT, 3 - WITHDRAW, 4 - EXIT;");

        while (true) {
            String opString = readString();
            if (checkValue1234(opString)) {
                operation = Operation.getAllowableOperationByOrdinal(Integer.parseInt(opString));
                break;
            } else {
                ConsoleHelper.writeMessage("error in data(1-4) try again");
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
/**
 * 2. В классе ConsoleHelper реализуйте логику статического метода Operation askOperation()
 * Спросить у пользователя операцию.
 * Если пользователь вводит 1, то выбирается команда INFO, 2 - DEPOSIT, 3 - WITHDRAW, 4 - EXIT;
 * Используйте метод, описанный в п.1.
 * Обработай исключение - запроси данные об операции повторно.
 **/