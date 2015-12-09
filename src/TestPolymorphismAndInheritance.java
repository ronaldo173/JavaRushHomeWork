/**
 * Created by Santer on 26.11.2015.
 */
public class TestPolymorphismAndInheritance {
    static class Human {
        public Human() {
            System.out.println("Human constructor!");
        }

    }

    static class Person extends Human {
        public Person() {
            System.out.println("constructor PERSON");
        }

        int i = 0;

        protected void printI() {
            System.out.println(i);
        }
    }

    static class Student extends Person {
        public Student() {
            System.out.println("Constructor STUDENT");
        }

        int i = 1;

        public void printI() {
            System.out.println(i);
        }
    }

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
}
