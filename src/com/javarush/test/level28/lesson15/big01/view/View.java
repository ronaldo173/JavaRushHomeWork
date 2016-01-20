package com.javarush.test.level28.lesson15.big01.view;

import com.javarush.test.level28.lesson15.big01.Controller;
import com.javarush.test.level28.lesson15.big01.vo.Vacancy;

import java.util.List;

/**
 * Created by Alex on 19.01.2016.
 */
public interface View {
    void update(List<Vacancy> vacancies);

    void setController(Controller controller);

    void userCitySelectEmulationMethod();
}
/*
1. Создай пакет view, в котором создай интерфейс View с двумя методами:
void update(List<Vacancy> vacancies);
void setController(Controller controller);
 */