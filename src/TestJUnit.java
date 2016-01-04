import org.junit.Test;

/**
 * Created by Alex on 04.01.2016.
 */
public class TestJUnit {
    @Test
    public void test() {
        Calculator calculator = new Calculator(5);
        System.out.println(calculator.pow2());
    }
}

class Calculator {
    protected final int i;

    public Calculator() {
        i = 1;
    }

    public Calculator(int i) {
        this.i = i;
    }

    public int pow2() {
        return i * i;
    }


}
