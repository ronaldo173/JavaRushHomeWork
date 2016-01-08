package com.javarush.test.level32.lesson15.big01.listeners;

import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;
import javax.swing.undo.UndoableEdit;

/**
 * Created by santer on 08.01.16.
 */
public class UndoListener implements UndoableEditListener {
    private UndoManager undoManager;

    public UndoListener(UndoManager undoManager) {
        this.undoManager = undoManager;
    }

    @Override
    public void undoableEditHappened(UndoableEditEvent undoableEditEvent) {
        UndoableEdit edit = undoableEditEvent.getEdit();
        undoManager.addEdit(edit);
    }
}
/*
11.3.	Добавь в класс UndoListener:
11.3.1.	Поле UndoManager undoManager.
11.3.2.	Конструктор, который принимает UndoManager и инициализирует поле класса.
11.3.3.	Метод undoableEditHappened(UndoableEditEvent e). Он должен из переданного
события получать правку и добавлять ее в undoManager.
 */