package com.javarush.test.level05.lesson07.task01;

/* Создать класс Friend
Создать класс Friend (друг) с тремя инициализаторами (тремя методами initialize):
- Имя
- Имя, возраст
- Имя, возраст, пол
*/

public class Friend {
    String name;
    int age, sex;

    //напишите тут ваш код
    public void initialize(String n) {
        this.name = n;
    }

    public void initialize(String n, int i) {
        this.name = n;
        this.age = i;
    }

    public void initialize(String n, int i, int j) {
        this.name = n;
        this.age = i;
        this.sex = j;
    }
}
