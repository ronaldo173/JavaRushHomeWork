package com.javarush.test.level05.lesson07.task03;

/* Создать класс Dog
Создать класс Dog (собака) с тремя инициализаторами:
- Имя
- Имя, рост
- Имя, рост, цвет
*/

public class Dog {
    //напишите тут ваш код
    String name;
    int rost, color;

    //напишите тут ваш код
    public void initialize(String n) {
        this.name = n;
    }

    public void initialize(String n, int i) {
        this.name = n;
        this.rost = i;
    }

    public void initialize(String n, int i, int j) {
        this.name = n;
        this.rost = i;
        this.color = j;
    }

}
