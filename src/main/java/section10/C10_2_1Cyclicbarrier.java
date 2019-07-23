package section10;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class C10_2_1Cyclicbarrier {
    private static CyclicBarrier cycle = new CyclicBarrier(2, () -> {
        System.out.println(Thread.currentThread().getName() + ":批改作业完成,可以继续下阶段作业");
    });

    static class task implements Runnable {

        @Override
        public void run() {
            try {
                String name = Thread.currentThread().getName();
                System.out.println(name + ": 启动");
                Thread.sleep(1000);
                System.out.println(name + ": 完成easy作业");
                //等待easy作业批改
                cycle.await();

                System.out.println(name + ": 完成hard作业");
                //等待hard作业批改
                cycle.await();
                System.out.println(name + ": 作业完成,放学回家");


            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    private static void test1() {
        ExecutorService pool = Executors.newFixedThreadPool(2);
        pool.submit(new task());
        pool.submit(new task());

        pool.shutdown();
        System.out.println(Thread.currentThread().getName() + ":over");
    }

    public static void main(String[] args) {
        test1();
    }
}
