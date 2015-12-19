import com.javarush.test.level20.lesson02.task05.Solution;

/**
 * Created by Santer on 17.12.2015.
 */
public class TestThreadStateSynch {

    public static void main(String[] args) throws InterruptedException {
        final Object objectSych = new Solution.Object();

        for (Thread.State state : Thread.State.values()) {
            System.out.println(state);
        }

        System.out.println("main thread name: " + Thread.currentThread().getName());
        System.out.println("----");

        System.out.println("join 2500");
        Thread.currentThread().join(2500);

        final Thread threadForCheck = new Thread(new Runnable() {
            boolean condition = false;

            @Override
            public void run() {
                System.out.println("it's thread: " + Thread.currentThread().getName());
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("wait2000:");
                myWait();

                myNotify();
                System.out.println("wait(2000) + sleep(2000)");
                myWait();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

            private synchronized void myNotify() {
                notifyAll();
            }

            private synchronized void myWait() {
                try {
                    wait(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("...jount 3000");

//                try {
//                    while (!condition) {
//                        wait();
//                    }
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
        });


        Thread thread = new Thread(new Runnable() {
            protected void stopMeth() {
            }

            @Override
            public void run() {
                int i = 0;
                System.out.println("daemon started");

                while (true) {
                    try {
                        Thread.sleep(1000);
                        i++;

                        System.out.println("from daemon: " + threadForCheck.getName() + " ..state is: " +
                                threadForCheck.getState() + "..sec now: " + i);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.setDaemon(true);
        thread.start();

        threadForCheck.start();

        System.out.println("sleep from main thread");
        Thread.sleep(10000);

    }
}
