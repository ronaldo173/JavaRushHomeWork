package com.javarush.test.level27.lesson15.big01;

/**
 * Created by Santer on 14.01.2016.
 */
public class Restaurant {
    public static void main(String[] args) {
        new Tablet(5).createOrder();
    }
}
/*
3. Пишем main.
Для объекта Observable добавляем свой объект Observer. См. п.2 и описание паттерна в wikipedia
Называем повара, имя не влияет на тесты. В моем варианте - это Amigo :)

 */