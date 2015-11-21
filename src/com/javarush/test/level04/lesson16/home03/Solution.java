package com.javarush.test.level04.lesson16.home03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Посчитать сумму чисел
Вводить с клавиатуры числа и считать их сумму. Если пользователь ввел -1, вывести на экран сумму и завершить программу.
 -1 должно учитываться в сумме.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        int s = 0;
        int in = Integer.parseInt(buf.readLine());

        while (true) {
            s += in;
            if (in == -1) {
                break;
            }

            in = Integer.parseInt(buf.readLine());
        }
        System.out.println(s);
    }
}
