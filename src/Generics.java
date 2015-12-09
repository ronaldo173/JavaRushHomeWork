import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by Santer on 02.12.2015.
 */
public class Generics {

    public static <E> void printArray(E[] inputArray) {
        String curMEthodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        for (E e : inputArray) {
            System.out.printf("%s ", e);
        }
        System.out.println("..." + curMEthodName + " "  );
    }

    public static <A extends  Comparable<A>> A max(A x, A y, A z){
        A max = x;
        if( y.compareTo(x) >0){
            max = y;
        }
        if(z.compareTo(max)>0){
            max = z;
        }
        return  max;

    }

    public static void main(String[] args) {
        Integer[] intArray = {1,2,3,4,5};
        Double[] doubleArray = {1.1, 2.2, 3.3, 5.5};
        Character[] charArray = {'a', 'b', 'c'};

        printArray(intArray);
        printArray(doubleArray);
        printArray(charArray);

        System.out.println(max(1, 2, 3));
        System.out.println(max('a', 'b', 'c'));
    }
}
