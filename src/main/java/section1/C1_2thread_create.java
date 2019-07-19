package section1;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class C1_2thread_create {

    static class MyFutureTask implements Callable<String> {

        public String call() {
            System.out.println("线程启动了");
            return "123";
        }
    }

    public static void main(String[] args) {
        FutureTask<String> futureTask = new FutureTask<>(new MyFutureTask());
        futureTask.run();
        try {
            String s = futureTask.get();
            System.out.println("返回的结果为:" + s); // 返回的结果为:123
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
