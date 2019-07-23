package section10;

import com.sun.jmx.snmp.tasks.ThreadService;

import java.util.concurrent.*;

public class C10_1_1CountDownLatch {
    private static CountDownLatch synchronizer = new CountDownLatch(2);

    private static void test1() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                synchronizer.countDown();
            }
            System.out.println("子线程1:运行完毕");
        });


        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(1100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                synchronizer.countDown();
            }
            System.out.println("子线程2:运行完毕");
        });
        t1.start();
        t2.start();

        System.out.println("主线程启动:等待子线程完成");
        synchronizer.await();
        System.out.println("主线程: 运行完成");
    }

    private static void test2() throws InterruptedException {
        //创建2个固定线程的线程池
        ExecutorService pool = Executors.newFixedThreadPool(2);
        pool.submit(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                synchronizer.countDown();
            }
            System.out.println("子线程1:运行完毕");
        });

        pool.submit(() -> {
            try {
                Thread.sleep(1100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                synchronizer.countDown();
            }
            System.out.println("子线程2:运行完毕");
        });

        System.out.println("主线程启动:等待子线程完成");
        synchronizer.await();
        System.out.println("主线程: 运行完成");
        //关闭线程池
        pool.shutdown();

    }

    public static void main(String[] args) throws InterruptedException {
        test2();
    }
}
