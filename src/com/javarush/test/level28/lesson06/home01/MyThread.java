package com.javarush.test.level28.lesson06.home01;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Alex on 18.12.2015.
 */
public class MyThread extends Thread {
    private static AtomicInteger priorityMy = new AtomicInteger(0);

    public MyThread() {
        initThreadPriority();
    }

    public MyThread(Runnable target) {
        super(target);
        initThreadPriority();
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
        initThreadPriority();
    }

    public MyThread(String name) {
        super(name);
        initThreadPriority();
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
        initThreadPriority();
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
        initThreadPriority();
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
        initThreadPriority();
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
        initThreadPriority();
    }

    private void initThreadPriority() {
        priorityMy.incrementAndGet();
        priorityMy.compareAndSet(11, 1);

        int prior = priorityMy.get();
        if (getThreadGroup() != null) {
            if (prior > getThreadGroup().getMaxPriority()) {
                prior = getThreadGroup().getMaxPriority();
            }
        }
        setPriority(prior);
    }


}
