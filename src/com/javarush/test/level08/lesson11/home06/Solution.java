package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        //Написать тут ваш код
        ArrayList<Human> children1 = new ArrayList<Human>();
        Human Child1 = new Human("child1", true, 5, new ArrayList<Human>());
        Human Child2 = new Human("child2", true, 5, new ArrayList<Human>());
        Human Child3 = new Human("child3", true, 5, new ArrayList<Human>());

        children1.add(Child1);
        children1.add(Child2);
        children1.add(Child3);


        Human Father = new Human("father", true, 56, children1);
        Human Mother = new Human("mother", false, 56, children1);

        ArrayList<Human> children2 = new ArrayList<Human>();
        children2.add(Father);
        ArrayList<Human> children3 = new ArrayList<Human>();
        children3.add(Mother);

        Human gMom1 = new Human("gmom1", false, 56, children2);
        Human gDad1 = new Human("gmom1", false, 56, children2);

        Human gMom2 = new Human("gmom2", false, 56, children3);
        Human gDad2 = new Human("gmom2", false, 56, children3);

        System.out.println(gDad1);
        System.out.println(gDad2);
        System.out.println(gMom1);
        System.out.println(gMom2);

        System.out.println(Father);
        System.out.println(Mother);

        System.out.println(Child1);
        System.out.println(Child2);
        System.out.println(Child3);


    }

    public static class Human {
        //напишите тут ваш код
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children;

        Human(String name, boolean pol, int age, ArrayList<Human> children) {
            this.name = name;
            this.sex = pol;
            this.age = age;
            this.children = children;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }

            return text;
        }
    }

}
