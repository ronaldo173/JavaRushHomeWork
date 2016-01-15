package com.javarush.test.level36.lesson04.big01.view;

import com.javarush.test.level36.lesson04.big01.controller.Controller;
import com.javarush.test.level36.lesson04.big01.model.ModelData;

/**
 * Created by Santer on 15.01.2016.
 */
public interface View {
    void refresh(ModelData modelData);

    void setController(Controller controller);


}
/*
5. В интерфейс View добавь два метода void refresh(ModelData modelData) и void setController(Controller controller)
 */