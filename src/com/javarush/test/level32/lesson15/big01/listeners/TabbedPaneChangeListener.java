package com.javarush.test.level32.lesson15.big01.listeners;

import com.javarush.test.level32.lesson15.big01.View;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Created by Santer on 08.01.2016.
 */
public class TabbedPaneChangeListener implements ChangeListener {
    private View view;

    public TabbedPaneChangeListener(View view) {
        this.view = view;
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        view.selectedTabChanged();
    }
}
/*
5.1.	Объяви класс TabbedPaneChangeListener реализующий интерфейс ChangeListener в пакете
listeners. Этот класс будет слушать и обрабатывать изменения состояния панели вкладок.
Реализуй в этом классе:
5.1.1.	Конструктор, принимающий представление в виде параметра и сохраняющий во
внутреннее поле класса.
5.1.2.	Переопредели метод из интерфейса ChangeListener, он должен вызывать метод
selectedTabChanged() у представления. Последнего метода еще нет, сделай для него
заглушку.
 */