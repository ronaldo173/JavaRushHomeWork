package com.javarush.test.level05.lesson07.task05;

/* Создать класс прямоугольник (Rectangle)
Создать класс прямоугольник (Rectangle). Его данными будут top, left, width, height (левая координата, верхняя, ширина и высота).
 Создать для него как можно больше методов initialize(…)
Примеры:
-	заданы 4 параметра: left, top, width, height
-	ширина/высота не задана (оба равны 0)
-	высота не задана (равно ширине) создаём квадрат
-	создаём копию другого прямоугольника (он и передаётся в параметрах)
*/

public class Rectangle {
    //напишите тут ваш код
    int left, top, width, height;


    public void initialize(int n, int i, int j, int a) {
        this.left = n;
        this.top = i;
        this.width = j;
        this.height = a;
    }

    public void initialize(int n, int i) {
        this.left = n;
        this.top = i;
        this.width = 0;
        this.height = 0;
    }

    public void initialize(int n, int i, int c) {
        this.left = n;
        this.top = i;
        this.width = this.height = c;
    }

    public void initialize(Rectangle rectangle) {
        this.left = rectangle.left;
        this.top = rectangle.top;
        this.width = rectangle.width;
        this.height = rectangle.height;
    }

    ;


}
