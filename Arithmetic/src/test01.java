import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test01 {

    public static void main(String []agrs){
        Scanner sc = new Scanner(System.in);
        System.out.println(outPut(sc.nextInt()));
    }
    public static int outPut(Integer value){
        String s = Integer.toHexString(value);
        int temp = 0;
        for (int i = 0; i<s.length(); i++){
            if(s.charAt(i)>57||s.charAt(i)<48){
                temp++;
            }
        }
        return temp;
    }
}


