package com.javarush.test.level20.lesson10.home04;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* Исправить ошибку
После десериализации объекта класса Solution обнаружили, что данных в словаре [m] нет :(
Исправить 1 ошибку.
Метод main в тестировании не участвует.
*/
public class Solution implements Serializable {

    private Map<String, String> m = new HashMap<>();

    public Solution() { /////HERE WAS VOID!!! It's CONSTRUCTOR! ye baby
        m.put("Mickey", "Mouse");
        m.put("Mickey", "Mantle");
        System.out.println("test");
    }

    public static void main(String args[]) throws Exception {
        FileOutputStream fileOutput = new FileOutputStream("tempJRfiles\\temp.txt");
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutput);

        Solution solution = new Solution();
        outputStream.writeObject(solution);

        fileOutput.close();
        outputStream.close();

        //loading
        FileInputStream fiStream = new FileInputStream("tempJRfiles\\temp.txt ");
        ObjectInputStream objectStream = new ObjectInputStream(fiStream);

        Solution loadedObject = (Solution) objectStream.readObject();

        fiStream.close();
        objectStream.close();

        //Attention!!
        System.out.println("solution size:" + solution.getMap().size());
        System.out.println("loaded: " + loadedObject.getMap().size());
        System.out.println("--");
        for (Map.Entry<String, String> stringStringEntry : solution.getMap().entrySet()) {
            System.out.println(stringStringEntry.getKey() + " " + stringStringEntry.getValue());
        }
    }

    public Map<String, String> getMap() {
        return m;
    }

    public int size() {
        return m.size();
    }


}
