import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Santer on 13.12.2015.
 */
public class TestComparable {
    public static void main(String[] args) {
        List<Woman> list = new ArrayList<>();
        list.add(new Woman(22));
        list.add(new Woman(11));
        list.add(new Woman(1));

        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
    }
}

class Woman implements Comparable<Woman> {
    public int age;

    public Woman(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Woman o) {
        return this.age - o.age;
    }

    @Override
    public String toString() {
        return "Woman{" +
                "age=" + age +
                '}';
    }
}