package com.javarush.test.level09.lesson02.task02;

/* И снова StackTrace
Написать пять методов, которые вызывают друг друга.
Каждый метод должен возвращать имя метода,
вызвавшего его, полученное с помощью StackTrace.
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        System.out.println(method1());
    }

    public static String method1() {
        method2();
        //напишите тут ваш код
        StackTraceElement st[] = Thread.currentThread().getStackTrace();
        return st[2].getMethodName();

    }

    public static String method2() {
        method3();
        StackTraceElement s[] = Thread.currentThread().getStackTrace();
        return s[2].getMethodName();

    }

    public static String method3() {
        method4();
        //напишите тут ваш код
        StackTraceElement s[] = Thread.currentThread().getStackTrace();
        return s[2].getMethodName();

    }

    public static String method4() {
        method5();
        //напишите тут ваш код
        StackTraceElement[] s = Thread.currentThread().getStackTrace();
        return s[2].getMethodName();

    }

    public static String method5() {
        //напишите тут ваш код
        StackTraceElement[] st = Thread.currentThread().getStackTrace();
        return st[2].getMethodName();

    }
}
