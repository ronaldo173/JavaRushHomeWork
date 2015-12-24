package com.javarush.test.level23.lesson13.big01;

import java.util.ArrayList;

/**
 * Created by Alex on 24.12.2015.
 */
public class Snake {
    SnakeDirection direction;
    private ArrayList<SnakeSection> sections = new ArrayList<>();
    private boolean isAlive;

    public Snake(int x, int y) {
        SnakeSection snakeSection = new SnakeSection(x, y);
        sections = new ArrayList<>();
        sections.add(snakeSection);
        this.isAlive = true;

    }

    public ArrayList<SnakeSection> getSections() {
        return sections;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public SnakeDirection getDirection() {
        return direction;
    }

    public void setDirection(SnakeDirection direction) {
        this.direction = direction;
    }

    public int getX() {
        return sections.get(0).getX();
    }

    public int getY() {
        return sections.get(0).getY();
    }

    public void move() {

    }

}

