package section10;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class C10_3_1Semaphore {
    private static Semaphore semaphore = new Semaphore(1);

    static class Task implements Runnable {
        @Override
        public void run() {
            String name = Thread.currentThread().getName();
            System.out.println(String.format("%s:启动", name));

            try {
                Thread.sleep(1200);
                System.out.println(String.format("%s:over", name));
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(2);
        pool.submit(new Task());
        pool.submit(new Task());

        semaphore.acquire(3);
        System.out.println("main:over");
        pool.shutdown();
    }
}
