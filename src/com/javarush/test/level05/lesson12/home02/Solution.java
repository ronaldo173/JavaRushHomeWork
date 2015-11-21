package com.javarush.test.level05.lesson12.home02;

/* Man and Woman
1. Внутри класса Solution создай public static классы Man и Woman.
2. У классов должны быть поля: name(String), age(int), address(String).
3. Создай конструкторы, в которые передаются все возможные параметры.
4. Создай по два объекта каждого класса со всеми данными используя конструктор.
5. Объекты выведи на экран в таком формате [name + " " + age + " " + address].
*/

public class Solution {
    public static void main(String[] args) {
        //создай по два объекта каждого класса тут
        Man man1 = new Man("name1", 123, "bla");
        Man man2 = new Man("name2", 123, "bla2");
        Woman woman1 = new Woman("name3", 123, "bla3");
        Woman woman2 = new Woman("name4", 123, "bla4");
        System.out.println(man1.name + " " + man1.age + " " + man1.address);
        System.out.println(man2.name + " " + man2.age + " " + man2.address);
        System.out.println(woman1.name + " " + woman1.age + " " + woman1.address);
        System.out.println(woman2.name + " " + woman2.age + " " + woman2.address);

        //выведи их на экран тут
    }

    //добавьте тут ваши классы
    public static class Man {
        String name;
        int age;
        String address;

        Man(String n) {
            this.name = n;
        }

        Man(String n, int a) {
            this.name = n;
            this.age = a;
        }

        Man(String n, int a, String b) {
            this.name = n;
            this.age = a;
            this.address = b;
        }
    }

    public static class Woman {
        String name;
        int age;
        String address;

        Woman(String n) {
            this.name = n;
        }

        Woman(String n, int a) {
            this.name = n;
            this.age = a;
        }

        Woman(String n, int a, String b) {
            this.name = n;
            this.age = a;
            this.address = b;
        }
    }
}
