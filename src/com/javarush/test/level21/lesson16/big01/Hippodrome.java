package com.javarush.test.level21.lesson16.big01;

import java.util.ArrayList;

/**
 * Created by Саша on 10.09.2015.
 */
public class Hippodrome {
    public static Hippodrome game;
    private static ArrayList<Horse> horses = new ArrayList<>();

    public static Horse getWinner() {
        double maxDist = 0, horseWin = 0;
        for (Horse h : horses) {
            if (h.getDistance() > maxDist) {
                maxDist = h.getDistance();
                horseWin = horses.indexOf(h);
            }
        }
        return horses.get((int) horseWin);
    }

    public static void printWinner() {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }

    public static void main(String[] args) throws InterruptedException {
        Hippodrome hippodrome = new Hippodrome();
        game = hippodrome;
        Horse horse1 = new Horse("Horse1", 3, 0);
        Horse horse2 = new Horse("Horse2", 3, 0);
        Horse horse3 = new Horse("Horse3", 3, 0);

        horses.add(horse1);
        horses.add(horse2);
        horses.add(horse3);


        game.run();
        printWinner();

    }

    public ArrayList<Horse> getHorses() {
        return horses;
    }

    public void run() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            Thread.sleep(500);
        }
        //printWinner();
    }

    public void move() {
        for (Horse h : horses) {
            h.move();
            h.print();
        }
    }

    public void print() {
        for (Horse h : horses) {
            h.print();
        }
        System.out.println();
        System.out.println();
    }
}
/*
Задание 15
Добавим определение победителя.
В классе Hippodrome сделаем два метода:
public Horse getWinner() и public void printWinner()

Метод getWinner должен возвращать лошадь пробежавшую самую большую дистанцию.
Метод printWinner выводит на экран имя победителя в виде:
Winner is <NAME>!
Пример:
Winner is Lucky!
 */
