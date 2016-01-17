package com.javarush.test.level27.lesson15.big01.ad;

/**
 * Created by Santer on 17.01.2016.
 */
public class AdvertisementManager {
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();
}
/*
5. В AdvertisementManager создадим final поле-ссылку на экземпляр AdvertisementStorage и назовем ее storage
 */