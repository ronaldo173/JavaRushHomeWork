package com.javarush.test.level38.lesson04.task02;

/* Непроверяемые исключения (unchecked exception)
Напиши реализацию метода methodThrowsClassCastException(). Он должен
всегда кидать непроверяемое исключение ClassCastException.

Напиши реализацию метода methodThrowsNullPointerException(). Он должен
всегда кидать непроверяемое исключение NullPointerException.

Кинуть исключение (throw) явно нельзя.
*/

import java.util.List;

public class VeryComplexClass {
    public void methodThrowsClassCastException() {
        //напишите тут ваш код
        List<String> o = (List<String>) new Object();
        System.out.println(o.toString());
    }

    public void methodThrowsNullPointerException() {
        //напишите тут ваш код
        int[] o = null;
        System.out.println(o.length);
    }

//    public static void main(String[] args) {
//        new VeryComplexClass().methodThrowsNullPointerException();
//    }
}
