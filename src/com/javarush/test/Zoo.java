package com.javarush.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Alex on 15.01.2016.
 */
public class Zoo {


    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();//все животные будут в коллекции

        Animal lion = new Animal("Lion", 600, 100);
        Animal mouse = new Animal("Mouse", 1, 0.1);
        Animal elephant = new Animal("Elephant", 5000, 1000);

        Collections.addAll(animals, lion, mouse, elephant);
        Collections.sort(animals, new Comparator<Animal>() { //сортируем по весу
            @Override
            public int compare(Animal o1, Animal o2) {
                return (int) (o1.getWeight() - o2.getWeight());
            }
        });

        System.out.println(animals);//проверяем сортировку

        animals.get(0).setFoodAmount(animals.get(0).getFoodAmount() * 5);//увеличиваем в 5 раз животному с минимальным весом
        animals.get(animals.size() - 1).setFoodAmount(animals.get(animals.size() - 1).getFoodAmount() * 2);

        System.out.println(animals);

    }

    public static class Animal {
        private String name;//Имя животного
        private double weight;//ВЕС животного
        private double foodAmount;//Еда животного

        public Animal(String name, double weight, double foodAmount) {
            this.name = name;
            this.weight = weight;
            this.foodAmount = foodAmount;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getWeight() {
            return weight;
        }

        public void setWeight(double weight) {
            this.weight = weight;
        }

        public double getFoodAmount() {
            return foodAmount;
        }

        public void setFoodAmount(double foodAmount) {
            this.foodAmount = foodAmount;
        }

        @Override
        public String toString() {
            return "Animal{" +
                    "name='" + name + '\'' +
                    ", weight=" + weight +
                    ", foodAmount=" + foodAmount +
                    '}';
        }
    }
}


