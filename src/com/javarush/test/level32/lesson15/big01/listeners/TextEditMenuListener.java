package com.javarush.test.level32.lesson15.big01.listeners;

import com.javarush.test.level32.lesson15.big01.View;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;

/**
 * Created by Santer on 08.01.2016.
 */
public class TextEditMenuListener implements MenuListener {
    private View view;

    public TextEditMenuListener(View view) {
        this.view = view;
    }

    @Override
    public void menuDeselected(MenuEvent e) {

    }

    @Override
    public void menuCanceled(MenuEvent e) {

    }

    @Override
    public void menuSelected(MenuEvent menuEvent) {
        JMenu source = (JMenu) menuEvent.getSource();
        Component[] menuComponents = source.getMenuComponents();
        for (Component menuComponent : menuComponents) {
            menuComponent.setEnabled(view.isHtmlTabSelected());
        }
    }
}
/*
Реализуй класс TextEditMenuListener в пакет listeners. Этот класс будет работать аналогично
классу UndoMenuListener только для других пунктов меню. Пункты меню, отвечающие за
стиль, шрифт, цвет и т.д. должны быть доступны только тогда, когда в нашем редакторе
выбрана первая вкладка.
13.1.	Добавь в представление метод boolean isHtmlTabSelected(). Он должен возвращать
true, если выбрана вкладка, отображающая html в панели вкладок (подсказка: ее индекс 0).
13.2.	Добавь в класс TextEditMenuListener поле View, проинициализируй его в конструкторе
класса.
13.3.	В классе TextEditMenuListener переопредели метод menuSelected(MenuEvent
menuEvent). Он должен:
13.3.1.	Из переданного параметра получать объект, над которым было совершено действие. В
нашем случае это будет объект с типом JMenu.
13.3.2.	У полученного меню получать список компонентов (пунктов меню).
13.3.3.	Для каждого пункта меню вызывать метод setEnabled, передав в качестве параметра
результат вызова метода isHtmlTabSelected() из представления.
Запусти приложение и убедись, что пункты меню стиль, выравнивание, цвет и шрифт доступны
только, когда активна закладка HTML и не доступны для закладки Текст.
 */