import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Santer on 13.12.2015.
 */
public class TestComparator {
    static Comparator<WomanCOmp> comparator = new
            Comparator<WomanCOmp>() {
                @Override
                public int compare(WomanCOmp o1, WomanCOmp o2) {
                    return o2.age - o1.age;
                }
            };

    public static void main(String[] args) {

        List<WomanCOmp> list = new ArrayList<>();
        list.add(new WomanCOmp(99));
        list.add(new WomanCOmp(77));
        list.add(new WomanCOmp(55));
        list.add(new WomanCOmp(11));
        list.add(new WomanCOmp(33));

        System.out.println(list);
        Collections.sort(list, comparator);
        System.out.println(list);
    }
}


/**
 * test Comparator
 */
class WomanCOmp {

    int age;
    int weight;
    int height;
    String name;

    public WomanCOmp(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "WomanCOmp{" +
                "age=" + age +
                '}';
    }
}