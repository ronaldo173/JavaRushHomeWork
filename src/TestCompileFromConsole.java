import java.io.File;

/**
 * Created by Santer on 21.12.2015.
 */
public class TestCompileFromConsole extends TestCompileFromConsoleParent {

    public TestCompileFromConsole() {
        System.out.println("TestCompileFromConsole");

        File file = new File("C:\\Users\\Santer\\Desktop\\Development\\JavaRush\\JavaRushHomeWork\\tempJRfiles\\papkaTest\\gg\\testvl3");

        if (!file.exists()) {
            file.mkdirs();
        }
    }

    public static void main(String[] args) {
        new TestCompileFromConsole();
    }
}
