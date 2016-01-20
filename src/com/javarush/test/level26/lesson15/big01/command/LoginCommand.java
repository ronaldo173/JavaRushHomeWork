package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

/**
 * Created by Santer on 20.01.2016.
 */
public class LoginCommand implements Command {
    private static final String CARD_NUMBER = new String("123456789012");
    private static final String PIN = new String("1234");

    @Override
    public void execute() throws InterruptOperationException {
        while (true) {
            ConsoleHelper.writeMessage("2 числа - номер кредитной карты, состоящий из 12 цифр, и пин - состоящий из 4 цифр");
            String cardNum = ConsoleHelper.readString();
            String pin = ConsoleHelper.readString();

            if (!checkValid(cardNum, pin)) {
                ConsoleHelper.writeMessage("невалидных данных, если они такими являются");
                continue;
            }

            if (verificate(cardNum, pin)) {
                ConsoleHelper.writeMessage("верификация прошла успешно");
                break;
            } else {
                ConsoleHelper.writeMessage("данные в п. 4.4. НЕ идентифицированы");
                continue;
            }
        }
    }

    private boolean verificate(String cardNum, String pin) {
//        System.out.println(cardNum + "..." + CARD_NUMBER + "..." + cardNum.equals(CARD_NUMBER));
//        System.out.println(pin + "..." + PIN + "..." + pin.equals(PIN));
        if (cardNum.equals(CARD_NUMBER) && pin.equals(PIN)) {
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
 3. Создадим LoginCommand по аналогии с другими командами, в котором захардкодим номер карточки с пином
 123456789012 и 1234 соответственно.
 4. Реализуйте следующую логику для команды LoginCommand:
 4.1. Пока пользователь не введет валидные номер карты и пин - выполнять следующие действия
 4.2. Запросить у пользователя 2 числа - номер кредитной карты, состоящий из 12 цифр, и пин - состоящий из 4 цифр
 4.3. Вывести юзеру сообщение о невалидных данных, если они такими являются.
 4.4. Если данные валидны, то проверить их на соответствие захардкоженным (123456789012 и 1234).
 4.5. Если данные в п. 4.4. идентифицированы, то сообщить, что верификация прошла успешно.
 4.6. Если данные в п. 4.4. НЕ идентифицированы, то вернуться к п.4.1.
 */