package com.javarush.test.level37.lesson04.big01;

import com.javarush.test.level37.lesson04.big01.female.FemaleFactory;
import com.javarush.test.level37.lesson04.big01.male.MaleFactory;

/**
 * Created by Santer on 18.01.2016.
 */
public class FactoryProducer {
    public static AbstractFactory getFactory(HumanFactoryType sex) {
        if (sex == HumanFactoryType.MALE) {
            return new MaleFactory();
        } else {
            return new FemaleFactory();
        }
    }

    public static enum HumanFactoryType {
        MALE, FEMALE
    }
}

/*
3. В корне задачи создай класс FactoryProducer, в котором создай публичный статический энум HumanFactoryType
        со значениями MALE, FEMALE.

        4. В FactoryProducer создайт публичный статический метод getFactory с аргументом HumanFactoryType.
        Этот метод должен возвращать одну из фабрик: для ключа MALE - MaleFactory, для FEMALE - FemaleFactory.

        Молодец, Фабрика фабрик готова!  Это паттерн Abstract Factory.
        В коде тебе не важно, какая фабрика используется.
*/