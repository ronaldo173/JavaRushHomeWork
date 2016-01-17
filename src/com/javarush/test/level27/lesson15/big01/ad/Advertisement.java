package com.javarush.test.level27.lesson15.big01.ad;

/**
 * Created by Santer on 17.01.2016.
 */
public class Advertisement {
    private Object content;
    private String name;
    private long initialAmount;
    private int hits;
    private int duration;
    private long amountPerOneDisplaying;

    public Advertisement(Object content, String name, long initialAmount, int hits, int duration) {
        this.content = content;
        this.name = name;
        this.initialAmount = initialAmount;
        this.hits = hits;
        this.duration = duration;

        this.amountPerOneDisplaying = initialAmount / hits;
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public long getAmountPerOneDisplaying() {
        return amountPerOneDisplaying;
    }
}
/*
1. В классе Advertisement создайте поле long amountPerOneDisplaying, которое инициализируйте в конструкторе.
Оно должно равняться стоимости одного показа рекламного объявления в копейках.

2. В классе Advertisement создайте геттеры для полей name, duration и amountPerOneDisplaying
 */