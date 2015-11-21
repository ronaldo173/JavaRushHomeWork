package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него. Каждый конструктор должен иметь смысл.
*/

import java.util.Date;

public class Solution {
    public static void main(String[] args) {

    }

    public static class Human {
        private String firstName;
        private String familyName;
        private boolean sex;
        private Date dateBorn;
        private String city;
        private int id;

        public Human() {
        }

        public Human(Date dateBorn) {
            this.dateBorn = dateBorn;
        }

        public Human(int id) {
            this.id = id;
        }

        public Human(String firstName) {
            this.firstName = firstName;
        }

        public Human(String firstName, String familyName) {
            this.firstName = firstName;
            this.familyName = familyName;
        }

        public Human(String firstName, String familyName, Date dateBorn) {
            this.firstName = firstName;
            this.familyName = familyName;
            this.dateBorn = dateBorn;
        }

        public Human(boolean sex) {
            this.sex = sex;
        }

        public Human(String firstName, String familyName, Date dateBorn, boolean sex) {
            this.firstName = firstName;
            this.familyName = familyName;
            this.dateBorn = dateBorn;
            this.sex = sex;
        }

        public Human(String firstName, String familyName, Date dateBorn, boolean sex, String city) {
            this(firstName, familyName, dateBorn, sex);
            this.city = city;
        }

        public Human(String firstName, String familyName, Date dateBorn, boolean sex, String city, int id) {
            this(firstName, familyName, dateBorn, sex, city);
            this.id = id;
        }
    }
}