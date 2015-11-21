package com.javarush.test.level14.lesson06.home01;

/**
 * Created by Саша on 28.07.2015.
 */
public class RussianHen extends Hen {

    @Override
    int getCountOfEggsPerMonth() {
        return 400;
    }

    @Override
    String getDescription() {
        return super.getDescription() + " Моя страна - " + Country.RUSSIA + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
            /*+ <" Моя страна - SSSSS. Я несу N яиц в месяц.">*/
    }
}