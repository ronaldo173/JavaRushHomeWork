import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Created by Santer on 02.12.2015.
 */
public class testV3 {
    public static void main(String[] args) {
            getMethods(new SomeClassWithXzMethods());
    }

    static void getMethods(Object object){
        Class clazz = object.getClass();
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(Modifier.toString(method.getModifiers()) + " " +
            method.getName());
            System.out.println(method.getReturnType());
        }
    }

    static class SomeClassWithXzMethods{
        private void firstPRivate(){
            System.out.println("firstPRivate");
        }
        public void getSecond(){
            System.out.println("2");
        }
        protected void thirdProtected(){}

    }

}
