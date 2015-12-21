package com.javarush.test.level24.lesson06.home03;

import java.lang.annotation.Documented;

/**
 * Created by Santer on 21.12.2015.
 * bla bla bla
 * javadoc from anotation
 */
@Documented
public @interface Author {
    String name = "Alex";


    String testDeprecatedMethod();
}
