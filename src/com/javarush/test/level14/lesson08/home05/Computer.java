package com.javarush.test.level14.lesson08.home05;

/**
 * Created by Саша on 28.07.2015.
 */
public class Computer {
    private Keyboard keyboard;
    private Monitor monitor;
    private Mouse mouse;

    public Computer() {
        this.mouse = new Mouse();
        this.monitor = new Monitor();
        this.keyboard = new Keyboard();
    }


    public Mouse getMouse() {
        return mouse;
    }

    public Monitor getMonitor() {

        return monitor;
    }

    public Keyboard getKeyboard() {

        return keyboard;
    }
}
