package com.javarush.test.level05.lesson07.task02;

/* Создать класс Cat
Создать класс Cat (кот) с пятью инициализаторами:
- Имя,
- Имя, вес, возраст
- Имя, возраст (вес стандартный)
- вес, цвет, (имя, адрес и возраст неизвестны, это бездомный кот)
- вес, цвет, адрес ( чужой домашний кот)
Задача инициализатора – сделать объект валидным. Например, если вес неизвестен, то нужно указать какой-нибудь средний вес. Кот не может ничего не весить. То же касательно возраста. А вот имени может и не быть (null). То же касается адреса: null.
*/

public class Cat {
    //напишите тут ваш код
    String name;
    int age = 25, weight, color;
    int address;

    //напишите тут ваш код
    public void initialize(String n) {
        this.name = n;
    }

    public void initialize(String n, int i, int j) {
        this.name = n;
        this.age = i;
        this.weight = j;
    }

    public void initialize(String n, int j) {
        this.name = n;
        this.color = j;
    }

    public void initialize(int weight, int color) {
        this.weight = weight;
        this.color = color;
    }

    public void initialize(int weight, int color, int adr) {
        this.weight = weight;
        this.color = color;
        this.address = adr;
    }

}
