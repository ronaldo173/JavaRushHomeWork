package pattern.mvc;

/**
 * Created by Alex on 14.01.2016.
 */
public class StudentView {
    /**
     * VIEW
     */

    public void printStudentDetails(String studentName, String studentRollNo) {
        System.out.println("Student: ");
        System.out.println("Name: " + studentName);
        System.out.println("Roll no: " + studentRollNo);
    }
}
