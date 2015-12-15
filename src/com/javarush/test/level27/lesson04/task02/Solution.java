package com.javarush.test.level27.lesson04.task02;

/* Второй вариант дедлока
В методе secondMethod в синхронизированных блоках расставьте локи так,
чтобы при использовании класса Solution нитями образовывался дедлок
*/
public class Solution {
    private final Object lock = new Object();
    private final Object lock2 = new Object();

    public void firstMethod() {
        synchronized (lock) {
            synchronized (lock2) {
                doSomething();
            }
        }
    }

    public void secondMethod() {
        synchronized (lock) {
            synchronized (lock2) {
                doSomething();
            }
        }
    }

    private synchronized void doSomething() {
        System.out.println("do something");
    }
}

class Test {
    public static void main(String[] args) throws InterruptedException {
        final Solution solution = new Solution();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                solution.firstMethod();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                solution.secondMethod();
            }
        });

        t1.start();
        t2.start();
        System.out.println("\n...finished");
    }
}