package com.javarush.test.level05.lesson07.task04;

/* Создать класс Circle
Создать класс (Circle) круг, с тремя инициализаторами:
- centerX, centerY, radius
- centerX, centerY, radius, width
- centerX, centerY, radius, width, color
*/

public class Circle {
    //напишите тут ваш код
    int centerX, centerY, radius, width;
    String color;

    public void initialize(int n, int i, int j) {
        this.centerX = n;
        this.centerY = i;
        this.radius = j;
    }

    public void initialize(int n, int i, int j, int a) {
        this.centerX = n;
        this.centerY = i;
        this.radius = j;
        this.width = a;
    }

    public void initialize(int n, int i, int j, int a, String b) {
        this.centerX = n;
        this.centerY = i;
        this.radius = j;
        this.width = a;
        color = b;
    }

}
