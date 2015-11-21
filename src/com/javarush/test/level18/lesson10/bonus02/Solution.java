package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id, найденный в файле

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
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        if (args[0].equals("-c")) {
            int quantity = Integer.parseInt(args[args.length - 1]);
            double price = Double.parseDouble(args[args.length - 2]);
            String[] productName = new String[args.length - 3];
            for (int i = 1; i < args.length - 2; i++) {
                productName[i - 1] = args[i];
            }

            BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
            ArrayList<String> arrayList = new ArrayList<>();
            while (fileReader.ready()) {
                arrayList.add(fileReader.readLine());
            }
            fileReader.close();

            String idLastLine = arrayList.get(arrayList.size() - 1).substring(0, 8);
            int lastId = Integer.parseInt(idLastLine.trim());


            ///////////////////////////////////////////// id для записи 8 символов
            String id = Integer.toString(lastId + 1);
            int idLenght = id.length();
            if (id.length() < 8) {
                for (int i = 0; i < 8 - idLenght; i++) {
                    id += " ";
                }
            } else {
                id = id.substring(0, 8);
            }

            ///////////////////////////////////////////// name для записи 30 символов
            String name = "";
            for (String i : productName) {
                name += i + " ";
            }

            int nameLength = name.length();
            if (name.length() < 30) {
                for (int i = 0; i < 30 - nameLength; i++) {
                    name += " ";
                }
            } else {
                name = name.substring(0, 30);
            }

            ///////////////////////////////////////////// price для записи 8 символов
            String pric = Double.toString(price);
            int pricLength = pric.length();
            if (pric.length() < 8) {
                for (int i = 0; i < 8 - pricLength; i++) {
                    pric += " ";
                }
            } else {
                pric = pric.substring(0, 8);
            }

            ///////////////////////////////////////////// quantity для записи 4 символов
            String quant = Integer.toString(quantity);
            int quantLength = quant.length();
            if (quant.length() < 4) {
                for (int i = 0; i < 4 - quantLength; i++) {
                    quant += " ";
                }
            } else {
                quant = quant.substring(0, 4);
            }

            ///////////////////////Итоговая строка для записи в конец
            String resultAdd = id + name + pric + quant;
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            writer.newLine();
            writer.write(resultAdd);
            writer.close();
        }
    }
}
