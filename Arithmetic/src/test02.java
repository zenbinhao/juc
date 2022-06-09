import java.util.Scanner;

public class test02 {
    public static void main(String []agrs){
        Scanner sc = new Scanner(System.in);
        String next = sc.nextLine();
        System.out.println(next);
        String s = sc.nextLine();
        outPut(Integer.valueOf(next.split(" ")[0]),Integer.valueOf(next.split(" ")[1]),next.split(" ")[2],s);
    }
    public static void outPut(Integer n,Integer k,String s,String ss){
        //n为长度
        //k为需要字串只能存在字符s的个数
        //s为子串
        //ss 总串
        if(k == 1) {
            //全为一样的字符情况
            if (ss.replaceAll(s,"").equals("")){
                System.out.println(ss.length());
                return;
            }
            //不一样
            int temp = 0;
            int record = 0;
            String[] split = ss.split(s);
            for (int i = 0; i < n; i++) {
                if (split[i].equals(s)) {

                }
            }
        }
    }
}
// c b b b c
// abababa

/*
* a
* 1
* aa
* 2
* aaa
* 3
*
* ab
*
* abc
*
*
*
*
*
*
*
*
* */