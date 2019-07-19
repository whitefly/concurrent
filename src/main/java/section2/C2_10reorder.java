package section2;

public class C2_10reorder {
    private static boolean ready;
    private static int num;

    static class ReadThread extends Thread {
        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("ReadThread: 尝试一次读取");
                if (ready) {
                    System.out.println(num + num);
                }
            }
        }
    }

    static class WriteThread extends Thread {
        @Override
        public void run() {
            num = 2;  //按照常理,先设置num=2,然后设置ready=true,然后
            ready = true;
            System.out.println("WriteThread设置num成功");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReadThread rt = new ReadThread();
        rt.start();

        WriteThread wt = new WriteThread();
        wt.start();

        Thread.sleep(10);
        rt.interrupt();
        System.out.println("main over");
    }
}
