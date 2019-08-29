package section8;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class C8_1_2Executors {
    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(3);
        service.scheduleAtFixedRate(() -> System.out.println("hello"), 0, 2, TimeUnit.SECONDS);
        service.scheduleAtFixedRate(() -> System.out.println("hello2"), 0, 2, TimeUnit.SECONDS);
    }

}
