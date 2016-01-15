package com.javarush.test.level36.lesson04.big01.model;

import com.javarush.test.level36.lesson04.big01.bean.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 14.01.2016.
 */
public class ModelData {
    private List<User> users = new ArrayList<>();

    public List<User> getUsers() {
        return users;
    }


    public void setUsers(List<User> users) {
        this.users = users;
    }
}
/*
1. Создай пакет model, в котором создай класс ModelData.
ModelData - это объект, который будет хранить необходимые данные для отображения на клиенте.
Создай поле с геттером и сеттером List<User> users - это будет список юзеров для отображения.
 */