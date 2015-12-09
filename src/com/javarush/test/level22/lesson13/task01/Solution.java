package com.javarush.test.level22.lesson13.task01;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/* StringTokenizer
Используя StringTokenizer разделить query на части по разделителю delimiter.
Пример,
getTokens("level22.lesson13.task01", ".") == {"level22", "lesson13", "task01"}
*/
public class Solution {
    public static String[] getTokens(String query, String delimiter) {
//        return query.split("\\" + delimiter);

        String[] result;
        List<String> list = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(query, delimiter);
        while (tokenizer.hasMoreTokens()) {
            list.add(tokenizer.nextToken());
        }
        result = (String[]) list.toArray(new String[0]);

        return result;
    }

    public static void main(String[] args) {
        String s[] = getTokens("level22.lesson13.task01", ".");
        for (String s1 : s) {
            System.out.println(s1);
        }
    }
}
