package com.javarush.test.level20.lesson10.home06;

import java.io.*;

/* Запрет сериализации
Запретите сериализацию класса SubSolution используя NotSerializableException.
Сигнатуры классов менять нельзя
*/
public class Solution implements Serializable {
    public static void main(String[] args) throws IOException {
        try (FileOutputStream fileOutputStream = new FileOutputStream("bla");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(new SubSolution());

        }
    }

    public static class SubSolution extends Solution {
        private void writeObject(ObjectOutputStream objectOutput) throws NotSerializableException {
//            System.out.println("bla");
            throw new NotSerializableException();
        }

        private void readObject(ObjectInputStream objectInputStream) throws NotSerializableException {
            throw new NotSerializableException();
        }
    }
}
