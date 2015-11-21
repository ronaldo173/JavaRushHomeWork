package com.javarush.test.level18.lesson10.bonus03;

/* Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {

    public static String addSpaces(String str, int size) {
        int lendth = str.length();
        if (lendth < size) {
            for (int i = 0; i < size - lendth; i++) {
                str += " ";
            }
        } else {
            str = str.substring(0, size);
        }
        return str;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName;
        fileName = reader.readLine();
        reader.close();

        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        ArrayList<String> arrayListFile = new ArrayList<>();
        ArrayList<String> arrayListToFile = new ArrayList<>();
        while (bufferedReader.ready()) {
            arrayListFile.add(bufferedReader.readLine());
        }
        bufferedReader.close();

        if (args.length > 0) {
            if (args[0].equals("-u")) {
                //////////////////////// получаю значения из массива  args
                String id = args[1];          ////////////////////////id
                ArrayList<String> prArr = new ArrayList<>();

                for (int i = 2; i < args.length - 2; i++) {
                    prArr.add(args[i]);
                }
                String productName = "";////////////////////productName
                for (String i : prArr) {
                    productName += i + " ";
                }

                String price = args[args.length - 2];/////////price
                String quantity = args[args.length - 1];//////quantity

                String newString = addSpaces(id, 8) + addSpaces(productName, 30) + addSpaces(price, 8) + addSpaces(quantity, 4); ///новая строка


                ///////////
                for (String i : arrayListFile) {///если начинается строка с id то в новый список кидаю обновленную строку
                    if (i.substring(0, 8).trim().equals(id)) {
                        i = newString;
                    }
                    arrayListToFile.add(i);
                }

            } else if (args[0].equals("-d")) {////////добавляю в список arrayListToFile все кроме удаленной строки
                String id = args[1];
                //System.out.println(arrayListFile);
                for (String s : arrayListFile) {
                    //System.out.println(s.substring(0, 8).trim());
                    if (!(s.substring(0, 8).trim()).equals(id)) {
                        arrayListToFile.add(s);
                    }
                }
            }

            ////записываю в файл обновленный список( или с удаленным элементом)
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            for (String i : arrayListToFile) {
                writer.write(i);
                writer.newLine();
            }
            writer.close();
        }
    }
}
