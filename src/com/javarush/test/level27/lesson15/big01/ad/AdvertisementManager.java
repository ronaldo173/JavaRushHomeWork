package com.javarush.test.level27.lesson15.big01.ad;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;

import java.util.Collections;
import java.util.Comparator;

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
        Collections.sort(storage.list(), new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                int result = Long.compare(o1.getAmountPerOneDisplaying(), o2.getAmountPerOneDisplaying());
                if (result != 0)
                    return -result;
                long oneSecondCost1 = o1.getAmountPerOneDisplaying() * 1000 / o1.getDuration();
                long oneSecondCost2 = o2.getAmountPerOneDisplaying() * 1000 / o2.getDuration();
                return Long.compare(oneSecondCost1, oneSecondCost2);
            }
        });

        int timeLeft = timeSeconds;
        for (Advertisement advertisement : storage.list()) {
            if (timeLeft < advertisement.getDuration()) {
                continue;
            }

            ConsoleHelper.writeMessage(advertisement.getName() + " is displaying... "
                    + advertisement.getAmountPerOneDisplaying() + ", "
                    + advertisement.getAmountPerOneDisplaying() * 1000 / advertisement.getDuration());

            timeLeft -= advertisement.getDuration();
            advertisement.revalidate();
        }

        if (timeLeft == timeSeconds) {
            throw new NoVideoAvailableException();
        }
    }
}
/*
Напомню, рекурсия пишется по следующему принципу:
а) условие выхода/окончания рекурсии
б) условие продолжения - вызов самой себя с набором параметров предыдущего шага.
В любое время ты можешь почитать в инете подробную информацию по написанию рекурсии.

Текущее задание - реализовать п.2.2. предыдущего задания с помошью рекурсии.
(подобрать список видео из доступных, просмотр которых обеспечивает максимальную выгоду)
Рекурсивный метод должен выбрать набор рекламных роликов, которые будут показаны посетителю.

Этот набор должен удовлетворять следующим требованиям:
1) сумма денег, полученная от показов, максимальная из всех возможных вариантов
2) общее время показа рекламных роликов НЕ должно превышать время приготовления блюд для текущего заказа
3) для одного заказа любой видео-ролик показывается не более одного раза
4) если существуют несколько вариантов набора видео-роликов с одинаковой суммой денег, полученной от показов, то:
4.1) выбрать тот вариант, у которого суммарное время максимальное
4.2) если суммарное время у этих вариантов одинаковое, то выбрать вариант с минимальным количеством роликов
5) количество показов у любого рекламного ролика из набора - положительное число

При локальном тестировании учитывайте, что необходимо отобразить все рекламные ролики, отобранные для показа,
в порядке уменьшения стоимости показа одного рекламного ролика в копейках.
 */