package com.javarush.test.level15.lesson04.task02;

/* ООП - Перегрузка
Перегрузите метод printMatrix 8 различными способами. В итоге должно получиться 10 различных методов printMatrix.
*/

public class Solution {
    public static void main(String[] args) {
        printMatrix(2, 3, "8");
    }

    public static void printMatrix(int m, int n, String value) {
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix(int m, int n, Object value) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(value);
            }
            System.out.println();
        }
    }

    public static void printMatrix(String a, String a1) {
    }

    ;

    public static void printMatrix(String a, String a2, String a3) {
    }

    ;

    public static void printMatrix(String a, int a1) {
    }

    ;

    public static void printMatrix(String a, char a1) {
    }

    ;

    public static void printMatrix(int a, String a1) {
    }

    ;

    public static void printMatrix(boolean a, String a2, String a3) {
    }

    ;

    public static void printMatrix(double a, int a1) {
    }

    ;

    public static void printMatrix(float a, char a1) {
    }

    ;


}
