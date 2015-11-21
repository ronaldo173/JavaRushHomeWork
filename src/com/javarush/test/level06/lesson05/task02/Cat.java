package com.javarush.test.level06.lesson05.task02;

/* Классы Cat и Dog и метод finalize для каждого
В каждом классе Cat и Dog написать метод finalize, который выводит на экран текст о том, что такой-то объект уничтожен.
*/

public class Cat {
    //напишите тут ваш код
    public void finalize() {
        System.out.println("такой-то объект уничтожен");
    }

}

class Dog {
    //напишите тут ваш код
    public void finalize() {
        System.out.println("такой-то объект уничтожен");
    }

}