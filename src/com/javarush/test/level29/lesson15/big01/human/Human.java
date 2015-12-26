package com.javarush.test.level29.lesson15.big01.human;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Human implements Alive {
    public static final int FIRST = 1;
    public static final int SECOND = 2;
    public static final int THIRD = 3;
    public static final int FOURTH = 4;
    private static int nextId = 0;
    protected int age;
    protected String name;

    protected Size size = new Size();
    private List<Human> children = new ArrayList<>();
    private int id;
    private BloodGroup bloodGroup;

    public Human(String name, int age) {
        this.age = age;
        this.name = name;

        this.id = nextId;
        nextId++;
    }


    public List<Human> getChildren() {
        return Collections.unmodifiableList(children);
    }

    public void addChild(Human children) {
        children.addChild(children);
    }

    public void removeChild(Human children) {
        this.children.remove(children);
    }

    public BloodGroup getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(BloodGroup bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getId() {
        return id;
    }

    public void printSize() {
        System.out.println("Рост: " + size.height + " Вес: " + size.weight);
    }

    @Override
    public void live() {
    }

    public String getPosition() {
        return "Человек";
    }

    public void printData() {
        System.out.println(getPosition() + ": " + name);
    }

    public class Size {
        public int height, weight;


    }
}