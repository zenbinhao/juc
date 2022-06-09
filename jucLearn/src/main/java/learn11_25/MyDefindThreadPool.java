package learn11_25;/*
 * @Author: zeng
 * @Data: 2021/11/25 23:51
 * @Description: TODO
 */

import java.util.concurrent.*;

public class MyDefindThreadPool {
    public static void main(String[] args) {
        // 决定这个程序的最大线程数 两种方式
        //1. cpu密集型
        //2. io密集型
            AbstractExecutorService abstractExecutorService = new ThreadPoolExecutor(
                4,
                4,
                3L,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardOldestPolicy()
        );
        //4大拒绝策略
//        new ThreadPoolExecutor.AbortPolicy() 当队列已满 再来一个线程时 不处理该线程 且会抛出异常
//        new ThreadPoolExecutor.CallerRunsPolicy() 当队列已满 线程池不执行  main线程执行 （哪来的回哪去）谁调用则谁执行
//        new ThreadPoolExecutor.DiscardPolicy() 当队列已满 直接放弃该任务 且不抛出异常
//        new ThreadPoolExecutor.DiscardOldestPolicy() 当队列已满 尝试与队列首等待的去竞争 不会抛出异常

        // 使用线程池创建线程
        try {
            for (int i = 0; i < 7; i++) {
                abstractExecutorService.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"线程执行");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            abstractExecutorService.shutdown();
        }


    }
}
