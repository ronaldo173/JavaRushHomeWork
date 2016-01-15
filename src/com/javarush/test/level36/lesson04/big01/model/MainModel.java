package com.javarush.test.level36.lesson04.big01.model;

import com.javarush.test.level36.lesson04.big01.bean.User;
import com.javarush.test.level36.lesson04.big01.model.service.UserService;
import com.javarush.test.level36.lesson04.big01.model.service.UserServiceImpl;

import java.util.List;

/**
 * Created by Santer on 15.01.2016.
 */
public class MainModel implements Model {
    private UserService userService = new UserServiceImpl();
    private ModelData modelData = new ModelData();

    @Override
    public ModelData getModelData() {
        return modelData;
    }

    @Override
    public void loadUsers() {
        List<User> usersBetweenLevels = userService.getUsersBetweenLevels(1, 100);
        modelData.setUsers(usersBetweenLevels);
    }
}
/*

3. Реализуй логику метода loadUsers:
3.1. Достань всех пользователей между 1 и 100 уровнями
3.2. Положи всех пользователей в modelData

 */