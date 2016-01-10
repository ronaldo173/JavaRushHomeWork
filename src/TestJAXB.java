import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * Created by Santer on 09.01.2016.
 */

@XmlType(name = "cat")
@XmlRootElement
public class TestJAXB {
    public String name;
    public int age;
    public int weight;

    public TestJAXB(String name, int age, int weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    public TestJAXB() {
    }

    public static void main(String[] args) throws IOException, JAXBException {
        TestJAXB cat = new TestJAXB("cat", 23, 82);
        System.out.println("origin: \t" + cat);

        StringWriter writer = new StringWriter();

        JAXBContext context = JAXBContext.newInstance(TestJAXB.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        marshaller.marshal(cat, writer);

        String result = writer.toString();
        System.out.println(result);

        //deserialize
        StringReader reader = new StringReader(result);
        JAXBContext jaxbContext = JAXBContext.newInstance(TestJAXB.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        TestJAXB testJAXB = (TestJAXB) unmarshaller.unmarshal(reader);
        System.out.println("deserialize: \t" + testJAXB);
    }

    @Override
    public String toString() {
        return "TestJAXB{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                '}';
    }
}



/*
Java Architecture for XML Binding (JAXB) позволяет Java разработчикам ставить в соответствие Java классы и XML представления.
 JAXB предоставляет две основные возможности: маршаллирование Java объектов в XML и наоборот, то есть демаршализация из XML обратно в Java объект.
 Другими словами, JAXB позволяет хранить и извлекать данные в памяти в любом XML-формате, без необходимости выполнения определенного набора
 процедур загрузки и сохранения XML. Он похож на xsd.exe и XmlSerializer в .NET Framework.
JAXB особенно полезен, когда спецификация является сложной и меняющейся. В этом случае, постоянные изменения схемы XML определений
 для синхронизации их с определениями Java могут занять много времени и быть подвержены ошибкам.
JAXB является частью Java SE платформы и является одной из API в Java EE платформе, и является частью Java Web Services Development
Pack (JWSDP). Он также является базисом для WSIT. JAXB является частью SE версии 1.6.
JAXB 1.0 был разработан в рамках Java Community Process как JSR 31.[1] Как и в 2006, JAXB 2.0 разрабатывается в рамках JSR 222.[2]
 Эталонная реализация для этих спецификаций доступна как CDDL open source license на java.net.
 */