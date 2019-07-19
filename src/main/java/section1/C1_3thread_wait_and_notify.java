package section1;

import org.omg.PortableServer.THREAD_POLICY_ID;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class C1_3thread_wait_and_notify {
    static final Queue<Integer> Q = new LinkedList<>();
    static final int size = 10;
    static Random random = new Random();


    static class Producer implements Runnable {

        @Override
        public void run() {
            while (true) {
                synchronized (Q) {
                    while (Q.size() >= size) {
                        try {
                            Q.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    Q.add(random.nextInt(10));
                    Q.notifyAll();
                    System.out.println("唤醒全部");
                }
            }

        }
    }

    static class Consumer implements Runnable {

        @Override
        public void run() {
            while (true) {
                synchronized (Q) {
                    while (Q.isEmpty()) {
                        try {
                            Q.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    Integer some = Q.poll();
                    System.out.println("消费了:" + some);
                    Q.notifyAll();
                }

            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
//        Thread t1 = new Thread(new Producer());
//        Thread t2 = new Thread(new Consumer());
//
//        t1.start();
//        t2.start();

        //实现 notify() 和 notifyall()的区别
        final Object o = new Object();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (o) {
                    try {
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "被唤醒了,over");
                }

            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (o) {
                    try {
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "被唤醒了,over");
                }

            }
        });

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (o) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

//                    System.out.println("执行notify()");
//                    o.notify();
                    System.out.println("执行notifyAll()");
                    o.notifyAll();
                }

            }
        });

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();


    }
}
