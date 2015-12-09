package com.javarush.test.level07.lesson12.home06;

/* Семья
Создай класс Human с полями имя(String), пол(boolean),возраст(int), отец(Human), мать(Human). Создай объекты и заполни их так, чтобы получилось: Два дедушки, две бабушки, отец, мать, трое детей. Вывести объекты на экран.
Примечание:
Если написать свой метод String toString() в классе Human, то именно он будет использоваться при выводе объекта на экран.
Пример вывода:
Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
Имя: Катя, пол: женский, возраст: 55
Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
…
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Human grandFother = new Human("Ded1", true, 100, null, null);
        Human grandFother2 = new Human("Ded2", true, 100, null, null);

        Human grandMother = new Human("BABA1", false, 100, null, null);
        Human grandMother2 = new Human("BABA2", false, 100, null, null);

        Human mother = new Human("mother", false, 50, grandFother, grandMother);
        Human father = new Human("father", false, 50, grandFother, grandMother);

        Human child1 = new Human("child1", false, 22, father, mother);
        Human child2 = new Human("child2", false, 22, father, mother);
        Human child3 = new Human("child3", true, 199, father, mother);

        System.out.println(grandFother);
        System.out.println(grandFother2);
        System.out.println(grandMother);
        System.out.println(grandMother2);
        System.out.println(mother);
        System.out.println(father);
        System.out.println(child1);
        System.out.println(child2);
        System.out.println(child3);
    }

    public static class Human {
        String name;
        boolean sex;
        int age;
        Human father;
        Human mother;

        //напишите тут ваш код
        public Human(String name, boolean sex, int age, Human father, Human motther) {
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.father = father;
            this.mother = motther;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }

}
