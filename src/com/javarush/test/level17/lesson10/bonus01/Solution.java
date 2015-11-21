package com.javarush.test.level17.lesson10.bonus01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD
CrUD - Create, Update, Delete
Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-u id name sex bd
-d id
-i id
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-c  - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-u  - обновляет данные человека с данным id
-d  - производит логическое удаление человека с id
-i  - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)

id соответствует индексу в списке
Все люди должны храниться в allPeople
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat

Пример параметров: -c Миронов м 15/04/1990
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        //start here - начни тут
        Person person = null;
        SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        SimpleDateFormat format2 = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

        if (args[0].equals("-c")) {      //////////////////////////-c  - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
            if (args[2].equals("м")) {
                person = Person.createMale(args[1], format1.parse(args[3]));
                allPeople.add(person);
            } else {
                person = Person.createFemale(args[1], format1.parse(args[3]));
                allPeople.add(person);
            }
            System.out.println(allPeople.indexOf(person));
        } else if (args[0].equals("-u")) {      /////////////////////////-u  - обновляет данные человека с данным id
            int index = Integer.parseInt(args[1]);
            if (args[3].equals("м")) {
                person = Person.createMale(args[2], format1.parse(args[4]));
                allPeople.set(index, person);
            } else {
                person = Person.createFemale(args[2], format1.parse(args[4]));
                allPeople.set(index, person);
            }
        } else if (args[0].equals("-d")) {  ////////////-d  - производит логическое удаление человека с id
            //allPeople.remove(Integer.parseInt(args[1]));
            int index = Integer.parseInt(args[1]);
            allPeople.get(index).setName("");
            allPeople.get(index).setSex(null);
            allPeople.get(index).setBirthDay(null);

        } else if (args[0].equals("-i")) {  ///////////////////////////////-i  - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)
            int index = Integer.parseInt(args[1]);
            person = allPeople.get(index);
            String name = person.getName();
            String sex;
            String bd;
            if (allPeople.get(index).getSex() == Sex.MALE) {
                sex = "м";
            } else {
                sex = "ж";
            }
            bd = format2.format(person.getBirthDay());
            System.out.println(name + " " + sex + " " + bd);
        }

    }
}
//-i  - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)