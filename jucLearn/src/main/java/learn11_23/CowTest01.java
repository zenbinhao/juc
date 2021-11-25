package learn11_23;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class CowTest01 {
    public static void main(String[] args) {
        //集合写入时线程安全问题:ConcurrentModificationException
        //Arraylist单线程安全  多线程不安全
        List<Integer> integers = Arrays.asList(1, 2, 3, 4);
        integers.forEach(System.out::println);

        System.out.println("--------------------------------");
        // 原本的Arraylist 线程不安全  会报错
        List list = new ArrayList();
        // 1.使用vector 线程安全  add方法上有synchronized
//        Vector<String> vector = new Vector<>();
        // 2.使用集合工具类
//        List list2 = Collections.synchronizedList(list);
        // 3.使用JUC包下的加强类cow
//        CopyOnWriteArrayList<Object> list = new CopyOnWriteArrayList<>();

        // set集合 无序且不重复 其原理就是hashmap 我们实际存的是的键名（所以是不能重复的），值是类里声明的固定值

        // hashmap的不同之处为 在JUC包下的类名不同
        // ConcurrentHashMap

        for (int i=1;i<=10;i++){
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,3));
                    System.out.println(list);
            },""+i).start();
        }
    }
}
