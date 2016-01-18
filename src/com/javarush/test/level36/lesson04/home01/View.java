package com.javarush.test.level36.lesson04.home01;

/**
 * Created by Alex on 14.01.2016.
 */
public class View {
    private Controller controller;

    public View(Controller controller) {
        this.controller = controller;
    }

    public void fireEventShowData() {
        System.out.println(controller.onDataListShow());
    }
}
