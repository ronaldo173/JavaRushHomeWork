/**
 * Created by Santer on 18.12.2015.
 */
public class TestJoin {
    public static void main(String[] args) throws InterruptedException {
        Thread t1, t2;

        System.out.println("main thread: " + Thread.currentThread().getName());

        t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "...started");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "...finished");
            }
        });
        t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "...started");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "...finished");
            }
        });

        Thread.sleep(2000);
        System.out.println("main.." + Thread.currentThread().getName() + "...finished");

        t1.start();
        t2.start();

        t1.join();
        t2.join(2000);
        Thread.currentThread().join(2000);

        t1.yield();
    }
}
