/**
 * Created by Santer on 11.12.2015.
 */
public class TestInnerCompileInto {

    public static void main(String[] args) {
        System.out.println("check");
        NestedClassStatic innerStatic = new NestedClassStatic();
        InnerNonStatic innerNonStatic = new TestInnerCompileInto().new InnerNonStatic();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Annonymous1");
            }
        }).start();
    }

    static class NestedClassStatic {
        public NestedClassStatic() {
            System.out.println("Nested static compiled: TestInnerCompileInto$NestedClassStatic.class");
        }


    }

    class InnerNonStatic {
        public InnerNonStatic() {
            System.out.println("Inner non static compiled into: TestInnerCompileInto$InnerNonStatic.class");
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("inner-anonymous");
                }
            }).start();
        }
    }
}
