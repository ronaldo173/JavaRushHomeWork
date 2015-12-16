import java.util.Scanner;

/**
 * Created by Santer on 16.12.2015.
 */
public class TestWaitNotify {
    public static void main(String[] args) throws InterruptedException {
        final Payment payment = new Payment();
        new Thread() {
            public void run() {
                payment.doPayment();
            }
        }.start();

        Thread.sleep(1000);

        synchronized (payment) {
            System.out.println("Initialize amount: ");
            payment.initAmount();
            payment.notify();
        }
        synchronized (payment) {
            payment.wait(1000);
            System.out.println("ok");
        }
    }
}

class Payment {

    int amount;
    private boolean close;

    public int getAmount() {
        return amount;
    }

    public boolean isClosed() {
        return close;
    }

    public synchronized void doPayment() {
        try {
            System.out.println("Start payment... wait()");

            while (amount <= 0) {
                this.wait();
            }
            System.out.println("Wake up!");
            close = true;

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void initAmount() {
        Scanner scanner = new Scanner(System.in);
        amount = scanner.nextInt();
    }
}
