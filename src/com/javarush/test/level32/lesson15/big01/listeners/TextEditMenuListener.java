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