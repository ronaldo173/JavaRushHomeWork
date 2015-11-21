package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки. Не использовать try-with-resources

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1, fileName2;
        fileName1 = reader.readLine();
        fileName2 = reader.readLine();
        reader.close();


        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName1));
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<String> arraySlov = new ArrayList<>();
        ArrayList<Integer> arraySifr = new ArrayList<>();
        String s = null;

        while ((s = bufferedReader.readLine()) != null) {
            arrayList.add(s);
        }
        bufferedReader.close();

        for (String i : arrayList) {
            String[] temp = i.split(" ");
            for (int j = 0; j < temp.length; j++) {
                arraySlov.add(temp[j]);
            }
        }
        for (String i : arraySlov) {
            if (isNumber(i)) {
                arraySifr.add(Integer.parseInt(i));
            }
        }

        FileWriter fileWriter = new FileWriter(fileName2);
        for (int i = 0; i < arraySifr.size(); i++) {
            fileWriter.write(arraySifr.get(i).toString() + " ");
        }
        fileWriter.close();

//        System.out.println(arrayList);
//        System.out.println(arraySlov);
        //System.out.println(arraySifr);
        //C:\Users\Саша\Desktop\Java applications\test.txt
    }

    static boolean isNumber(String str) {
        try {
            double d = Double.parseDouble(str);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
