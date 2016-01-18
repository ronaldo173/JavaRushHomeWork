package com.javarush.test.level36.lesson04.home01;

import java.util.List;

/**
 * Created by Alex on 14.01.2016.
 */
public class Model {
    private Service service;

    public Model(Service service) {
        this.service = service;
    }

    public List<String> getStringDataList() {
        return service.getData();
    }
}
