package com.javarush.test.level33.lesson15.big01;

import java.math.BigInteger;
import java.security.SecureRandom;

/**
 * Created by Santer on 10.01.2016.
 */
public class Helper {

    public static String generateRandomString() {
        SecureRandom secureRandom = new SecureRandom();

        return new BigInteger(130, secureRandom).toString(32);
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }
}
/*
4.1.	Создай класс Helper.
4.1.1.	Добавь в него статический метод String generateRandomString(), который
будет генерировать случайную строку. Воспользуйся для этого классами
SecureRandom и BigInteger. Подсказка: гугли запрос "random string java".
4.1.2.	Добавь в класс статический метод printMessage(String message). Он должен выводить
переданный текст в консоль. Весь дальнейший вывод в программе должен
быть реализован через этот метод!
4.2.	Создай класс ExceptionHandler.
4.2.1.	Добавь в него статический метод log(Exception e), который будет выводить
краткое описание исключения.
 */