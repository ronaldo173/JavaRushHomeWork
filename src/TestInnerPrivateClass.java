/**
 * Created by Santer on 11.12.2015.
 */
public class TestInnerPrivateClass {

    public static void main(String[] args) {
        Outer outer = new Outer();

        //test amount of inner classes
//        for (int i = 0; i < 101; i++) {
//            new Outer(){
//                @Override
//                public void printXz() {
//                    System.out.println("ggLOL");
//                }
//            }.printXz();
//        }
    }
}

class Outer {
    public Outer() {
        System.out.println("Outer constructor");
        Inner inner = new Inner();
        inner.printNumbers();
        printXz();
    }

    public void printXz() {
        System.out.println("xz");
        for (int i = 0; i < 50; i++) {
            new Outer() {
                @Override
                public void printXz() {
                    System.out.println("gg");
                    ;
                }
            }.printXz();
        }
    }

    private class Inner {
        public int fieldPublic = 10;
        private int fieldPrivate = 1;

        public Inner() {
            System.out.println("Inner constructor");
        }

        protected void printNumbers() {
            System.out.println(fieldPrivate + " " + fieldPublic);
        }
    }
}