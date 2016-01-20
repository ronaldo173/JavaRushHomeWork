package com.javarush.test.level28.lesson15.big01;

import com.javarush.test.level28.lesson15.big01.model.Model;
import com.javarush.test.level28.lesson15.big01.model.MoikrugStrategy;
import com.javarush.test.level28.lesson15.big01.model.Provider;
import com.javarush.test.level28.lesson15.big01.view.HtmlView;
import com.javarush.test.level28.lesson15.big01.view.View;

/**
 * Created by Alex on 19.01.2016.
 */
public class Aggregator {
    public static void main(String[] args) {
        View view = new HtmlView();
        Model model = new Model(view, new Provider[]{new Provider(new MoikrugStrategy())});
        Controller controller = new Controller(model);

        view.setController(controller);
        view.userCitySelectEmulationMethod();
    }
}
/*
2. В методе main создай провайдер для MoikrugStrategy. Передай этот провайдер в конструктор Model.
Это удобно сделать, т.к. модель принимает много провайдеров.
Остальную логику менять не нужно. Видишь, как легко расширять функционал?
От правильной архитектуры зависит многое.
 */