//package com.javarush.test.level33.lesson15.big01.tests;
//
//import com.javarush.test.level33.lesson15.big01.Shortener;
//import com.javarush.test.level33.lesson15.big01.strategies.*;
//import org.junit.Assert;
//import org.junit.Test;
//
///**
// * Created by Santer on 13.01.2016.
// */
//public class FunctionalTest {
//    public void testStorage(Shortener shortener) {
//        String string1 = "firstString";
//        String string2 = "second";
//        String string3 = "firstString";
//
//        Long id1 = shortener.getId(string1);
//        Long id2 = shortener.getId(string2);
//        Long id3 = shortener.getId(string3);
//
//        Assert.assertNotEquals(id2, id1);//14.4.3.
//        Assert.assertNotEquals(id2, id3);
//        Assert.assertEquals(id1, id3);//14.4.4.
//
//        String stringGetById1 = shortener.getString(id1);//14.4.5.
//        String stringGetById2 = shortener.getString(id2);
//        String stringGetById3 = shortener.getString(id3);
//
//        Assert.assertEquals(string1, stringGetById1);//14.4.6.
//        Assert.assertEquals(string2, stringGetById2);
//        Assert.assertEquals(string3, stringGetById3);
//    }
//
//    @Test
//    public void testHashMapStorageStrategy() {
//        Shortener shortener = new Shortener(new HashMapStorageStrategy());
//        testStorage(shortener);
//    }
//
//    @Test
//    public void testOurHashMapStorageStrategy() {
//        testStorage(new Shortener(new OurHashMapStorageStrategy()));
//    }
//
//    @Test
//    public void testFileStorageStrategy() {
//        testStorage(new Shortener(new FileStorageStrategy()));
//    }
//
//    @Test
//    public void testHashBiMapStorageStrategy() {
//        testStorage(new Shortener(new HashBiMapStorageStrategy()));
//    }
//
//    @Test
//    public void testDualHashBidiMapStorageStrategy() {
//        testStorage(new Shortener(new DualHashBidiMapStorageStrategy()));
//    }
//
//    @Test
//    public void testOurHashBiMapStorageStrategy() {
//        testStorage(new Shortener(new OurHashBiMapStorageStrategy()));
//    }
//}
///*
//14.4.	Добавь в класс FunctionalTest метод testStorage(Shortener shortener). Он
//должен:
//14.4.1.	Создавать три строки. Текст 1 и 3 строк должен быть одинаковым.
//14.4.2.	Получать и сохранять идентификаторы для всех трех строк с помощью
//shortener.
//14.4.3.	Проверять, что идентификатор для 2 строки не равен идентификатору для 1
//и 3 строк. Подсказка: метод Assert.assertNotEquals.
//14.4.4.	Проверять, что идентификаторы для 1 и 3 строк равны. Подсказка: метод
//Assert.assertEquals.
//14.4.5.	Получать три строки по трем идентификаторам с помощью shortener.
//14.4.6.	Проверять, что строки, полученные в предыдущем пункте, эквивалентны
//оригинальным. Подсказка: метод Assert.assertEquals.
//14.5.	Добавь в класс FunctionalTest тесты:
//14.5.1.	testHashMapStorageStrategy()
//14.5.2.	testOurHashMapStorageStrategy()
//14.5.3.	testFileStorageStrategy()
//14.5.4.	testHashBiMapStorageStrategy()
//14.5.5.	testDualHashBidiMapStorageStrategy()
//14.5.6.	testOurHashBiMapStorageStrategy()
//Каждый тест должен иметь аннотацию @Test, создавать подходящую стратегию,
//создавать объект класса Shortener на базе этой стратегии и вызывать метод
//testStorage для него.
//Запусти и проверь, что все тесты проходят.
// */