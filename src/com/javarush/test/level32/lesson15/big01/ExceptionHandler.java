package com.javarush.test.level32.lesson15.big01;

/**
 * Created by Santer on 08.01.2016.
 */
public class ExceptionHandler {
    public static void log(Exception e) {
        System.out.println(e.toString());
    }
}
/*
5.2.	Объяви класс ExceptionHandler. Это будет наш обработчик исключительных ситуаций,
который ты в дальнейшем сможешь переопределить. Пока добавь в него статический метод
log(Exception e), который будет выводить в консоль краткое описание проблемы
(используй метод toString у переданного исключения).
 */