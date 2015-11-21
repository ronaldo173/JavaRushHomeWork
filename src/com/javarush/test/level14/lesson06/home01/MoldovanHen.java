package com.javarush.test.level14.lesson06.home01;

/**
 * Created by Саша on 28.07.2015.
 */
public class MoldovanHen extends Hen {

    @Override
    int getCountOfEggsPerMonth() {
        return 200;
    }

    @Override
    String getDescription() {
        return super.getDescription() + " Моя страна - " + Country.MOLDOVA + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
            /*+ <" Моя страна - SSSSS. Я несу N яиц в месяц.">*/
    }
}