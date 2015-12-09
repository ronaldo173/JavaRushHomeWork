import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Santer on 27.11.2015.
 */
public class TestDifferent {
    public static void main(String[] args) {
        List<Figure> list = new ArrayList<>();
        Collections.addAll(list, new Rhomb(), new Triangle(), new Square());

        for (Figure figure : list) {
            figure.print();
        }
    }
}

abstract class Figure {
    public Figure(){
        System.out.println("constructor parent " );
    }
    public void print() {
        System.out.println("Figure");
    }
}

class Rhomb extends Figure {
    @Override
    public void print() {
        System.out.println("Rhomb");
    }
}

class Triangle extends Figure {
    @Override
    public void print() {
        System.out.println("Triangle");
    }
}

class Square extends Figure {
    @Override
    public void print() {
        System.out.println("Square");
    }
}