package com.javarush.test.level26.lesson10.home01;

import com.javarush.test.level16.lesson13.bonus02.*;
import com.javarush.test.level16.lesson13.bonus02.Solution;

import java.util.concurrent.BlockingQueue;

/**
 * Created by Alex on 14.12.2015.
 */
public class Consumer implements Runnable {
    protected BlockingQueue queue;

    public Consumer(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {


        try {
            while (true) {
                System.out.println(queue.take());
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println(String.format("[%s] thread was terminated", Thread.currentThread().getName()));
        }

    }
}
