package leran11_21;/*
 * @Author: zeng
 * @Data: 2021/11/22 0:05
 * @Description: TODO
 */

// 饿汉式(线程安全、无懒加载(延时加载)、若没调用造成内存浪费)
public class Singleton {
    Singleton(){
    }
    private final static Singleton singleton = new Singleton();

    public static Singleton getInstance(){
        return singleton;
    }

}
//饿汉式优缺点同上
class Singleton1{
    Singleton1(){}
    private static Singleton1 singleton1;
    static {
        singleton1 =new Singleton1();
    }
    public static Singleton1 getInstance(){
        return singleton1;
    }
}

//懒汉式双重验证后线程安全(可延时加载、效率高)
class Lazy{
    Lazy(){

    }
    private static Lazy lazy;

    public static Lazy getInstance(){
        if(lazy==null){
            synchronized (Lazy.class){
                if(lazy==null){
                    return lazy =new Lazy();
                }
            }
        }
        return null;
    }
}

//静态内部类饿汉加强版(线程安全、懒加载、高效率)
class Singleton2{
    Singleton2(){}
    private static class GetInstance{
        private static final Singleton2 singleton2 = new Singleton2();
    }
    private static Singleton2 getInstance(){
        return GetInstance.singleton2;
    }
}

//线程安全、防止反射强行调用构造器(不会创建新对象)、提供自动序列化机制(反序列化时也不会创建新对象)
enum Singleton3{
    INSTANCE;
    //然后写需要的方法即可
}
