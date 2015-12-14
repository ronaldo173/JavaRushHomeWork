package com.javarush.test.level26.lesson02.task01;

import java.util.Arrays;
import java.util.Comparator;

/* Почитать в инете про медиану выборки
Реализовать логику метода sort, который должен сортировать данные в массиве по удаленности от его медианы
Вернуть отсортированный массив от минимального расстояния до максимального
Если удаленность одинаковая у нескольких чисел, то выводить их в порядке возрастания
*/
public class Solution {
    public static Integer[] sort(Integer[] array) {
        //implement logic here
//        System.out.println(array.length);
        Arrays.sort(array);
        final int median = getMedian(array);
        System.out.println(median);
        //check mediane

        Comparator<Integer> comparatorMedian = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                double value = Math.abs(o1 - median) - Math.abs(o2 - median);
                if (value == 0) {
                    value = o1 - o2;
                }
                return (int) value;
            }
        };

        Arrays.sort(array, comparatorMedian);
        return array;
    }

    public static int getMedian(Integer[] array) {
        int median = 0;

        if (array.length % 2 != 0) {
            median = array[array.length / 2];
        } else {
//            System.out.println("%2==0: near mediane: " + array[array.length / 2 - 1] + " " + (array[array.length / 2 + 1]));
            median = (array[array.length / 2 - 1] + array[array.length / 2 + 1]) / 2;
        }
        return median;
    }

    public static void main(String[] args) {

        Integer[] array = {3, 4, 7, 6, 5, 2, 1, 11, 5, 48, 49, 56, 92};
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println("\n");

        array = sort(array);
        for (Integer integer : array) {
            System.out.print(integer + " ");
        }
        System.out.println();

    }
}
