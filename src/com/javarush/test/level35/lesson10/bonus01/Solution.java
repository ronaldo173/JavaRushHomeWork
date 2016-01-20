package com.javarush.test.level35.lesson10.bonus01;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.HashSet;
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
        Set<? extends Animal> allAnimals = getAllAnimals("C://pathToClasses/");
        System.out.println(allAnimals);
    }

    public static Set<? extends Animal> getAllAnimals(String pathToAnimals) {
        Set<Animal> result = new HashSet<>();

        if (pathToAnimals == null) {
            return null;
        }
        if (!pathToAnimals.endsWith("/")) {
            pathToAnimals = pathToAnimals + "/";
        }

        File dir = new File(pathToAnimals);
        String[] modules = dir.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.toLowerCase().endsWith(".class");
            }
        });

        if (modules == null || modules.length == 0) {
            return null;
        }
        for (String module : modules) {
            try {
                final String finalPathToAnimal = pathToAnimals;
                ClassLoader loader = new ClassLoader() {
                    @Override
                    protected Class<?> findClass(String name) throws ClassNotFoundException {

                        byte b[] = new byte[0];
                        try {
                            b = fetchClassFromFS(finalPathToAnimal + name + ".class");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        return defineClass(null, b, 0, b.length);

                    }
                };

                String mName = module.substring(0, module.length() - 6);
                Class claz = loader.loadClass(mName);

                boolean hasInterface = false;
                Class[] interfaces = claz.getInterfaces();
                for (Class i : interfaces) {
                    if (Animal.class == i) {
                        hasInterface = true;
                        break;
                    }
                }
                if (!hasInterface) continue;

                ///constructors
                boolean hasConstructor = false;
                Constructor[] constructors = claz.getConstructors();

                for (Constructor constructor : constructors) {
                    if (Modifier.isPublic(constructor.getModifiers()) &&
                            constructor.getParameterTypes().length == 0) {
                        hasConstructor = true;
                        break;
                    }
                }
                if (!hasConstructor) continue;

                result.add((Animal) claz.newInstance());

            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        return result;
    }

    private static byte[] fetchClassFromFS(String path) throws IOException {
        InputStream inputStream = new FileInputStream(new File(path));

        long length = new File(path).length();
        byte[] bytes = new byte[(int) length];

        int offset = 0;
        int numRead = 0;
        while (offset < bytes.length
                && (numRead = inputStream.read(bytes, offset, bytes.length - offset)) >= 0) {
            offset += numRead;
        }

        if (offset < bytes.length) {
            throw new IOException();
        }

        inputStream.close();
        return bytes;

    }
}
