/**
 * Created by Santer on 19.12.2015.
 */
public class TestPolyInheritEasy {
    public static void main(String[] args) {
        A a = new B();
        a.print();

        B b = new B();
        b.print();
        b.testB();
    }
}

class A {
    public A print() {
        System.out.println("class A");
        return new A();
    }
}

class B extends A {
    @Override
    public A print() {
        System.out.println("class B");
        return new B();
    }

    public void testB() {
        System.out.println("testB");
    }
}
