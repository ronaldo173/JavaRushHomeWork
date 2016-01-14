package com.javarush.test.level35.lesson10.bonus01;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* ClassLoader - что это такое?
Реализуйте логику метода getAllAnimals.
Аргумент метода pathToAnimals - это абсолютный путь к директории, в которой хранятся скомпилированные классы.
Путь не обязательно содержит / в конце.
НЕ все классы наследуются от интерфейса Animal.
НЕ все классы имеют публичный конструктор без параметров.
Только для классов, которые наследуются от Animal и имеют публичный конструктор без параметров, - создать по одному объекту.
Добавить созданные объекты в результирующий сет и вернуть.
Метод main не участвует в тестировании.
*/
public class Solution {
    public static void main(String[] args) {
//        Set<? extends Animal> allAnimals = getAllAnimals("C://pathToClasses/");
        Set<? extends Animal> allAnimals = getAllAnimals("C:\\Users\\Santer\\Desktop\\Development\\JavaRush\\JavaRushHomeWork\\out\\production\\JavaRushHomeWork\\com\\javarush\\test\\level35\\lesson10\\bonus01");
        System.out.println(allAnimals);
    }

    public static Set<? extends Animal> getAllAnimals(String pathToAnimals) {
        if (!pathToAnimals.endsWith("/")) {
            pathToAnimals += "/";
        }

        List<File> fileList = new ArrayList<>();
        for (File file : Paths.get(pathToAnimals).toFile().listFiles()) {
            if (!file.isDirectory()) {
                fileList.add(file);
            }
        }


        try {

            URL url = Paths.get(pathToAnimals).toFile().toURL();
            URL[] urls = new URL[]{url};

            File newClassesDir = Paths.get(pathToAnimals + ".com.MyClasses").toFile();
            if (!newClassesDir.exists()) {
                newClassesDir.mkdirs();
            }
            ClassLoader classLoader = new URLClassLoader(urls);
            Class cl = classLoader.loadClass(".com.MyClasses");
        } catch (Exception e1) {
            e1.printStackTrace();
        }


        Set<? extends Animal> set = new HashSet<>();
        return set;
    }
}
