package learn11_25;/*
 * @Author: zeng
 * @Data: 2021/11/25 22:49
 * @Description: TODO
 */

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

// 数组队列4大api

public class BlockQueueDemo {
    public static void main(String[] args) {
//        test1();
//        test2();
        test3();
//        test4();
    }

    private static void test4() {
        ArrayBlockingQueue<String> strings = new ArrayBlockingQueue<String>(3);
        try {
            //offer(,,)带三个参数时  设置了阻塞时间  不会一直等待
            System.out.println(strings.offer("a", 2, TimeUnit.SECONDS));
            System.out.println(strings.offer("a", 2, TimeUnit.SECONDS));
            System.out.println(strings.offer("a", 2, TimeUnit.SECONDS));
            System.out.println(strings.offer("a", 2, TimeUnit.SECONDS));

            //poll()带俩个参数时 设置了阻塞时间 不会一直阻塞
            System.out.println(strings.poll(2, TimeUnit.SECONDS));
            System.out.println(strings.poll(2, TimeUnit.SECONDS));
            System.out.println(strings.poll(2, TimeUnit.SECONDS));
            System.out.println(strings.poll(2, TimeUnit.SECONDS));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void test3() {
        ArrayBlockingQueue<String> strings = new ArrayBlockingQueue<>(3);
        //线程安全 有锁机制
        //因为输出语句没有被锁包含进去  所以输出的结果看不出来  但是等待的时候会发现只有3个线程被存入  且99个线程没有乱入
        for (int i = 0; i < 100; i++) {
            final int temp = i;
            new Thread(()->{
                try {
                    strings.put(""+temp);
                    System.out.println(temp+"存入队列");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                try {
                    TimeUnit.SECONDS.sleep(4);
                    strings.take();
                    System.out.println("取出队列");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        
//        try {
//            // put() 向队列中添加元素 无返回值 队列满时会一直阻塞
//            strings.put("a");
//            strings.put("a");
//            strings.put("a");
////            strings.put("a");
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }finally {
//            System.out.println("阻塞后会执行finally吗");
//        }
//            // take() 拿出队列中的元素  先入先出
//        try {
//            strings.take();
////            strings.take();
//            strings.take();
//            strings.take();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

    }

    private static void test2() {
        ArrayBlockingQueue<String> strings = new ArrayBlockingQueue<String>(3);
        System.out.println(strings.offer("a"));
        System.out.println(strings.offer("a"));
        System.out.println(strings.offer("a"));
        //offer() 存入队列 当队列满时返回false 不抛出异常
        System.out.println(strings.offer("a"));

        // poll()弹出 存入的数据  当没有时返回null  不会抛出异常
        System.out.println(strings.poll());
        System.out.println(strings.poll());
        System.out.println(strings.poll());
        System.out.println(strings.poll());

        //查看队列首个元素 不会抛出异常 为空时返回null
        System.out.println(strings.peek());
    }

    //阻塞及会抛出异常
    private static void test1(){
        //队列容量为3
        ArrayBlockingQueue<String> strings = new ArrayBlockingQueue<String>(3);
        //add()队列中添加 溢出及会抛出异常  实际是调用的offer()方法对其返回进行判断手动抛出异常
        System.out.println(strings.add("a"));
        System.out.println(strings.add("a"));
        System.out.println(strings.add("a"));
        //remove()移出队列首个元素  队列的原理  先入先出 FIFO  实际调用poll() 进行判断手动抛出异常
        // 超出队列容量时抛出异常
        //Exception in thread "main" java.lang.IllegalStateException: Queue full
//        System.out.println(strings.add("a"));
        System.out.println(strings.remove());
        System.out.println(strings.remove());
        System.out.println(strings.remove());

        // 找不到元素时异常
        //Exception in thread "main" java.util.NoSuchElementException
//        System.out.println(strings.remove());

        //element() 返回队列首个元素  当找不到时会抛出异常  实际调用peek进行判断手动抛出的异常
        //Exception in thread "main" java.util.NoSuchElementException
        strings.element();
    }
}

