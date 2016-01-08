package com.javarush.test.level32.lesson15.big01;

import com.javarush.test.level32.lesson15.big01.listeners.FrameListener;
import com.javarush.test.level32.lesson15.big01.listeners.TabbedPaneChangeListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Santer on 07.01.2016.
 */
public class View extends JFrame implements ActionListener {
    private Controller controller;
    private JTabbedPane tabbedPane = new JTabbedPane();
    private JTextPane htmlTextPane = new JTextPane();
    private JEditorPane plainTextPane = new JEditorPane();


    public View() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            ExceptionHandler.log(e);
        }
    }

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public void exit() {
        controller.exit();
    }

    public void initGui() {
        initMenuBar();
        initEditor();
        pack();
    }

    public void init() {
        initGui();
        FrameListener frameListener = new FrameListener(this);
        addWindowListener(frameListener);
        setVisible(true);
    }

    public void selectedTabChanged() {

    }

    public void initEditor() {
        htmlTextPane.setContentType("text/html");
        JScrollPane jScrollPane = new JScrollPane(htmlTextPane);
        tabbedPane.addTab("HTML", jScrollPane);

        JScrollPane jScrollPane2 = new JScrollPane(plainTextPane);
        tabbedPane.addTab("Текст", jScrollPane2);

        tabbedPane.setPreferredSize(new Dimension(500, 500));
        tabbedPane.addChangeListener(new TabbedPaneChangeListener(this));

        this.getContentPane().add(tabbedPane, BorderLayout.CENTER);
    }

    public void initMenuBar() {
        JMenuBar jMenuBar = new JMenuBar();
        MenuHelper.initFileMenu(this, jMenuBar);
        MenuHelper.initEditMenu(this, jMenuBar);
        MenuHelper.initStyleMenu(this, jMenuBar);
        MenuHelper.initAlignMenu(this, jMenuBar);
        MenuHelper.initColorMenu(this, jMenuBar);
        MenuHelper.initFontMenu(this, jMenuBar);
        MenuHelper.initHelpMenu(this, jMenuBar);
        getContentPane().add(jMenuBar, BorderLayout.NORTH);
    }

    public boolean canUndo() {
        return false;
    }

    public boolean canRedo() {
        return false;
    }
}
/*
9.1.	Реализуй метод initMenuBar(). Он должен:
9.1.1.	Создавать новый объект типа JMenuBar. Это и будет наша панель меню.
9.1.2.	С помощью MenuHelper инициализировать меню в следующем порядке: Файл,
Редактировать, Стиль, Выравнивание, Цвет, Шрифт и Помощь.
9.1.3.	Добавлять в верхнюю часть панели контента текущего фрейма нашу панель меню,
аналогично тому, как это мы делали с панелью вкладок.
9.2.	Добавь конструктор класса View. Он должен устанавливать внешний вид и поведение
(look and feel) нашего приложения такими же, как это определено в системе.
Конструктор не должен кидать исключений, только логировать их с помощью
ExceptionHandler. Подсказа: для реализации задания используй класс UIManager.

 */