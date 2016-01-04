package com.javarush.test;

import java.nio.file.Path;
import java.nio.file.Paths;

enum Days {
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
}

/**
 * Created by Santer on 03.01.2016.
 */
public class testEnum {
    public static void main(String[] args) {
        System.out.println(Days.values()[1]);

        Path path = Paths.get("C:\\Users\\Alex\\Desktop\\диплом");
        Path pathOfFileOtnositelniy = Paths.get("idea.png");

        System.out.println(path);
        System.out.println(pathOfFileOtnositelniy);
        System.out.println("--");
        System.out.println(path.resolve(pathOfFileOtnositelniy));
    }

}
