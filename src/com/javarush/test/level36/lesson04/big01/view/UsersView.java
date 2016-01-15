package com.javarush.test.level36.lesson04.big01.view;

import com.javarush.test.level36.lesson04.big01.bean.User;
import com.javarush.test.level36.lesson04.big01.controller.Controller;
import com.javarush.test.level36.lesson04.big01.model.ModelData;

/**
 * Created by Santer on 15.01.2016.
 */
public class UsersView implements View {
    private Controller controller;


    @Override
    public void refresh(ModelData modelData) {
        System.out.println("All users:");
        for (User user : modelData.getUsers()) {
            System.out.println("\t" + user);
        }
        System.out.println("===================================================");
    }
/*
3. Реализуй логику метода refresh:
3.1. Выведи в консоль фразу "All users:".
3.2. Выведи в консоль всех юзеров, которые есть в modelData.
 Перед каждым юзером сделай отступ в виде табуляции.
3.3. В конце выведи визуальный разделитель данных
 */

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void fireEventShowAllUsers() {
        controller.onShowAllUsers();
    }
}