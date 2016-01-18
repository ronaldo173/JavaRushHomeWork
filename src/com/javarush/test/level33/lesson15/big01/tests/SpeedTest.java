//package com.javarush.test.level33.lesson15.big01.tests;
//
//import com.javarush.test.level33.lesson15.big01.Helper;
//import com.javarush.test.level33.lesson15.big01.Shortener;
//import com.javarush.test.level33.lesson15.big01.strategies.HashBiMapStorageStrategy;
//import com.javarush.test.level33.lesson15.big01.strategies.HashMapStorageStrategy;
//import org.junit.Assert;
//import org.junit.Test;
//
//import java.util.Date;
//import java.util.HashSet;
//import java.util.Set;
//
///**
// * Created by Santer on 13.01.2016.
// */
//public class SpeedTest {
//
//    public long getTimeForGettingIds(Shortener shortener, Set<String> strings, Set<Long> ids) {
//        ids = new HashSet<>();
//        long timeBefore = new Date().getTime();
//        for (String string : strings) {
//            ids.add(shortener.getId(string));
//        }
//        long timeAfter = new Date().getTime();
//
//        return timeAfter - timeBefore;
//    }
//
//    public long getTimeForGettingStrings(Shortener shortener, Set<Long> ids, Set<String> strings) {
//        strings = new HashSet<>();
//        long timeBefore = new Date().getTime();
//        for (Long id : ids) {
//            strings.add(shortener.getString(id));
//        }
//        long timeAfter = new Date().getTime();
//
//        return timeAfter - timeBefore;
//    }
//
//    @Test
//    public void testHashMapStorage() {
//        Shortener shortener1 = new Shortener(new HashMapStorageStrategy());
//        Shortener shortener2 = new Shortener(new HashBiMapStorageStrategy());//15.4.1.
//
//        Set<String> origStrings = new HashSet<>();
//        Set<Long> origIds = new HashSet<>();
//
//        for (int i = 0; i < 10000; i++) {
//            origStrings.add(Helper.generateRandomString());
//        }
//
//        long timeForGettingIds = getTimeForGettingIds(shortener1, origStrings, origIds);
//        long timeForGettingIds1 = getTimeForGettingIds(shortener2, origStrings, origIds);
//
////        System.out.println(timeForGettingIds + "--" + timeForGettingIds1);
//        Assert.assertTrue(timeForGettingIds > timeForGettingIds1);
//
//        long timeForGettingStrings = getTimeForGettingStrings(shortener1, origIds, origStrings);
//        long timeForGettingStrings1 = getTimeForGettingStrings(shortener2, origIds, origStrings);
//
//        Assert.assertEquals(timeForGettingStrings, timeForGettingStrings1, 5);
//
//    }
//}
///*
//
//15.2.	Добавь в класс метод long getTimeForGettingIds(Shortener shortener, Set<String>
//strings, Set<Long> ids). Он должен возвращать время в миллисекундах необходимое
//для получения идентификаторов для всех строк из strings. Идентификаторы
//должны быть записаны в ids.
//
//15.3.	Добавь в класс метод long getTimeForGettingStrings(Shortener shortener,
//Set<Long> ids, Set<String> strings). Он должен возвращать время в миллисекундах
//необходимое для получения строк для всех идентификаторов из ids. Строки
//должны быть записаны в strings.
//
//15.4.	Добавь в класс SpeedTest тест testHashMapStorage(). Он должен:
//15.4.1.	Создавать два объекта типа Shortener, один на базе
//HashMapStorageStrategy, второй на базе HashBiMapStorageStrategy. Назовем
//их shortener1 и shortener2.
//15.4.2.	Генерировать с помощью Helper 10000 строк и помещать их в сет со
//строками, назовем его origStrings.
//15.4.3.	Получать время получения идентификаторов для origStrings (вызывать
//метод getTimeForGettingIds для shortener1, а затем для shortener2).
//
//15.4.4.	Проверять с помощью junit, что время, полученное в предыдущем пункте
//для shortener1 больше, чем для shortener2.
//15.4.5.	Получать время получения строк (вызывать метод getTimeForGettingStrings
//для shortener1 и shortener2).
//15.4.6.	Проверять с помощью junit, что время, полученное в предыдущем пункте
//для shortener1 примерно равно времени для shortener2. Используй метод
//assertEquals(float expected, float actual, float delta). В качестве delta можно
//использовать 5, этого вполне достаточно для наших экспериментов.
//
// */