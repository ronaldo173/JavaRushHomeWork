package com.javarush.test.level28.lesson15.big01;

import com.javarush.test.level28.lesson15.big01.model.Model;

/**
 * Created by Alex on 19.01.2016.
 */
public class Controller {
    private Model model;

    public Controller(Model model) {
        if (model == null) {
            throw new IllegalArgumentException();
        }
        this.model = model;
    }

    public void onCitySelect(String cityName) {
        model.selectCity(cityName);
    }
}
/*
1. Добавь в Controller новое поле Model model.
2. Удали метод scan() из Controller, его логика переместилась в модель.
3. Удали конструктор, toString и поле providers из контроллера.
4. Создай конструктор в Controller с аргументом Model.
На некорректные данные брось IllegalArgumentException

5. В Controller создай публичный метод void onCitySelect(String cityName), в котором вызови нужный метод модели.

6. Удали код из метода main. Этот код уже не валидный.
 */