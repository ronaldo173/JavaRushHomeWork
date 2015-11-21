package com.javarush.test.level15.lesson12.home02;

/* Тренировка мозга
Найти логическую ошибку: метод doAction в реализации интерфейса Movable должен выдавать "moving".
Исправьте ошибку, при необходимости измените (отрефакторите) интерфейс Movable.
Результат вывода в консоль должен быть:
flying
moving
*/

public class Solution {
    static String s = "moving";

    public static void main(String[] args) {
        Duck duck = new Duck();
        Util.fly(duck);
        Util.move(duck);
    }

    public static interface Flyable {
        void doAction();
    }

    public static interface Movable {
        void doAction(String s);
    }

    public static class Duck implements Flyable, Movable {
        @Override
        public void doAction() {
            System.out.println("flying");
            //if(this instanceof Flyable) System.out.println("flying");
            // else if(this instanceof Movable) System.out.println("moving");
        }

        @Override
        public void doAction(String s) {
            System.out.println(s);
        }
    }

    public static class Util {
        static void fly(Flyable animal) {
            animal.doAction();
        }

        static void move(Movable animal) {
            animal.doAction(s);
        }
    }
}
