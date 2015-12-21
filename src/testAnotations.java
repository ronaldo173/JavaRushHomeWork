import com.javarush.test.level24.lesson06.home03.Author;
import org.junit.Test;

/**
 * Created by Santer on 21.12.2015.
 */
public class testAnotations {

    public static void main(String[] args) {

    }

    public void print1() {
        System.out.println("print");
    }

    @SuppressWarnings("test")
    @Deprecated
    @Author(testDeprecatedMethod = "134")
    public void anotationTest() {
        System.out.println("hello");
        System.out.println(Author.name);
    }

    @Test
    public void testMethod() {
        anotationTest();
        System.out.println("\n");
        print1();
    }
}
