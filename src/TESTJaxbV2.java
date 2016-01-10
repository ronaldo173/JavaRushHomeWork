import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.*;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Santer on 09.01.2016.
 */
@XmlType(name = "test")
@XmlRootElement
public class TESTJaxbV2 {

    @XmlElementWrapper(name = "list_animals", nillable = true)
    public List<CatMy> annimals = new ArrayList<>();

    public static void main(String[] args) throws JAXBException {
        CatMy catMy = new CatMy("cat", 23);
        TESTJaxbV2 testJaxbV2 = new TESTJaxbV2();
        testJaxbV2.annimals.add(catMy);
        testJaxbV2.annimals.add(catMy);

        StringWriter writer = new StringWriter();

        JAXBContext context = JAXBContext.newInstance(CatMy.class, TESTJaxbV2.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        marshaller.marshal(testJaxbV2, writer);
        System.out.println(writer.toString());

    }
}

@XmlType(name = "tiger")
class CatMy {
    @XmlElement(name = "catname")
    public String name;

    @XmlAttribute(name = "age")
    public int age;

    public CatMy() {

    }

    public CatMy(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
