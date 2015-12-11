/**
 * Created by Santer on 11.12.2015.
 */
public class TestInnerClassWIthPrivateConstructor {


    public static void main(String[] args) {
        System.out.println("start...\n");


//        testPRivateConstructor testPRivateConstructor = new testPRivateConstructor();
//        testPRivateConstructor.Inner inner = new testPRivateConstructor().new Inner();
        testPRivateConstructor testOuter = testPRivateConstructor.getInstance();
        testPRivateConstructor.Inner inner = testOuter.new Inner();

        System.out.println("\n---test with inheritance---");
        InheritOfInner inheritOfInner = new InheritOfInner(testOuter);
    }
}

class testPRivateConstructor {
    private static testPRivateConstructor testPRivateConstructor = null;

    private testPRivateConstructor() {
        System.out.println("private!");
    }

    public static testPRivateConstructor getInstance() {
        if (testPRivateConstructor == null) {
            testPRivateConstructor = new testPRivateConstructor();
        }
        return testPRivateConstructor;
    }

    public class Inner {
        Inner() {
            System.out.println("constructor Inner");
        }
    }
}

class InheritOfInner extends testPRivateConstructor.Inner {
    public InheritOfInner(testPRivateConstructor testPRivateConstructor) {
        testPRivateConstructor.super();
        System.out.println("Inheritance's of inner constructor");
    }
}