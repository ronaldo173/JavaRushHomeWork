/**
 * Created by Santer on 30.11.2015.
 */
public class testV2 {
    public static void main(String[] args) {
        parent ch = new Child();
        System.out.println(ch.getId());
    }

}

class parent {
    private int id;

    public parent() {
        System.out.println("parent constructor!");
        this.id = 10;
    }

    protected int getId() {
        return id;
    }
}

class Child extends parent {
    int id = 1;

    public int getId() {
        return id;
    }
}