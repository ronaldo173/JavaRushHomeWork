package com.javarush.test.level15.lesson12.home03;

public class Tree {
    public static int globalNumber;
    public int number;

    public Tree() {
        this.number = ++globalNumber;
    }

    public void info(Object s) {
        System.out.println(String.format("Дерево № %d , метод Object, параметр %s", number, s.getClass().getSimpleName()));
    }

    public void info(Number s) {

        System.out.println(String.format("Дерево № %d , метод Number, параметр %s", number, s.getClass().getSimpleName()));
    }

    public void info(String s) {

        System.out.println(String.format("Дерево № %d , метод String, параметр %s", number, s.getClass().getSimpleName()));
    }
}
/* ООП - перегрузка
1.В классе Tree перегрузи метод info(Object s) два раза так, чтобы получилось три метода info(Object s), info(Number s), info(String s).
1.1. Разберись в методе info(Object s). Сделай по аналогии функционал новых методов.
1.2. Например, для метода info(Number s) результат может быть таким "Дерево № 123 , метод Number, параметр Short".
2. В блоке 2 должен вызываться метод info(Object s).
3. В блоке 3 должен вызываться метод info(Number s).
4. В блоке 4 должен вызываться метод info(String s).
*/