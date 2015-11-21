package com.javarush.test.level26.lesson15.big01;

/**
 * Created by Саша on 21.09.2015.
 */
public enum Operation {
    INFO, DEPOSIT, WITHDRAW, EXIT
}

/*
Итак..
1. Создайте класс CashMachine с методом main.
2. Наши операции зададим в энуме Operation: INFO, DEPOSIT, WITHDRAW
Т.к. всё должно быть user friendly, то на выход из приложения надо попрощаться с юзером.
Поэтому добавим еще операцию EXIT
3. Т.к мы будем активно общаться с юзером, то будет много выводимого текста.
Чтобы работу с консолью сосредо
 */