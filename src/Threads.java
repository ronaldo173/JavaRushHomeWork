/**
 * Created by Саша on 22.07.2015.
 */
public class Threads implements Runnable {
    private BankAccount account = new BankAccount();

    public static void main(String[] args) {
        Threads Oba = new Threads();
        Thread one = new Thread(Oba);
        Thread two = new Thread(Oba);
        one.setName("РАЙАН");
        two.setName("АНЖЕЛИКА");
        one.start();
        two.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            makeWithr(10);
            if (account.getBalance() < 0) {
                System.out.println("LIMIT IS OVER");
            }
        }
    }

    private synchronized void makeWithr(int i) {
        if (account.getBalance() >= i) {
            System.out.println(Thread.currentThread().getName() + " собирается снять " + i);
            try {
                System.out.println(Thread.currentThread().getName() + "go to sleep");
                Thread.sleep(600);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "Wake up");
            account.withdraw(i);
            System.out.println(Thread.currentThread().getName() + "Finish iziyatie");
        } else {
            System.out.println("НЕТ ДЕНЕГ для " + Thread.currentThread().getName());
        }
    }
}

class BankAccount {
    private int balance = 100;

    public int getBalance() {
        return balance;
    }

    void withdraw(int amount) {
        balance = balance - amount;
    }
}

