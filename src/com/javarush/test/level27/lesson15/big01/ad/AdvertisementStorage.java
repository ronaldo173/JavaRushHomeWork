package com.javarush.test.level27.lesson15.big01.ad;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Santer on 17.01.2016.
 */
class AdvertisementStorage {
    private static AdvertisementStorage instance;
    private final List<Advertisement> videos = new ArrayList<>();

    private AdvertisementStorage() {
        Object someContent = new Object();
        add(new Advertisement(someContent, "First Video", 5000, 100, 3 * 60));
        add(new Advertisement(someContent, "Second Video", 100, 10, 15 * 60));
        add(new Advertisement(someContent, "Third Video", 400, 2, 10 * 60));
    }

    public static AdvertisementStorage getInstance() {
        if (instance == null) {
            instance = new AdvertisementStorage();
        }
        return instance;
    }

    public List<Advertisement> list() {
        return videos;
    }

    public void add(Advertisement advertisement) {
        videos.add(advertisement);
    }


}
/*
При выборе, с какого класса начать, старайся найти тот, который используют другие, и который сам ничего не использует.
В нашем случае - это хранилище рекламных роликов (AdvertisementStorage).
Мы решили, что оно будет единственное в ресторане и сделали его синглтоном.
Опишем его.

1. Видео должно где-то храниться, пусть это будет список.
Создадим поле videos и инициализируем его пустым листом. Тип укажите наиболее подходящий.
Подумайте, должно ли поле videos иметь возможность менять свое значение?

2. Чтобы как-то работать с видео, создайте публичные методы:
2.1. list() - который вернет список всех существующих доступных видео
2.2. add(Advertisement advertisement) - который добавит новое видео в список videos

3. Создадим дефолтовый конструктор, в котором проинициализируем лист videos какими-то данными. У меня это:
Object someContent = new Object();
new Advertisement(someContent, "First Video", 5000, 100, 3 * 60) // 3 min
new Advertisement(someContent, "Second Video", 100, 10, 15 * 60) //15 min
new Advertisement(someContent, "Third Video", 400, 2, 10 * 60)   //10 min

4. Сделаем так, чтобы класс AdvertisementStorage не мог использоваться классами из других пакетов

5. В AdvertisementManager создадим final поле-ссылку на экземпляр AdvertisementStorage и назовем ее storage
 */