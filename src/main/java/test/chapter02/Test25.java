package test.chapter02;

import java.util.Random;

public class Test25 {
    public static void main(String[] args) {

        /*
		    随机生成10个整数(1_100的范围)保存到数组，
		    并倒序打印以及求平均值、求最大值和最大值的下标、
		    并查找里面是否有 8  Homework05.java
		*/
        int[] arr = new int[10];
        int sum = 0;
        int max = 0;

        int maxIndex = 0;
        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * 100) + 1;
            System.out.print(arr[i] + "\t");
            sum += arr[i];
            if (arr[i] == 8) {
                System.out.print("找到了");
            }
        }
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            if (max <= arr[i]) {
                max = arr[i];
                maxIndex = i;
            }
        }

        System.out.println(sum / arr.length);
        System.out.println(maxIndex);
    }
}
