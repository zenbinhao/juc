package learn11_25;/*
 * @Author: zeng
 * @Data: 2021/11/25 23:32
 * @Description: TODO
 */

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public class SynchronousQueueDemo {
    public static void main(String[] args) {
        //线程安全
        //同步队列  队列长度只有1
        SynchronousQueue synchronousQueue = new SynchronousQueue();

        new Thread(()->{
            try {
                System.out.println(Thread.currentThread().getName()+"线程往队列中put一个数");
                synchronousQueue.put("a");
                System.out.println(Thread.currentThread().getName()+"线程往队列中put一个数");
                synchronousQueue.put("a");
                System.out.println(Thread.currentThread().getName()+"线程往队列中put一个数");
                synchronousQueue.put("a");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
                System.out.println(Thread.currentThread().getName()+"线程拿出队列中的数");
                synchronousQueue.take();
                TimeUnit.SECONDS.sleep(2);
                System.out.println(Thread.currentThread().getName()+"线程拿出队列中的数");
                synchronousQueue.take();
                TimeUnit.SECONDS.sleep(2);
                System.out.println(Thread.currentThread().getName()+"线程拿出队列中的数");
                synchronousQueue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }
}
