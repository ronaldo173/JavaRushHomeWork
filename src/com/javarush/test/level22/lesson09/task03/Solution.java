package com.javarush.test.level22.lesson09.task03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/* ��������� ������� ����
� ������ main �������� � ������� ��� �����, ������� �������� �����, ����������� ��������.
� ������ getLine ��������� StringBuilder ���������� ��� ����� � ����� �������,
����� ��������� ����� ������� ����� ��������� � ������ ������ ���������� �� �������� �������.
������ ����� ������ ����������� 1 ���.
����� getLine ������ ���������� ����� �������.
����� ��������� ��������.
� ����� �� ����������� ����� ����� ����.

������ ���� �������� �����:
���� ���-���� ��������� ���� ��������

���������:
��������� �������� ���-���� ���� ����
*/
public class Solution {
    static Set<String> set = new TreeSet<>();
    static Set<String> setAdded = new HashSet<>();
    static StringBuilder builder = null;

    public static void main(String[] args) throws IOException {
//        String s1 = "bla".substring(0,1);
//        String s2 = "Bla".substring(0,1);
//        System.out.println(s1 + " " + s2);
//        System.out.println(s1 == s2);
//        System.out.println(s1.equals(s2));
//        System.out.println(s1.equalsIgnoreCase(s2));//true

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
//        String fileName = "C:\\Users\\Santer\\Desktop\\Development\\JavaRush\\JavaRushHomeWork\\tempJRfiles\\temp.txt";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));


        String line;
        while ((line = bufferedReader.readLine()) != null) {
            getLine(line.split(" "));
        }
        reader.close();
        bufferedReader.close();

        //...
        StringBuilder result = getLine();
        System.out.println("builder: " + result.toString());
//        System.out.println("set: " + set);
    }

    public static StringBuilder getLine(String... words) {
        if (builder == null) {
            builder = new StringBuilder();
        }
        for (String word : words) {
            set.add(word);
        }

        for (String s : set) {
            if (builder.length() == 0) {
                builder.append(s);
                setAdded.add(s);
            } else {
                for (String s1 : set) {
                    String temp = new String(new StringBuilder(builder).reverse());
                    temp = temp.substring(0, 1);
                    if (!setAdded.contains(s1) && temp.equalsIgnoreCase(s1.substring(0, 1))) {
                        builder.append(" " + s1);
                        setAdded.add(s1);
                    }
                }
            }
        }

        return builder;
    }
}
