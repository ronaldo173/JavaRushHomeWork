package com.javarush.test;

import java.util.ArrayList;
import java.util.List;

/**
 * Для того, чтобы система оставалась независимой от различных типов объектов,
 * паттерн «Фабричный метод» использует механизм полиморфизма - классы всех конечных типов
 * наследуются от одного абстрактного базового класса, предназначенного для полиморфного использования.
 * В этом базовом классе определяется единый интерфейс,
 * через который пользователь будет оперировать объектами конечных типов.
 */
public class TestFabricMethod {
    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(Vehicle.createVehiceFabricMethod(Vehicle.TYPE_PLANE));
        vehicles.add(Vehicle.createVehiceFabricMethod(Vehicle.TYPE_BOAT));
        vehicles.add(Vehicle.createVehiceFabricMethod(Vehicle.TYPE_CAR));
        vehicles.add(Vehicle.createVehiceFabricMethod(null));

        for (Vehicle vehicle : vehicles) {
            vehicle.info();
        }
    }
}


class Boat extends Vehicle {
    public void info() {
        System.out.println("boat");
    }
}

class Car extends Vehicle {
    public void info() {
        System.out.println("car");
    }
}

class Plane extends Vehicle {
    public void info() {
        System.out.println("plane");
    }
}

class Vehicle {
    public static final String TYPE_BOAT = "BOAT";
    public static final String TYPE_PLANE = "PLANE";
    public static final String TYPE_CAR = "CAR";

    public static Vehicle createVehiceFabricMethod(String typeOfVehicle) {
        if (typeOfVehicle == null) {
            return new Vehicle();
        }
        Vehicle vehicle = null;
        switch (typeOfVehicle) {
            case Vehicle.TYPE_BOAT:
                vehicle = new Boat();
                break;
            case Vehicle.TYPE_CAR:
                vehicle = new Car();
                break;
            case Vehicle.TYPE_PLANE:
                vehicle = new Plane();
        }

        return vehicle;
    }

    public void info() {
        System.out.println("This is base class");
    }
}