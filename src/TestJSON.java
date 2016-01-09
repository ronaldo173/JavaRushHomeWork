import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * Created by Alex on 09.01.2016.
 */
public class TestJSON {
    public static void main(String[] args) throws IOException {
        Cat cat = new Cat("cat1", 22, 83);
        System.out.println("origin: \t" + cat);

        StringWriter stringWriter = new StringWriter();
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(stringWriter, cat);
        stringWriter.close();

        String result = stringWriter.toString();
        System.out.println("serializ: \t" + result);

        StringReader stringReader = new StringReader(result);
        ObjectMapper mapperDeserial = new ObjectMapper();
        Cat cat1 = mapperDeserial.readValue(stringReader, Cat.class);

        System.out.println("deserialize: \t" + cat1);
    }
}

@JsonAutoDetect
class Cat {
    public String Name;
    public int age;
    public int weight;

    public Cat() {
    }

    public Cat(String name, int age, int weight) {
        Name = name;
        this.age = age;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "Name='" + Name + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                '}';
    }
}
