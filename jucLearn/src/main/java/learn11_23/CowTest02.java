package learn11_23;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CowTest02 {
    public static void main(String[] args) {
//         因为需要拿到返回值所以在外面声明 匿名内部类拿不到返回值
//        new Thread(new FutureTask<String>(()->{
//            return null;
//        }));

        //Callable需要通过适配类FutureTask才能通过Thread开启线程
        //且Callable重写的不是run方法 而是call方法

        //适配类的原理是通过实现 Runnable接口 重写run()方法启动线程的业务 以及Future接口  通过重写的run()方法调用call()执行业务后返回值被set()方法存储
        //调用重写的get()获得返回值
        //当多个不同的线程对同一FutureTask对象进行操作时 线程的状态从new开始变化后其他线程会直接被return; 弃用
        FutureTask<String> stringFutureTask = new FutureTask<>(()->{
            System.out.println("我是callable线程");
         return "嘿嘿嘿";
        });
        new Thread(stringFutureTask).start();
        String call=null;
        try {
            call=stringFutureTask.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } finally {
            System.out.println(call);
        }

    }
}
