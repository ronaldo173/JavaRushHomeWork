import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Santer on 17.12.2015.
 */
public class TestWaitNotifyState {
    static Object object = new Object();

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        final boolean[] flag = {false};

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("4 thread");
                myNotify();
            }

            private void myNotify() {
                synchronized (TestWaitNotifyState.class) {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    TestWaitNotifyState.class.notifyAll();
                }
                flag[0] = true;
                System.out.println("notify used...");
            }
        });

        for (int i = 0; i < 3; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    testSynch();
                }

                private void testSynch() {
                    synchronized (TestWaitNotifyState.class) {
                        System.out.println("..wait:");
                        try {
                            while (!flag[0]) {
                                TestWaitNotifyState.class.wait();
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName());
                    }
                }
            });
        }

        executorService.shutdown();
    }
}
