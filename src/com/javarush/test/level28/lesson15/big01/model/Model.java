package com.javarush.test.level28.lesson15.big01.model;

import com.javarush.test.level28.lesson15.big01.view.View;
import com.javarush.test.level28.lesson15.big01.vo.Vacancy;

import java.util.List;

/**
 * Created by Alex on 19.01.2016.
 */
public class Model {
    private View view;
    private Provider[] providers;

    public Model(View view, Provider[] providers) {
        if (view == null || providers == null || providers.length == 0) {
            throw new IllegalArgumentException();
        }
        this.view = view;
        this.providers = providers;

    }

    public void selectCity(String city) {
        for (Provider provider : providers) {
            List<Vacancy> javaVacancies = provider.getJavaVacancies(city);
            view.update(javaVacancies);
        }
    }
}
/*

2. Добавь два поля - 1) вид, 2) массив провайдеров

3. Создай конструктор с двумя параметрами - 1) вид, 2) массив провайдеров
На невалидные данные кинь IllegalArgumentException

4. Создай публичный метод void selectCity(String city).

5. Реализуй логику метода selectCity:
5.1. получить вакансии с каждого провайдера
5.2. обновить вью списком вакансий из п.5.1.
 */