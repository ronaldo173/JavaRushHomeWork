package com.javarush.test.level36.lesson04.big01.model;

import com.javarush.test.level36.lesson04.big01.bean.User;

import java.util.ArrayList;

/**
 * Created by Alex on 14.01.2016.
 */
public class FakeModel implements Model {
    private ModelData modelData = new ModelData();

    @Override
    public ModelData getModelData() {
        return this.modelData;
    }

    @Override
    public void loadUsers() {
        ArrayList<User> list = new ArrayList<>();
        list.add(new User("First", 1, 1));
        list.add(new User("Second", 2, 2));
        modelData.setUsers(list);
    }

    @Override
    public void loadDeletedUsers() {
        throw new UnsupportedOperationException();
    }
}
/*
3. В пакете model создай класс FakeModel, реализующий Model. Он нам понадобится на начальном этапе.
В нем создай поле ModelData modelData, которое инициализируй объектом.

 */