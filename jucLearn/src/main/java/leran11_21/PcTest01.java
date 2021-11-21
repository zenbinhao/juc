package leran11_21;/*
 * @Author: zeng
 * @Data: 2021/11/21 23:37
 * @Description: TODO
 */

//使用synchronized 生产消费

public class PcTest01 {
    public static void main(String[] args) {
        Data data = new Data();
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
class Data{

    private Integer number = 0;

    public synchronized void addNumber(){
        // 判断等待 -> 执行-> 唤醒
        // if判断会造成虚假唤醒 使用while 在等待的时候 被唤醒再次判断  即可防止虚假唤醒
        while(number!=0){
            //线程等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //执行业务
        number++;
        System.out.println(Thread.currentThread().getName()+"线程-->执行后number="+number);
        //唤醒其他线程
        this.notifyAll();
    }
    public synchronized void subNumber(){
        // 判断等待 -> 执行-> 唤醒
        // 判断等待 -> 执行-> 唤醒
        // if判断会造成虚假唤醒 使用while 在等待的时候 被唤醒再次判断  即可防止虚假唤醒
        while(number==0){
            //线程等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //执行业务
        number--;
        System.out.println(Thread.currentThread().getName()+"线程-->执行后number="+number);
        //唤醒其他线程
        this.notifyAll();
    }
}