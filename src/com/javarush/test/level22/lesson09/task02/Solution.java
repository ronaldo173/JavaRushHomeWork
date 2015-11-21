package com.javarush.test.level22.lesson09.task02;

import java.util.LinkedHashMap;
import java.util.Map;

/* Формируем Where
Сформируйте часть запроса WHERE используя StringBuilder.
Если значение null, то параметр не должен попадать в запрос.
Пример:
{"name", "Ivanov", "country", "Ukraine", "city", "Kiev", "age", null}
Результат:
"name = 'Ivanov' and country = 'Ukraine' and city = 'Kiev'"
*/
public class Solution {
    public static void main(String[] args) {
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("name", "Ivanov");
        map.put("country", "Ukraine");
        map.put("city", "Kiev");
        map.put("age", null);

        System.out.println(getCondition(map));
    }

    public static StringBuilder getCondition(Map<String, String> params) {

        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String, String> i : params.entrySet()) {
            if (i.getValue() != null) {
                if (stringBuilder.length() == 0) {
                    stringBuilder.append(i.getKey() + " = '" + i.getValue() + "'");
                } else {
                    stringBuilder.append(" and " + i.getKey() + " = '" + i.getValue() + "'");
                }
            }

        }
        return stringBuilder;
    }
}
