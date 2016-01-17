package com.javarush.test.level27.lesson15.big01.ad;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;

/**
 * Created by Santer on 17.01.2016.
 */
public class AdvertisementManager {
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private int timeSeconds;

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos() {
        ConsoleHelper.writeMessage("processVideos method calling");
    }
}
/*

3. Определим необходимые данные для объекта AdvertisementManager - это время выполнения заказа поваром.
Т.к. продолжительность видео у нас хранится в секундах, то и и время выполнения заказа тоже будем принимать в секундах.
В классе AdvertisementManager создайте конструктор, который принимает один параметр - int timeSeconds.
Создайте соответствуйщий филд и сохраните это значение в него.

4. AdvertisementManager выполняет только одно единственное действие - обрабатывает рекламное видео.
Поэтому создайте единственный публичный метод void processVideos(), его функционал опишем в следующем задании.
А пока выведем в консоль "processVideos method calling"

5. Чтобы тестировать данную функциональность, нужно добавить вызов processVideos метода у AdvertisementManager.
Очевидно, что этот метод должен вызываться во время создания заказа, а точнее - в параллельном режиме.
Заказ готовится в то время, как видео смотрится.
Добавьте вызов метода processVideos() в нужное место.
 */