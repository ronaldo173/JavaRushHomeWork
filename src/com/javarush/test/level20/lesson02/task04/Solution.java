package com.javarush.test.level20.lesson02.task04;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* Читаем и пишем в файл статики
Реализуйте логику записи в файл и чтения из файла для класса ClassWithStatic
Метод load должен инициализировать объект включая статические поля данными из файла
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream
        // according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream
        // в соответствии с путем к вашему реальному файлу
        try {

            File your_file_name = new File("tempJRfiles\\temp.txt");
            if (!your_file_name.exists()) {
                your_file_name.createNewFile();
            }
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            ClassWithStatic classWithStatic = new ClassWithStatic();
            classWithStatic.i = 3;
            classWithStatic.j = 4;
            classWithStatic.save(outputStream);
            outputStream.flush();

            ClassWithStatic loadedObject = new ClassWithStatic();
            loadedObject.staticString = "something";
            loadedObject.i = 6;
            loadedObject.j = 7;

            loadedObject.load(inputStream);
            //check here that classWithStatic object equals to loadedObject object - проверьте тут,
            // что classWithStatic и loadedObject равны
            System.out.println(classWithStatic.equals(loadedObject));
            System.out.println("saved: " + classWithStatic);
            System.out.println("loaded: " + loadedObject);

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

    public static class ClassWithStatic {
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof ClassWithStatic)) return false;
            ClassWithStatic that = (ClassWithStatic) o;
            return Objects.equals(i, that.i) &&
                    Objects.equals(j, that.j);
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, j);
        }

        @Override
        public String toString() {
            return "ClassWithStatic{" +
                    "i=" + i +
                    ", j=" + j +
                    '}' + "staticString: " + staticString;
        }
        //*******

        public static String staticString = "it's test static string";
        public int i;
        public int j;

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            try (
                    PrintWriter writer = new PrintWriter(outputStream)
            ) {
                String hasStaticString = (staticString!=null) ? "yes":"no";
                writer.println(hasStaticString);
                if(hasStaticString.equals("yes")){
                    writer.println(staticString);
                }else {
                    writer.println("");
                }
                writer.println(i);
                writer.println(j);
            }
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            try(
                    BufferedReader reader=new BufferedReader(new InputStreamReader(inputStream))
                    ){
                String s;
                List<String > list = new ArrayList<>();
                while( (s=reader.readLine()) !=null){
                    list.add(s);
                }
                String firstString=list.get(0);
                if(firstString.equals("yes")){
                    staticString=list.get(1);
                }else staticString=null;
                i= Integer.parseInt(list.get(2));
                j= Integer.parseInt(list.get(3));
            }
        }
    }
}
