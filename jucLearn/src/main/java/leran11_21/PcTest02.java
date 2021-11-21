package leran11_21;/*
 * @Author: zeng
 * @Data: 2021/11/21 23:51
 * @Description: TODO
 */

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// JUC包下lock版  生产消费者

public class PcTest02 {
    public static void main(String[] args) {
        Data1 data = new Data1();

        new Thread(()->{
            for(int i=0;i<100;i++){
                data.addNumber();
            }
        },"A").start();
        new Thread(()->{
            for(int i=0;i<100;i++){
                data.subNumber();
            }
        },"B").start();
        new Thread(()->{
            for(int i=0;i<100;i++){
                data.addNumber();
            }
        },"C").start();
        new Thread(()->{
            for(int i=0;i<100;i++){
                data.subNumber();
            }
        },"D").start();
    }
}

//资源类
class Data1{

    private Integer number = 0;
    private final Lock lock =new ReentrantLock();
    private final Condition condition = lock.newCondition();


    public void addNumber(){
        lock.lock();
        try {
            //业务代码
            while(number!=0){
                //线程等待
                condition.await();
            }

            //执行业务
            number++;
            System.out.println(Thread.currentThread().getName()+"线程-->执行后number="+number);

            //通知
            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void subNumber(){
        lock.lock();
        try {
            //业务代码
            while(number==0){
                //线程等待
                condition.await();
            }

            //执行业务
            number--;
            System.out.println(Thread.currentThread().getName()+"线程-->执行后number="+number);

            //通知
            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}