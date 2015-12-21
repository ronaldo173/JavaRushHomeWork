import java.util.Arrays;

/**
 * Created by Santer on 19.12.2015.
 */
public class TestArrays {

    public static void main(String[] args) {
        String[] array = {"first", "second", "three"};

        for (String s : array) {
            System.out.println(s);
        }

        String string = Arrays.deepToString(array);
        System.out.println(string);

        String string1 = Arrays.toString(array);
        System.out.println(string1);
    }
}
