package com.javarush.test.level15.lesson09.task01;

import java.util.HashMap;
import java.util.Map;

/* Статики 1
В статическом блоке инициализировать labels 5 различными парами.
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();

    static {
        labels.put((double) 1, "one");
        labels.put((double) 2, "one");
        labels.put((double) 3, "one");
        labels.put((double) 4, "one");
        labels.put((double) 5, "one");
    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
