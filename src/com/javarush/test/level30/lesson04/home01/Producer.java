package com.javarush.test.level30.lesson04.home01;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TransferQueue;

/**
 * Created by Santer on 28.12.2015.
 */
public class Producer implements Runnable {
    private TransferQueue<ShareItem> queue;

    public Producer(TransferQueue<ShareItem> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 9; i++) {
            if (Thread.currentThread().isInterrupted()) {
                return;
            }
            System.out.format("Элемент 'ShareItem-%d' добавлен%n", i);
            queue.offer(new ShareItem("ShareItem-" + i, i));
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }

            if (queue.hasWaitingConsumer()) {
                System.out.println("Consumer в ожидании!");
            }
        }
    }
}
/*
4. Реализация метода run для Producer:
4.1. Используя метод offer добавить в очередь 9 ShareItem-ов с такими параметрами: ("ShareItem-N", N), где N - номер элемента от 1 до 9
4.2. Перед каждым добавлением вывести фразу "Элемент 'ShareItem-N' добавлен". Используйте System.out.format
4.3. Усыпить трэд на 0.1 секунды
4.4. Если у очереди есть Consumer, не занятый работой, то вывести фразу "Consumer в ожидании!".
Просмотрите методы интерфейса TransferQueue, там есть нужный метод.
 */