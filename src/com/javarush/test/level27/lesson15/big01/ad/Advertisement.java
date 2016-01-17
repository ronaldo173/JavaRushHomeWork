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

    public Advertisement(Object content, String name, long initialAmount, int hits, int duration) {
        this.content = content;
        this.name = name;
        this.initialAmount = initialAmount;
        this.hits = hits;
        this.duration = duration;
    }
}
/*
2.Создадим класс Advertisement(Рекламное объявление) в пакете ad, у к оторого будут следующие поля:
Object content - видео
String name - имя/название
long initialAmount - начальная сумма, стоимость рекламы в копейках. Используем long, чтобы избежать проблем с округлением
int hits - количество оплаченных показов
int duration - продолжительность в секундах
Модификаторы доступа расставьте самостоятельно.

 */