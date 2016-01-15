package com.javarush.test.level36.lesson04.big01.model;

/**
 * Created by Alex on 14.01.2016.
 */
public interface Model {
    ModelData getModelData();

    void loadUsers();

    void loadDeletedUsers();
}
/*

3. Добавь в интерфейс Model метод, который ты поместил в Модель, реализуй его в FakeModel:
выброси UnsupportedOperationException

 */