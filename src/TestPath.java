import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Santer on 06.01.2016.
 */
public class TestPath {
    public static void main(String[] args) {
        String path1St = "C:\\Users\\Santer\\Desktop\\Development\\JavaRush\\JavaRushHomeWork\\tempJRfiles\\111.txt";

        Path path1 = Paths.get(path1St);

        System.out.println(path1);
        System.out.println(path1.getRoot());
        System.out.println(path1.getParent());

        System.out.println(path1.getParent().relativize(path1));

    }
}
