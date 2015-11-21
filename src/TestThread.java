import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestThread implements Runnable {

    private final int id;
    private IntGenerator generator;

    public TestThread(IntGenerator i, int ident) {
        this.id = ident;
        this.generator = i;
    }

    public static synchronized void test(IntGenerator g, int count) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        for (int i = 0; i < count; i++) {
            executorService.execute(new TestThread(g, i));
            executorService.shutdown();
        }
    }

    public static void test(IntGenerator g) {
        test(g, 10);
    }

    @Override
    public void run() {
        while (!generator.isCancel()) {
            int val = generator.next();
            if (val % 2 != 0) {
                System.out.println(val + " NET ESHE");
                generator.cancel();
            }
        }
    }
}

abstract class IntGenerator {
    private volatile boolean cancel;

    abstract int next();

    void cancel() {
        cancel = true;
    }

    boolean isCancel() {
        return cancel;
    }
}

class EvenGenerator extends IntGenerator {

    private int currEventVal = 0;
    private Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        TestThread.test(new EvenGenerator());
    }

    @Override
    public int next() {
        lock.lock();
        try {
            ++currEventVal;
            Thread.yield();
            ++currEventVal;
            return currEventVal;
        } finally {
            lock.unlock();
        }
    }
}

