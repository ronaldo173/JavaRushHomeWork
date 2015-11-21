package com.javarush.test.level05.lesson09.task01;

/* Создать класс Friend
Создать класс Friend (друг) с тремя конструкторами:
- Имя
- Имя, возраст
- Имя, возраст, пол
*/

public class Friend {
    //напишите тут ваш код
    String name;
    int a1, a2;

    public Friend(String name) {
        this.name = name;
    }

    public Friend(String name, int a) {
        this.name = name;
        this.a1 = a;
    }

    public Friend(String name, int a, int b) {
        this.name = name;
        this.a1 = a;
        this.a2 = b;
    }

}