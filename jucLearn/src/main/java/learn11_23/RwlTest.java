package learn11_23;/*
 * @Author: zeng
 * @Data: 2021/11/25 18:49
 * @Description: TODO
 */

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

//读写锁测试
// 共享锁（读） 排他锁（写）
public class RwlTest {
    public static void main(String[] args) {
        MyCache myCache = new MyCache();

        for (int i = 0; i < 20; i++) {
            final int temp= i;
            new Thread(()->{
                myCache.put(""+temp,""+temp);
            },String.valueOf(i)).start();
        }
        for (int i = 0; i < 5; i++) {
            final int temp= i;
            new Thread(()->{
                myCache.get(""+temp);
            },String.valueOf(i)).start();
        }
    }
}
class MyCache{
    private volatile Map<String,String> map =new HashMap<>();
    ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    public void put(String key,String str){
        readWriteLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"正在写入");
            map.put(key,str);
            System.out.println(Thread.currentThread().getName()+"已经commit");
            System.out.println(Thread.currentThread().getName()+"放入键:"+key+"值:"+str);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }
    public void get(String key){
        readWriteLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"正在读取");
            System.out.println(Thread.currentThread().getName()+"取出键:"+key+"的值为"+map.get(key));
            System.out.println(Thread.currentThread().getName()+"读取完毕");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.readLock().unlock();
        }
    }
}