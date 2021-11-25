package learn11_23;/*
 * @Author: zeng
 * @Data: 2021/11/23 17:49
 * @Description: TODO
 */


import java.util.UUID;
import java.util.concurrent.*;

public class Utils3 {
    public static void main(String[] args) {
        //JUC三大辅助类
//        CountDownLatchDemo();
//        CyclicBarrierDemo();
        SemaphoreDemo();
    }


    //CountDownLatch
    //线程计数器
    public static void CountDownLatchDemo(){
        System.out.println("开门");

        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 1; i <=6 ; i++) {
            final int temp = i;
            new Thread(()->{
                System.out.println("同学"+Thread.currentThread().getName()+":已进入教室，坐到上位置"+temp);

                //计数器减1
                countDownLatch.countDown();
            },String.valueOf(i)).start();
        }

        //当计数器 归零时才能继续向下  否则阻塞
        //若无等待方法则直接会输出 开门且关门 把所有同学关在外面
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("关门");
        }
    }

    //凑齐线程次数 可以进行新线程的开启
    public static void CyclicBarrierDemo(){
        System.out.println("恶魔关卡,必须4人才能进入副本----");
        CyclicBarrier cyclicBarrier = new CyclicBarrier(4,()->{
            System.out.println("id为:"+ UUID.randomUUID().toString().substring(0,3) +"组成功进入副本");
        });

        for (int i = 0; i <= 27; i++) {
            final int n = i;
            final String temp = "qwertyuiopasdfghjklzxcvbnm[];'.//";
            new Thread(()->{
                System.out.println(temp.charAt(n)+"勇士已准备");

                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

    // 线程容量  队列  限流  降级
    public static void SemaphoreDemo(){
        System.out.println("餐厅开业啦~~~~一共只有9张桌子，，先到先吃");
        Semaphore semaphore = new Semaphore(9);

        for (int i = 0; i < 30; i++) {
            final int temp = i;
            new Thread(()->{
                try {
                    //获得锁
                    semaphore.acquire();
                    System.out.println(temp+"顾客进入餐厅就餐");
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println(temp+"顾客吃完出门了");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    //释放锁
                    semaphore.release();
                }
            }).start();
        }
    }
}
