package com.javarush.test.level25.lesson09.task03;

import java.util.ArrayList;
import java.util.List;

/* Живем своим умом
В классе Solution реализуйте интерфейс UncaughtExceptionHandler, который должен:
1. прервать нить, которая бросила исключение.
2. вывести в консоль стек исключений начиная с самого вложенного.
Пример исключения: new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI")))
Пример вывода:
java.lang.IllegalAccessException: GHI
java.lang.RuntimeException: DEF
java.lang.Exception: ABC
*/
public class Solution implements Thread.UncaughtExceptionHandler {
    public static void main(String[] args) throws Exception {

        Solution solution = new Solution();
        Thread testThread = new Thread("thread-1");
        solution.uncaughtException(testThread, new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI"))));

    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {

        t.interrupt();
        List<Throwable> list = new ArrayList<>();
        list.add(e);

        Throwable throwable = e.getCause();
        while (throwable != null) {
            list.add(0, throwable);
            throwable = throwable.getCause();
        }

        for (Throwable exceptinFromList : list) {
//            System.out.println(t.getName() + " " +t.getName().replaceAll(".", "*"));
            System.out.println(exceptinFromList.getClass().getName() + ": " + exceptinFromList.getMessage());
        }
    }
}
