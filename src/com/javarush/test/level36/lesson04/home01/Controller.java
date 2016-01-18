package com.javarush.test.level36.lesson04.home01;

import java.util.List;

/**
 * Created by Alex on 14.01.2016.
 */
public class Controller {
    private Model model;

    public Controller(Model model) {
        this.model = model;
    }

    public List<String> onDataListShow() {
        return model.getStringDataList();
    }
}
