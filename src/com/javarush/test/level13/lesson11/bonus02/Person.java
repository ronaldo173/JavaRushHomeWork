package com.javarush.test.level13.lesson11.bonus02;

public class Person implements RepkaItem {
    private String name;
    private String namePadezh;

    public Person(String name, String namePadezh) {
        this.name = name;
        this.namePadezh = namePadezh;
    }

    @Override
    public String getNamePadezh() {
        return namePadezh;
    }


    public void pull(Person person) {
        System.out.println(this.name + " за " + person.namePadezh);
    }
}
/*2. В классе Person реализовать метод pull(Person person), который выводит фразу типа '<name> за <person>'. Пример:
Бабка за Дедку
        Дедка за Репку */