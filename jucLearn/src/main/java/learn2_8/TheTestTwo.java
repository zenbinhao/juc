package learn2_8;/*
 * @Author: zeng
 * @Data: 2022/2/8 15:05
 * @Description: TODO
 */
import java.util.concurrent.ConcurrentHashMap;
import java.util.HashMap;
import java.util.concurrent.locks.ReentrantLock;

public class TheTestTwo {
    public static void main(String[] args) {
//        ConcurrentHashMap<String, Object> concurrentHashMap = new ConcurrentHashMap<>();
//        boolean b = concurrentHashMap.containsKey(null);
//        concurrentHashMap.put(null,"hh");


        HashMap<String, Object> map = new HashMap<>();
        map.put(null,"有值");
        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.lock();
        System.out.println(map.containsKey(null));
        if (!map.containsKey(null)){
            map.put(null,"无值赋值");
        }
        System.out.println(map.get(null));
    }
}
