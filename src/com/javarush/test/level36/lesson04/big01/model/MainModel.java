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
        modelData.setDisplayDeletedUserList(false);
    }

    //**
    public void loadDeletedUsers() {
        List<User> users = userService.getAllDeletedUsers();
        modelData.setUsers(users);
        modelData.setDisplayDeletedUserList(true);

    }

    //*
    public void loadUserById(long userId) {
        User user = userService.getUsersById(userId);
//        System.out.println(user);
        modelData.setActiveUser(user);
//        modelData.setDisplayDeletedUserList(false);
    }
}
