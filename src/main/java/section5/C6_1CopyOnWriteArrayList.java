package section5;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class C6_1CopyOnWriteArrayList {
    public static void main(String[] args) {
        //若一致性的表现
        CopyOnWriteArrayList<String> demo = new CopyOnWriteArrayList<>();
        demo.add("1");
        demo.add("2");
        demo.add("3");
        demo.add("4");


        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                //对它进行一些修改操作
                demo.add("10");
                demo.remove(2);
            }
        });

        Iterator<String> iterator = demo.iterator();
        t1.start();


        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println();
        for (String item : demo) System.out.println(item);
    }
}
