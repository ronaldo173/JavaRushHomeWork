package com.javarush.test.level30.lesson15.big01.client;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Santer on 17.01.2016.
 */
public class ClientGuiModel {
    private final Set<String> allUserNames = new HashSet<>();
    private String newMessage;

    public Set<String> getAllUserNames() {
        return Collections.unmodifiableSet(allUserNames);
    }

    public String getNewMessage() {
        return newMessage;
    }

    public void setNewMessage(String newMessage) {
        this.newMessage = newMessage;
    }

    public void addUser(String newUserName) {
        allUserNames.add(newUserName);
    }

    public void deleteUser(String userName) {
        allUserNames.remove(userName);
    }
}
/*
20.1.	Создай класс ClientGuiModel в пакете client. Все классы клиента должны в этом
пакете.
20.2.	Добавь в него множество(set) строк в качестве final поля allUserNames.
В нем будет храниться список всех участников чата. Проинициализируй его.
20.3.	Добавь поле String newMessage, в котором будет храниться новое сообщение,
которое получил клиент.
20.4.	Добавь геттер для allUserNames, запретив модифицировать возвращенное
множество. Разберись, как это можно сделать с помощью метода класса Collections.
20.5.	Добавь сеттер и геттер для поля newMessage.
20.6.	Добавь метод void addUser(String newUserName), который должен добавлять
имя участника во множество, хранящее всех участников.
20.7.	Добавь метод void deleteUser(String userName), который будет удалять имя
участника из множества.

 */