package com.javarush.test.level32.lesson06.task01;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* Генератор паролей
Реализуйте логику метода getPassword, который должен возвращать ByteArrayOutputStream, в котором будут байты пароля.
Требования к паролю:
1) 8 символов
2) только цифры и латинские буквы разного регистра
3) обязательно должны присутствовать цифры, и буквы разного регистра
Все сгенерированные пароли должны быть уникальные.
Пример правильного пароля:
wMh7SmNu
*/
public class Solution {
    private static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static HashSet<StringBuilder> hashSet = new HashSet<>();

    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < 8; i++) {
            builder.append(AB.charAt(new Random().nextInt(AB.length())));
        }
        if (hashSet.contains(builder) || countDigitsInBuilder(builder)
                || countLetterLowUpperCaseInBuilder(builder)) {
            byteArrayOutputStream = getPassword();
        }
        hashSet.add(builder);
        try {
            byteArrayOutputStream.write(builder.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return byteArrayOutputStream;
    }

    private static boolean countLetterLowUpperCaseInBuilder(StringBuilder builder) {
        Pattern letterLowCasePattern = Pattern.compile("[a-z]");
        Matcher lowMatcher = letterLowCasePattern.matcher(builder);
        int lowCount = 0;
        while (lowMatcher.find()) {
            lowCount++;
        }
        if (lowCount < 1) {
            return true;
        }

        Pattern letterUpperCase = Pattern.compile("[A-Z]");
        Matcher upperMatcher = letterUpperCase.matcher(builder);
        int upperCount = 0;
        while (upperMatcher.find()) {
            upperCount++;
        }
        if (upperCount < 1) {
            return true;
        }
        return false;
    }


    private static boolean countDigitsInBuilder(StringBuilder builder) {
        Pattern digitPattern = Pattern.compile("\\d");
        Matcher digitMatcher = digitPattern.matcher(builder);
        int digitCount = 0;
        while (digitMatcher.find()) {
            digitCount++;
        }
        return digitCount < 1 ? true : false;
    }
}
