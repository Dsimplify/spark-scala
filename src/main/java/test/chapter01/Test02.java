package test.chapter01;

import java.util.Scanner;

public class Test02 {
    public static void main(String[] args) {
        // //判断一个年份是否是闰年，闰年的条件是符合下面二者之一：
        // (1)年份能被4整除，但不能被100整除；(2)能被400整除


        Scanner scanner = new Scanner(System.in);
        // 接收输入的数
        int a = scanner.nextInt();

        // 判断条件
        if (a % 4 == 0 && a % 100 != 0 || a % 400 == 0) {
            System.out.println("该年是瑞年");
        }else {
            System.out.println("平年");
        }
    }
}
