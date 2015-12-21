import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Santer on 21.12.2015.
 */
public class TestWaitNotifyAgain {
    Object object = new Object();
    private boolean flag = false;

    public static void main(String[] args) {
        final ExecutorService executorService = Executors.newFixedThreadPool(3);
        final TestWaitNotifyAgain testWaitNotifyAgain = new TestWaitNotifyAgain();

        for (int i = 0; i < 3; i++) {
            final int count = i;
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    if (count == 0) {
                        try {
                            testWaitNotifyAgain.meth1WaitingForMeth2();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else if (count == 1) {
                        try {
                            testWaitNotifyAgain.meth2();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        try {
                            testWaitNotifyAgain.meth0WaitingForMeth2();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }
        executorService.shutdown();
    }

    public void meth0WaitingForMeth2() throws InterruptedException {

        synchronized (object) {
            System.out.println("meth0WaitingForMeth2...go wait for 2");
            while (!flag) {
                object.wait();
            }
            System.out.println("meth0WaitingForMeth2... WOKE UP");
        }
    }

    public void meth1WaitingForMeth2() throws InterruptedException {

        synchronized (object) {
            System.out.println("meth1WaitingForMeth2...go wait for 2");
            while (!flag) {
                object.wait();
            }
            System.out.println("meth1WaitingForMeth2... WOKE UP");
        }
    }

    public void meth2() throws InterruptedException {
        synchronized (object) {
            Thread.sleep(100);
            System.out.println("...method2..sleep 3sec");
            int n = 3;
            while (n > 0) {
                System.out.println(n);
                Thread.sleep(1000);
                n--;
            }
            flag = true;
            object.notifyAll();
        }
    }
}
