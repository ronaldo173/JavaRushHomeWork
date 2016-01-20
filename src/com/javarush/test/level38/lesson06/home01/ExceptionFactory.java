package com.javarush.test.level38.lesson06.home01;

/**
 * Created by Alex on 20.01.2016.
 */
public class ExceptionFactory {

    public static Throwable getException(Enum message) {
        if (message != null) {
            String msg = message.name().substring(0, 1).toUpperCase() + message.name().substring(1).toLowerCase().replaceAll("_", " ");
            if (message instanceof ExceptionApplicationMessage) {
                return new Exception(msg);
            }
            if (message instanceof ExceptionDBMessage) {
                return new RuntimeException(msg);
            }
            if (message instanceof ExceptionUserMessage) {
                return new Error(msg);
            }
        }
        return new IllegalArgumentException();
    }
}

/*
Если передан энум:
* ExceptionApplicationMessage, верните исключение Exception
* ExceptionDBMessage, верните исключение RuntimeException
* ExceptionUserMessage, верните Error
иначе верните IllegalArgumentException без сообщения.

 */
