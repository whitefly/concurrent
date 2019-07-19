package section1;

public class C1_10deamonThread {

    public static void main(String[] args) {
        Thread deamonThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {

                }
            }
        });

        Thread userThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("用户线程运行完毕");
            }
        });

        deamonThread.setDaemon(true);

        deamonThread.start();
        userThread.start();
    }
}
