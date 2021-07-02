package test.chapter01;

import java.util.Scanner;

public class Test10 {
    public static void main(String[] args) {

        // 当现金>50000时,每次交5%
        // 2) 当现金<=50000时,每次交1000
        // 编程计算该人可以经过多少次路口, 要求: 使用 while + break方式完成某人有100,000元,每经过一次路口，需要交费,规则如下
//        double money = 100000;
//        int count = 0;
//
//        while (true) {
//            if (money > 50000) {
//                money -= money * 0.05;
//                count++;
//            }else if (money >= 1000 && money <= 50000) {
//                money -= 1000;
//                count++;
//                System.out.println(money);
//            }else if (money < 1000) {
//                break;
//            }
//        }
//        System.out.println(count);

        // 判断一个整数是否是水仙花数，所谓水仙花数是指一个3位数，
        // 其各个位上数字立方和等于其本身。

        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int a1 = a / 100;              // 百位
        int a2 = a / 10 % 10 ;         // 十位
        int a3 = a % 10;               // 个位

        if (a == a1 * a1 * a1 + a2 * a2 * a2 + a3 * a3 * a3) {
            System.out.println("该数是水仙花数");
        }else {
            System.out.println("该数不是水仙花数");
        }


    }
}
