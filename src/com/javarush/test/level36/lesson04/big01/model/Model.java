package com.javarush.test.level36.lesson04.big01.model;

/**
 * Created by Alex on 14.01.2016.
 */
public interface Model {
    ModelData getModelData();

    void loadUsers();
}
/*
2. Используя любую модель должна быть возможность получить все необходимые данные для отображения. Поэтому
в пакете model создай интерфейс Model, который должен содержать метод ModelData getModelData().
 */