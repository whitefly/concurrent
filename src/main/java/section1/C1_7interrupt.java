package section1;

public class C1_7interrupt {
    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("t1:开始sleep");
                    Thread.sleep(100000);
                } catch (InterruptedException e) {
                    System.out.println("处于sleep状态的我,因为interrupt被唤醒了");
                }
            }
        });

        t.start();
        t.interrupt();
    }
}
