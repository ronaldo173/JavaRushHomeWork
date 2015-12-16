package com.javarush.test.level27.lesson09.home01;

public class TransferObject {
    protected volatile boolean isValuePresent = false; //use this variable
    private int value;

    public synchronized int get() {
        while (!isValuePresent) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Got: " + value);
        isValuePresent = false;
        notify();
        return value;
    }

    public synchronized void put(int value) {
        while (isValuePresent) {
            try {
                this.wait();
            } catch (InterruptedException e) {
            }
        }
        this.value = value;
        isValuePresent = true;
        System.out.println("Put: " + value);
        notify();

    }
}
