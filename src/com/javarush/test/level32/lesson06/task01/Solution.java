package com.javarush.test.level32.lesson06.task01;

import java.io.ByteArrayOutputStream;
import java.util.HashSet;
import java.util.Random;

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

        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            byteArrayOutputStream.write(48 + random.nextInt(10));
        }
        for (int i = 0; i < 3; i++) {
            byteArrayOutputStream.write(65 + random.nextInt(26));
        }
        for (int i = 0; i < 2; i++) {
            byteArrayOutputStream.write(97 + random.nextInt(26));
        }
        return byteArrayOutputStream;
    }

}
