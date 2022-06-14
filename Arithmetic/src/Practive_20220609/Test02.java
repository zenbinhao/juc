package Practive_20220609;/*
 * @Author: zeng
 * @Data: 2022/6/9 22:27
 * @Description: TODO
 */

import java.util.Scanner;

public class Test02 {
    public static void main(String[] args) {
        boolean flag = true;
        Scanner scanner = new Scanner(System.in);
        CustomQue customQue =new CustomQue(4);
        while (flag){
            int next = scanner.nextInt();
            switch (next){
                case 0:
                    flag = false;
                    break;
                case 1:
                    int value = scanner.nextInt();
                    System.out.println(customQue.add(value));
                    break;
                case 2:
                    System.out.println(customQue.get());
                    break;
            }
        }
    }
}
class CustomQue{
   private int []a;
   private int real = 0;
   private int font = 0;
   private int max = 0;
   private boolean isEmpty = true;
    private boolean isFull = false;
    public CustomQue(int num){
       a=new int[num];
       max = num;
   }

   public boolean add(int value){
       // 判断队列是否满
       if(isFull && real == font){
           System.out.println("数组已满");
           return false;
       }
       // 赋值
       a[real]=value;
       // real指针移动
       real++;
       real=real%max;
       if(real==font){
           isFull = true;
       }
       isEmpty = false;
       return true;
   }
   public int get(){
       // 判断是否为空
       if(isEmpty){
           System.out.println("数组已空不能拿");
           return -1;
       }
       int aaa = a[font];
       a[font] = 0;
       font++;
       font=font%max;
       if(font==real){
           isEmpty = true;
       }
       isFull = false;
       return aaa;
   }


}
