package com.javarush.test.level26.lesson15.big01;

/**
 * Created by Alex on 18.01.2016.
 */
public class CashMachine {
    public static void main(String[] args) {

        String currencyCode = ConsoleHelper.askCurrencyCode();
        String[] validTwoDigits = ConsoleHelper.getValidTwoDigits(currencyCode);

//        System.out.println(currencyCode);
//        System.out.println(Arrays.toString(validTwoDigits));

        CurrencyManipulator manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
        manipulator.addAmount(Integer.parseInt(validTwoDigits[0]), Integer.parseInt(validTwoDigits[1]));

        manipulator.getTotalAmount();

    }
}
/*
2. Добавим вызов метода getTotalAmount() в метод main.
Всё работает верно? Тогда движемся дальше.
Видно, что метод getTotalAmount() считает то, что нам необходимо для операции INFO.
Поэтому пришло время небольшого рефакторинга.
!!Читайте паттерн Command.
Однако, перед рефакторингом нужно еще разобраться в одном вопросе. Но об этом не сейчас.
 */