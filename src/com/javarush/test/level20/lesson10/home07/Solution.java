package com.javarush.test.level20.lesson10.home07;

import java.io.*;


public class Solution implements Serializable, AutoCloseable {
    private transient FileOutputStream stream;
    private String fileName;

    public Solution(String fileName) throws FileNotFoundException {
        this.stream = new FileOutputStream(fileName);
        this.fileName = fileName;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String path = new String("tempJRfiles\\temp.txt");
        Solution solution = new Solution(path);
        Solution loadedSolution = null;
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path));
             ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path))) {
            solution.writeObject("privet");
            objectOutputStream.writeObject(solution);

            loadedSolution = (Solution) objectInputStream.readObject();
            loadedSolution.writeObject("privet2");
        }

        System.out.println("---");
        System.out.println(solution + "---" + loadedSolution);
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
//        out.close();
//        out.writeObject(fileName);
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
//        in.defaultReadObject();
        in.defaultReadObject();
        stream = new FileOutputStream(this.fileName, true);
//        in.close();
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

}
/* Переопределение сериализации в потоке
Сериализация/десериализация Solution не работает.
Исправьте ошибки не меняя сигнатуры методов и класса.
Метод main не участвует в тестировании.
Написать код проверки самостоятельно в методе main:
1) создать экземпляр класса Solution
2) записать в него данные  - writeObject
3) сериализовать класс Solution  - writeObject(ObjectOutputStream out)
4) десериализовать, получаем новый объект
5) записать в новый объект данные - writeObject
6) проверить, что в файле есть данные из п.2 и п.5
*/