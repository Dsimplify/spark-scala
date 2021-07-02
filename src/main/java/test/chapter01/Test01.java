package test.chapter01;

import java.util.Scanner;

public class Test01 {
    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);
        // 接受用户输入
        System.out.println("请输入信用分：");
        int a = myScanner.nextInt();

        // 对输入的信用分进行范围判断
        if (a >=1 && a <= 100) {
            // 对信用分进行数值判断
            if (a == 100) {
                System.out.println("信用极好");
            }else if (a > 80 && a <= 99) {
                System.out.println("信用优秀");
            }else if (a >= 60 && a <= 80) {
                System.out.println("信用一般");
            }else {
                System.out.println("信用 不及格");
            }
        }else {
            System.out.println("输入有误，请重试");
        }
    }
}
