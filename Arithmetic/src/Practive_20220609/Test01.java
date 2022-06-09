package Practive_20220609;/*
 * @Author: zeng
 * @Data: 2022/6/9 20:34
 * @Description: 稀疏数组
 */

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Test01 {

    public static void main(String[] args) throws IOException, InterruptedException {
        // 创建一个原始的 二维数组
        int[][] ints = new int[11][11];
        ints[1][2] = 1;
        ints[2][3] = 2;
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[0].length; j++) {
                System.out.print("\t"+ints[i][j]);
            }
            System.out.println("");
        }


        // 转成稀疏数组
        System.out.println("二维转->稀疏数组=======================");
        // 先记录非零的个数即可建立 稀疏数组
        int sum = 0;
        for (int[] anInt : ints) {
            for (int i : anInt) {
                if(i!=0){
                    sum++;
                }
            }
        }
        int array[][]=new int[sum+1][3];
        array[0][0]=11;
        array[0][1]=11;
        array[0][2]=sum;
        int count = 1;
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[0].length; j++) {
                if(ints[i][j]!=0){
                    array[count][0]=i;
                    array[count][1]=j;
                    array[count][2]=ints[i][j];
                    count++;
                }
            }
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.print("\t"+array[i][j]);
            }
            System.out.println("");
        }

        File file = new File("D://1.txt");
        if (!file.exists()){
            boolean newFile = file.createNewFile();
            System.out.println(newFile==true?"成功创建文件":"失败的创建文件");
        }
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8);
        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
        for (int i = 0; i < array.length; i++) {
            bufferedWriter.write(array[i][0]+" "+array[i][1]+" "+array[i][2]);
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
        outputStreamWriter.close();

        Thread.sleep(3000);
//        FileInputStream inputStreamReader = new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8);
//        String aaa = "";
//        if(inputStreamReader.read()!=-1){
//            aaa = ""+inputStreamReader.read();
//        }
//        System.out.println(aaa);
//        inputStreamReader.close();
        FileInputStream fileInputStream = new FileInputStream(file);
        BufferedReader br = new BufferedReader(new InputStreamReader(fileInputStream,StandardCharsets.UTF_8));
        ArrayList<String> strings = new ArrayList<>();
        String sss=null;
        while ((sss=br.readLine())!=null){
            strings.add(sss);
            System.out.println(sss);
        }
        br.close();
        fileInputStream.close();
        if (strings.size()!=0) {
            int row = strings.size();
            int col = strings.get(0).split(" ").length;
            int gogo[][] = new int[row][col];
            for (int i = 0; i < strings.size(); i++) {
                String[] s = strings.get(i).split(" ");
                for (int j = 0; j < s.length; j++) {
                    gogo[i][j] = Integer.parseInt(s[j]);
                }
            }
            System.out.println("读取到文件的里的是什么===========");
            for (int i = 0; i < gogo.length; i++) {
                for (int j = 0; j < gogo[0].length; j++) {
                    System.out.print("\t"+gogo[i][j]);
                }
                System.out.println("");
            }
        }


        System.out.println("稀疏数组转->二维=======================");

        int[][] a = new int[array[0][0]][array[0][1]];
        int b = array[0][2];
        for (int i = 1; i < array.length; i++) {
            a[array[i][0]][array[i][1]]=array[i][2];
            b--;
            if (b==0){
                break;
            }
        }

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print("\t"+a[i][j]);
            }
            System.out.println("");
        }
    }
}
