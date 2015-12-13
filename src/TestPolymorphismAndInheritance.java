/**
 * Created by Santer on 26.11.2015.
 */
public class TestPolymorphismAndInheritance {
    public static void main(String[] args) {

        Person person = new Person();
        System.out.println(person instanceof Person);
        System.out.println(person instanceof Student);
        person.printI();//print 0
        System.out.println("---");

        Person student = new Student();
        System.out.println(student instanceof Student);
        System.out.println(student instanceof Person);
        student.printI();//print 1

//        Student student1 = (Student) new Person();//ClassCastException downcasting
//        student1.printI();
    }

    static class Human {
        public Human() {
            System.out.println("Human constructor!");
        }

    }

    static class Person extends Human {
        int i = 0;

        public Person() {
            System.out.println("constructor PERSON");
        }

        protected void printI() {
            System.out.println(i);
        }
    }

    static class Student extends Person {
        int i = 1;

        public Student() {
            System.out.println("Constructor STUDENT");
        }

        public void printI() {
            System.out.println(i);
        }
    }
}
