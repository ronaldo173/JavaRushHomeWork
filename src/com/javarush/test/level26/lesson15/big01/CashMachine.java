package com.javarush.test.level26.lesson15.big01;

import java.util.Locale;

/**
 * Created by Саша on 21.09.2015.
 */
public class CashMachine {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        String code = ConsoleHelper.askCurrencyCode();
        System.out.println("TEST CODE --------- " + code);
        ConsoleHelper.getValidTwoDigits(code);
        CurrencyManipulator currencyManipulator = new CurrencyManipulator(code);


    }
}
