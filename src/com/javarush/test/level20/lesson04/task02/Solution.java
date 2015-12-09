package com.javarush.test.level20.lesson04.task02;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* Как сериализовать JavaRush?
Сделайте так, чтобы сериализация класса JavaRush была возможной
*/
public class Solution {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File file = new File("tempJRfiles\\testSerializ.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        JavaRush javaRush = new JavaRush();
        List<User> users = javaRush.users;
        User person = new User();
        person.setFirstName("Alex");
        person.setLastName("Efimov");
        person.setCountry(User.Country.UKRAINE);
        users.add(person);
        for (User user : users) {
            System.out.println(user.getFirstName() + user.getLastName() + user.getCountry());
        }
        System.out.println("-----");

        JavaRush javaRushLoaded = new JavaRush();

        try (FileOutputStream fileOutputStream = new FileOutputStream(file);
             FileInputStream fileInputStream = new FileInputStream(file);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)
        ) {
            objectOutputStream.writeObject(javaRush);
            javaRushLoaded = (JavaRush) objectInputStream.readObject();
        }
        for (User user : javaRushLoaded.users) {
            System.out.println(user.getFirstName() + " " + user.getLastName() + " " + user.getCountry());
        }
    }

    public static class JavaRush implements Serializable {
        public List<User> users = new ArrayList<>();
    }
}
