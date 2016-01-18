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
        modelData.setUsers(filter(usersBetweenLevels));
        modelData.setDisplayDeletedUserList(false);
    }

    private List<User> filter(List<User> users) {
        return userService.filterOnlyActiveUsers(users);
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
        modelData.setActiveUser(user);
    }

    public void deleteUserById(long id) {
        userService.deleteUser(id);
        modelData.setUsers(filter(userService.getUsersBetweenLevels(1, 100)));
        modelData.setDisplayDeletedUserList(false);
    }

    public void changeUserData(String name, long id, int level) {
        userService.createOrUpdateUser(name, id, level);
        modelData.setUsers(filter(userService.getUsersBetweenLevels(1, 100)));
        modelData.setDisplayDeletedUserList(false);
    }
}
/*
3. Отрефактори MainModel. Теперь, когда есть удаленные юзеры, часть методов стала работать неправильно.
Почти во всех методах, где требуется список пользователей, нужно работать только с активными(живыми) юзерами.
Вынеси в отдельный приватный метод получение списка всех юзеров и фильтрацию живых юзеров.
Отрефактори все методы, которые используют список юзеров. Они должны использовать список живых юзеров.
 */