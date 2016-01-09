import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;

/**
 * Created by Alex on 09.01.2016.
 */
public class TestJSONv2 {
    public static void main(String[] args) throws IOException {
        Cat1 cat1 = new Cat1("cat", 22);
        Dog1 dog1 = new Dog1("dog", 11, "Alex");

        ArrayList<Pet> pets = new ArrayList<>();
        pets.add(cat1);
        pets.add(dog1);

        System.out.println("origin: \t" + pets);

        StringWriter writer = new StringWriter();
        ObjectMapper map = new ObjectMapper();
        map.writeValue(writer, pets);

        System.out.println("serialize: \t" + writer.toString());
    }
}

/*
It'll be impossible to deserialize JSON
 */
@JsonAutoDetect
class Pet {
    public String name;

    public Pet(String name) {
        this.name = name;
    }
}

@JsonAutoDetect
class Cat1 extends Pet {
    public int age;

    public Cat1(String name, int age) {
        super(name);
        this.age = age;
    }

    @Override
    public String toString() {
        return "Cat1{" +
                "age=" + age +
                '}';
    }
}

@JsonAutoDetect
class Dog1 extends Pet {
    public int age;
    public String owner;

    public Dog1(String name, int age, String owner) {
        super(name);
        this.age = age;
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Dog1{" +
                "age=" + age +
                ", owner='" + owner + '\'' +
                '}';
    }
}
