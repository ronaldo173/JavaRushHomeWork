package com.javarush.test.level38.lesson10.home02;

public @interface Revision {
    //напиши свой код
    int revision();

    Date date();

    String comment() default "";

    Author[] authors() default {};
}
/*
  revision = 6018,
                date = @Date(year = 2013, month = 1, day = 1, hour = 0, minute = 0, second = 1),
                authors = {@Author(value = "Серега", position = Position.MIDDLE)},
                comment = "Фикс багов"),
 */