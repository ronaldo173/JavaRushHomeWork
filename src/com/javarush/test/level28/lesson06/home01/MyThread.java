package com.javarush.test.level28.lesson06.home01;

/**
 * Created by Alex on 18.12.2015.
 */
public class MyThread extends Thread {
    private volatile static int priorityMy = 1;

    public MyThread() {
        run();
    }

    public MyThread(Runnable target) {
        super(target);
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
    }

    public MyThread(String name) {
        super(name);
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
        if (priorityMy < group.getMaxPriority()) {
            priorityMy++;
        } else {
            priorityMy = 1;
        }
        Thread.currentThread().setPriority(priorityMy);
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
    }

    @Override
    public void run() {
        if (this.priorityMy < 10) {
            priorityMy++;
        } else {
            priorityMy = 1;
        }
        Thread.currentThread().setPriority(priorityMy);
        super.run();
    }
}
