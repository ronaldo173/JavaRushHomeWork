package com.javarush.test.level20.lesson10.home03;

import java.io.*;

/* Найти ошибки
Почему-то при сериализации/десериализации объекта класса B возникают ошибки.
Найдите проблему и исправьте ее.
Класс A не должен реализовывать интерфейсы Serializable и Externalizable.
Сигнатура класса В не содержит ошибку :)
Метод main не участвует в тестировании.
*/
public class Solution {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File file = new File("tempJRfiles\\temp.txt");
        B bBefore = new B("beforeSerializ");
        B bAfter = null;

        if (!file.exists()) {
            file.createNewFile();
        }

        try (FileOutputStream fileOutputStream = new FileOutputStream(file);
             FileInputStream fileInputStream = new FileInputStream(file);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {

            objectOutputStream.writeObject(bBefore);
            bAfter = (B) objectInputStream.readObject();
        }

        System.out.println(bBefore.name + "----" + bAfter.name);
    }

    public static class A {
        protected String name = "A";

        public A() {
        }

        public A(String name) {
            this.name += name;
        }
    }

    public static class B extends A implements Serializable {
        public B(String name) {
            super(name);
            this.name += name;
        }
    }
}
