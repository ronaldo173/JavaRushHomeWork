import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.StringReader;
import java.util.List;

/**
 * Created by Santer on 09.01.2016.
 */
public class TestJAXBv3 {
    public static void main(String[] args) throws JAXBException {
        String xmlData = "<zoo><cat/><cat/><dog/><cat/></zoo>";
        StringReader reader = new StringReader(xmlData);
        JAXBContext context = JAXBContext.newInstance(Cat3.class, Zoo.class, Dog.class);

        Unmarshaller unmarshaller = context.createUnmarshaller();

        Cat3 cat3 = (Cat3) unmarshaller.unmarshal(reader);

        System.out.println(cat3);
    }
}

@XmlType(name = "zoo")
@XmlRootElement
class Zoo extends Cat3 {
    @XmlAnyElement
    public List<Object> animals;

    Zoo() {
    }
}

@XmlType(name = "cat")
@XmlRootElement
class Cat3 {
    public String name;
    public int age;

    Cat3() {

    }

    @Override
    public String toString() {
        return "Cat3{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

@XmlType(name = "dog")
@XmlRootElement
class Dog {
    public String name;
    public int age;
    public int weight;

    Dog() {
    }
}