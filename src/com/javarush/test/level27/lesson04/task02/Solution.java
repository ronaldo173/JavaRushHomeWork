package com.javarush.test.level27.lesson04.task02;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* Второй вариант дедлока
В методе secondMethod в синхронизированных блоках расставьте локи так,
чтобы при использовании класса Solution нитями образовывался дедлок
*/
public class Solution {
    private final Object lock = new Object();

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        final Solution solution = new Solution();
        Solution solution2 = new Solution();

        for (int i = 0; i < 3; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
//                    System.out.println(Thread.currentThread().getName());
                    solution.firstMethod();
                    solution.secondMethod();
                }
            });
        }

        executorService.shutdown();
    }

    public synchronized void firstMethod() {
        synchronized (lock) {
            doSomething();
        }
    }

    public void secondMethod() {
        synchronized (lock) {
            synchronized (this) {
                doSomething();
            }
        }
    }

    private void doSomething() {
//        System.out.println(Thread.currentThread().getName());
    }
}