package com.javarush.test.level19.lesson10.home03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException {
        String fileName = args[0];
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String s;
        while ((s = reader.readLine()) != null) {
            ArrayList<Integer> indexOfValue = new ArrayList<>();
            ArrayList<String> temp = new ArrayList<>();
            Collections.addAll(temp, s.split(" "));
            for (int i = 0; i < temp.size(); i++) {
                if (isNumber(temp.get(i))) indexOfValue.add(i);
            }

            int firstNumbPos = indexOfValue.get(0);
            int year = Integer.parseInt(temp.get(firstNumbPos + 2));
            int month = Integer.parseInt(temp.get(firstNumbPos + 1));
            int day = Integer.parseInt(temp.get(firstNumbPos));
            String name = "";
            for (int i = 0; i < firstNumbPos; i++) {
                name += temp.get(i) + " ";
            }
            name = name.substring(0, name.length() - 1);

            Calendar dataBirthday = new GregorianCalendar(year, month - 1, day);
            PEOPLE.add(new Person(name, dataBirthday.getTime()));


//            System.out.println(temp);
//            System.out.println(indexOfValue);
//            System.out.println(name);
//            System.out.println(dataBirthday.getTime());

            indexOfValue.removeAll(indexOfValue);
            temp.removeAll(temp);

        }
        reader.close();

//        for (int i = 0; i < PEOPLE.size(); i++) {
//            System.out.println(PEOPLE.get(i));
//        }


    }

    public static boolean isNumber(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

}
