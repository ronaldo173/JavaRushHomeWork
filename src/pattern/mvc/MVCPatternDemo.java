package pattern.mvc;

/**
 * Created by Alex on 14.01.2016.
 */
public class MVCPatternDemo {

    public static void main(String[] args) {
        //model
        Student model = new Student("no", "Alex");

        //view
        StudentView view = new StudentView();

        //controller
        StudentController controller = new StudentController(model, view);
        controller.updateView();

        controller.setStudentName("Lionel");
        controller.updateView();
    }
}
