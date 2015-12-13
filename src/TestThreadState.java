/**
 * Created by Santer on 11.12.2015.
 */
public class TestThreadState {

    public static void main(String[] args) {
        for (Thread.State states : Thread.State.values()) {
            System.out.println(states);
        }
        System.out.println("\n....");
        System.out.println(Thread.currentThread().getState());
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getState());
    }
}
