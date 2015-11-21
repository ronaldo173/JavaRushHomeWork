package com.javarush.test.level19.lesson03.task04;

import java.io.IOException;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/* И еще один адаптер
Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1950

В файле хранится большое количество людей,
 данные одного человека находятся в одной строке.
 Метод read() должен читать данные одного человека.
*/

public class Solution {
    public static class PersonScannerAdapter implements PersonScanner {
        private Scanner scanner;

        public PersonScannerAdapter(Scanner a) {
            this.scanner = a;
        }

        public static void main(String[] args) {
            PersonScanner adapter = new PersonScannerAdapter(new Scanner(System.in));
            try {
                Person person = adapter.read();
                System.out.println(person);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public Person read() throws IOException {
            Person person = null;
            if (scanner.hasNext()) {
                String str = scanner.nextLine();
                String slova[] = str.split(" ");
                int year, month, day;
                year = Integer.parseInt(slova[5]);
                month = Integer.parseInt(slova[4]);
                day = Integer.parseInt(slova[3]);
                Date data = (new GregorianCalendar(year, month - 1, day)).getTime();
                person = new Person(slova[1], slova[2], slova[0], data);
            }

            return person;
        }

        @Override
        public void close() throws IOException {
            this.scanner.close();
        }
    }
}
