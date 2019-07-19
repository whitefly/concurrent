package section6;

import java.util.concurrent.locks.LockSupport;

public class C6_1LockSupport {
    public static void main(String[] args) {
        final Thread main = Thread.currentThread();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    System.out.println("子线程: 准备唤醒主线程");
                    LockSupport.unpark(main); //子线程来唤醒主线程
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        //明天就只打了
        t1.start();

        System.out.println("准备锁住自己");
        LockSupport.park(); //阻塞自己
        System.out.println("over!");
    }
}
