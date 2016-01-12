package com.javarush.test.level33.lesson15.big01;


import com.javarush.test.level33.lesson15.big01.strategies.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Santer on 10.01.2016.
 */
public class Solution {
    public static Set<Long> getIds(Shortener shortener, Set<String> strings) {
        Set<Long> set = new HashSet<>();
        for (String string : strings) {
            set.add(shortener.getId(string));
        }
        return set;
    }

    public static Set<String> getStrings(Shortener shortener, Set<Long> keys) {
        Set<String> set = new HashSet<>();
        for (Long key : keys) {
            set.add(shortener.getString(key));
        }
        return set;
    }

    public static void testStrategy(StorageStrategy strategy, long elementsNumber) {
        System.out.println(strategy.getClass().getSimpleName());
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < elementsNumber; i++) {
            set.add(Helper.generateRandomString());
        }
        Shortener shortener = new Shortener(strategy);

        Long t1 = new Date().getTime();
        Set<Long> setId = getIds(shortener, set);
        Long t2 = new Date().getTime();
        Helper.printMessage(String.valueOf(t2 - t1));

        Long t3 = new Date().getTime();
        Set<String> setGetStrings = getStrings(shortener, setId);
        Long t4 = new Date().getTime();
        Helper.printMessage(String.valueOf(t4 - t3));

        boolean isEqualsCOllections = true;
        for (String setGetString : setGetStrings) {
            if (!set.contains(setGetString)) {
                isEqualsCOllections = false;
            }
        }
        if (isEqualsCOllections) {
            Helper.printMessage("Тест пройден.");
        } else {
            Helper.printMessage("Тест не пройден.");
        }
    }

    public static void main(String[] args) {
        testStrategy(new HashMapStorageStrategy(), 10000);

        testStrategy(new OurHashMapStorageStrategy(), 10000);

        testStrategy(new FileStorageStrategy(), 100);

        testStrategy(new OurHashBiMapStorageStrategy(), 10000);

        testStrategy(new HashBiMapStorageStrategy(), 10000);

        testStrategy(new DualHashBidiMapStorageStrategy(), 10000);
    }
}