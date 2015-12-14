package com.javarush.test.level26.lesson10.home02;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Alex on 14.12.2015.
 */
public class Producer implements Runnable {
    public Producer(ConcurrentHashMap<String, String> map) {

    }

    @Override
    public void run() {

        try {
            int i = 0;
            while (true) {
                System.out.println("Some text for " + ++i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println(String.format("[%s] thread was terminated", Thread.currentThread().getName()));
        }

    }
}
/* Мир не меняется, меняемся мы.
Разберитесь с ConcurrentHashMap
В отдельном файле создайте класс Producer, который будет:
1. каждые полсекунды выводить на консоль с новой строки начиная с 1 фразу [Some text for i] , пример "Some text for 1"
2. при возникновении исключения выводить в консоль [[TREAD_NAME] thread was terminated], пример "[thread-1] thread was terminated"
*/