package com.javarush.test.level29.lesson15.big01.car;

/**
 * Created by Santer on 26.12.2015.
 */
public class Cabriolet extends Car {
    public Cabriolet(int numberOfPassengers) {
        super(Car.CABRIOLET, numberOfPassengers);
    }

    @Override
    public int getMaxSpeed() {
        final int MAX_CABRIOLET_SPEED = 90;
        return MAX_CABRIOLET_SPEED;
    }
}