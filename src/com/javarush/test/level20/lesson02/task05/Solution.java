package com.javarush.test.level20.lesson02.task05;

import java.io.*;

/* И еще раз о синхронизации
Разберитесь почему не работает метод main()
Реализуйте логику записи в файл и чтения из файла для класса Object
Метод load должен инициализировать объект данными из файла
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static int countStrings;

    public static void main(java.lang.String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = new File("tempJRfiles\\temp20-2-5.txt");
            if (!your_file_name.exists()) {
                your_file_name.createNewFile();
            }
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            Object object = new Object();
            object.string1 = new String();   //string #1
            object.string2 = new String();   //string #2
            System.out.println(object + " " + object.string1.number + " " + object.string2.number);
            object.save(outputStream);
            outputStream.flush();

            Object loadedObject = new Object();
            loadedObject.string1 = new String(); //string #3
            loadedObject.string2 = new String(); //string #4

            loadedObject.load(inputStream);
            System.out.println(loadedObject + " " + loadedObject.string1.number + " " + loadedObject.string2.number);
            //check here that the object variable equals to loadedObject - проверьте тут, что object и loadedObject равны

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
//            System.out.println("Oops, something wrong with save/load method");
        }
    }


    public static class Object {
        public String string1;
        public String string2;

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            try (PrintWriter writer = new PrintWriter(outputStream)) {
                java.lang.String checkStr1 = checkString(string1);
                java.lang.String checkStr2 = checkString(string2);

                writer.println(checkStr1);
                if (checkStr1.equals("yes")) {
                    writer.println(string1.number);
                }
                writer.println(checkStr2);
                if (checkStr1.equals("yes")) {
                    writer.println(string2.number);
                }
//                writer.println("----");//test serialization
//                ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
//                objectOutputStream.writeObject(this);
//                objectOutputStream.close();
            }
        }

        private java.lang.String checkString(String string1) {
            if (string1 != null) {
                return "yes";
            } else return "no";
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
                if (reader.readLine().equals("yes")) {
                    countStrings = Integer.parseInt(reader.readLine()) - 1;
                    this.string1 = new String();
                }
                if (reader.readLine().equals("yes")) {
//                    System.out.println(Integer.parseInt(reader.readLine()));
                    countStrings = Integer.parseInt(reader.readLine()) - 1;
                    this.string2 = new String();
                }
            }
        }
    }

    public static class String {
        private final int number;

        public String() {
            number = ++countStrings;
        }

        public void print() {
            System.out.println("string #" + number);
        }
    }
}
