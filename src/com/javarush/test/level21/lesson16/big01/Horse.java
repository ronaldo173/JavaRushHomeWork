package com.javarush.test.level21.lesson16.big01;

/**
 * Created by Саша on 10.09.2015.
 */
public class Horse {
    private String name;
    private double distance, speed;

    public Horse(String name, double speed, double dist) {
        this.name = name;
        this.speed = speed;
        this.distance = dist;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void move() {
        distance += speed * Math.random();
    }

    public void print() {
        int tochek = (int) Math.round(distance);
        for (int i = 0; i < tochek; i++) {
            System.out.print(".");
        }
        System.out.print(getName());
        System.out.println();

    }
}

/*
Задание 12
Задание 13
Теперь вернемся к методу print класса Horse.
Т.к. мы работаем с консолью, то все лошади на бегах будут выглядеть примерно так:
........Sleven                       <- лошадь Слевин
....Lucky                            <- лошадь Лаки
..........Gomer                      <- лошадь Гомер

Другими словами, в методе print надо вывести на экран строку состоящую из точек и имени лошади.
Количество точек равно distance, округленному до целого числа.

 */