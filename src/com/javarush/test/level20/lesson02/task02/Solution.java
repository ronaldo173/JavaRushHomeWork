package com.javarush.test.level20.lesson02.task02;

import java.io.*;
import java.util.*;

/* Читаем и пишем в файл: JavaRush
Реализуйте логику записи в файл и чтения из файла для класса JavaRush
В файле your_file_name.tmp может быть несколько объектов JavaRush
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User user = new User();
            user.setFirstName("Alex");
            user.setLastName("Efimov");
            user.setCountry(User.Country.UKRAINE);
            user.setMale(true);
            user.setBirthDate((new GregorianCalendar(1993, Calendar.JANUARY, 16)).getTime());
            javaRush.users.add(user);

            User user1 = new User();
            user1.setFirstName("Pendergast");
            user1.setMale(true);
            user1.setCountry(User.Country.RUSSIA);
            javaRush.users.add(user1);

            User user2 = new User();
            user2.setFirstName("Peinter Crou");
            user2.setBirthDate(new Date(123456789));
            javaRush.users.add(user2);
            ////
            javaRush.save(outputStream);
            outputStream.flush();


            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны

            for (User users : javaRush.users) {
                System.out.println(users);
            }
            System.out.println("****************---AFTER SAVE-LOAD---------********");
            for (User us2 : loadedObject.users) {
                System.out.println(us2);
            }


            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter writer = new PrintWriter(outputStream);
            if (this.users.size() > 0) {
                for (User user : users) {
                    writer.println("@");
                    if (user.getFirstName() == null) {
                        writer.println("***");
                    } else {
                        writer.println("+++");
                        writer.println(user.getFirstName());
                    }

                    if (user.getLastName() == null) {
                        writer.println("***");
                    } else {
                        writer.println("+++");
                        writer.println(user.getLastName());
                    }

                    if (user.getBirthDate() == null) {
                        writer.println("***");
                    } else {
                        writer.println("+++");
                        writer.println(user.getBirthDate().getTime());
                    }

                    if (user.getCountry() == null) {
                        writer.println("***");
                    } else {
                        writer.println("+++");
                        writer.println(user.getCountry());
                    }

                    writer.println(user.isMale());
                }
                writer.close();
            }
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            while (reader.ready()) {
                String str = reader.readLine();
                if (str.equals("@")) {
                    User user1 = new User();
                    String check = reader.readLine();
                    if (!check.equals("***")) {
                        user1.setFirstName(reader.readLine());
                    } else {
                    }

                    check = reader.readLine();
                    if (!check.equals("***")) {
                        user1.setLastName(reader.readLine());
                    } else {
                    }

                    check = reader.readLine();
                    if (!check.equals("***")) {
                        user1.setBirthDate(new Date(Long.parseLong(reader.readLine())));
                    } else {
                    }

                    check = reader.readLine();
                    if (!check.equals("***")) {
                        user1.setCountry(stringToCountry(reader.readLine()));
                    } else {
                    }

                    user1.setMale(Boolean.parseBoolean(reader.readLine()));
                    this.users.add(user1);
                }
            }
        }

        public User.Country stringToCountry(String string) {
            return User.Country.valueOf(string);
        }
    }
}
