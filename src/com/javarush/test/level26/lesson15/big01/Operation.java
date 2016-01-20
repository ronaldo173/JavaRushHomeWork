package com.javarush.test.level26.lesson15.big01;

/**
 * Created by Alex on 18.01.2016.
 */
public enum Operation {
    LOGIN, INFO, DEPOSIT, WITHDRAW, EXIT;

    public static Operation getAllowableOperationByOrdinal(Integer i) {
        switch (i) {
            case 0:
                throw new IllegalArgumentException();
            case 1:
                return INFO;
            case 2:
                return DEPOSIT;
            case 3:
                return WITHDRAW;
            case 4:
                return EXIT;
            default:
                throw new IllegalArgumentException();
        }
    }
}
/*

Итак, назовем эту операцию LOGIN и сделаем для нее команду.
1. Добавить в операции LOGIN с ординал=0
2. Запретим пользователю выбирать эту операцию из списка.
В единственном методе для поиска операций запретим доступ по ординал - бросим IllegalArgumentException.
 */