package com.javarush.test.level28.lesson02.task01;

/* Осваиваем switch
Реализуйте логику метода switchTest:
1. Не используйте условные операторы
2. Используйте 1 switch, у которого 2 case и 1 default
3. Ожидаемый вывод:
Вывод для E1.A - "it's E1.A"
Вывод для E1.B - "it's E1.B"
Вывод для E1.C - "it's E1.C"
Вывод для E1.Y - "it's E1.Y"
Вывод для E2.D - "it's E2.D"
Вывод для E2.E - "it's E2.E"
Вывод для E2.F - "it's E2.F"
Вывод для всех других значений - "undefined"
*/
public class Solution {
    public static void main(String[] args) {
        Solution.switchTest(E1.C);
        Solution.switchTest(E3.D);
        Solution.switchTest(E2.D);
        /* output
        it's E1.C
        undefined
        it's E2.D
         */

        System.out.println("---");
        Solution.switchTest(E1.Y);
        Solution.switchTest(E2.F);

//        //**test enum
//        TestEnum testEnum = new TestEnum();
//        testEnum.testEnum("sunday");
    }

    public static void switchTest(Enum obj) {
        //add your code here
//        System.out.println(obj.getDeclaringClass() + " " + obj.name() + " " + obj.toString());
//        String enumClassName = obj.getDeclaringClass().getSimpleName();
//        System.out.println(enumClassName);
        switch (obj.getDeclaringClass().getSimpleName()) {
            case "E1":
                System.out.println("it's E1." + obj);
                break;
            case "E2":
                System.out.println("it's E2." + obj);
                break;
            default:
                System.out.println("undefined");
        }

    }

    public static enum E1 {A, B, C, Y}

    public static enum E2 {D, E, F}

    public static enum E3 {D, E, F}
}

//class TestEnum {
//    Day day;
//
//    public void testEnum(String dayIs) {
//        day = Day.valueOf(dayIs.toUpperCase());
//        switch (day) {
//            case SUNDAY:
//                System.out.println("sunday");
//                break;
//            case THURSDAY:
//                System.out.println(Day.THURSDAY.toString());
//                break;
//            default:
//                System.out.println("xz");
//        }
//    }
//
//}
//
//enum Day {
//    SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
//}