package com.javarush.test.level19.lesson03.task05;

import java.util.HashMap;
import java.util.Map;

/* Закрепляем адаптер
Адаптировать Customer и Contact к RowItem.
Классом-адаптером является DataAdapter.
Инициализируйте countries перед началом выполнения программы. Соответствие кода страны и названия:
UA Ukraine
RU Russia
CA Canada
*/

public class Solution {
    private static Map<String, String> countries = new HashMap<String, String>();

    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static void main(String[] args) {
        Customer customer = new Customer() {
            @Override
            public String getCompanyName() {
                return "JavaRush Ltd.";
            }

            @Override
            public String getCountryName() {
                return "Canada";
            }
        };
        Contact contact = new Contact() {
            @Override
            public String getName() {
                return "Ivanov, Ivan";
            }

            @Override
            public String getPhoneNumber() {
                return "+38(050)123-45-67";
            }
        };
        RowItem rowItem = new DataAdapter(customer, contact);
        System.out.println(rowItem.getCountryCode());
        System.out.println(rowItem.getCompany());
        System.out.println(rowItem.getContactFirstName());
        System.out.println(rowItem.getContactLastName());
        System.out.println(rowItem.getDialString());
    }

    public static interface RowItem {
        String getCountryCode();        //example UA

        String getCompany();            //example JavaRush Ltd.

        String getContactFirstName();   //example Ivan

        String getContactLastName();    //example Ivanov

        String getDialString();         //example callto://+380501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.

        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan

        String getPhoneNumber();        //example +38(050)123-45-67
    }

    public static class DataAdapter implements RowItem {

        private Customer customer;
        private Contact contact;
        private String fullName;


        public DataAdapter(Customer customer, Contact contact) {
            this.contact = contact;
            this.customer = customer;
            fullName = contact.getName();
        }


        @Override
        public String getCountryCode() {
            String countryName = customer.getCountryName();
            String countryCode = null;
            for (Map.Entry<String, String> a : countries.entrySet()) {
                if (a.getValue().equals(countryName)) {
                    countryCode = a.getKey();
                }
            }
            return countryCode;
        }

        @Override
        public String getCompany() {
            return customer.getCompanyName();
        }

        @Override
        public String getContactFirstName() {
            String firstName = fullName.split(", ")[1];
            return firstName;
        }

        @Override
        public String getContactLastName() {
            String lastName = fullName.split(", ")[0];
            return lastName;
        }

        @Override
        public String getDialString() {
            String str = contact.getPhoneNumber();
//            ArrayList<Character> arrayList=new ArrayList<>();
//            for (int i = 0; i < str.length(); i++) {
//                arrayList.add((str.toCharArray())[i]);
//            }
//            Iterator<Character> iterator=arrayList.iterator();
//            while (iterator.hasNext()){
//                if (iterator.next().equals('-') ){
//                    iterator.remove();
//                }
//            }
//            str="";
//            for(Character i: arrayList){
//                str+=i;
//            }
//           String res=str.substring(0,3) + str.substring(4,7) + str.substring(8);

            String res = str.replaceAll("[^+0-9]", "");
            return "callto://" + res;
        }
    }
}