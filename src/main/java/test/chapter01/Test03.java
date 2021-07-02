package test.chapter01;

import java.util.Scanner;

public class Test03 {
    public static void main(String[] args) {

//        // 从键盘输入
//        Scanner scanner = new Scanner(System.in);
//        // 提示输入范围
//        System.out.println("请输入a~h之间的字母：");
//        // 接收输入的数
//        char s = scanner.next().charAt(0);
//
//        switch (s) {
//            case 97 :
//                System.out.println("星期一");
//                break;
//            case 98 :
//                System.out.println("星期二");
//                break;
//            case 99 :
//                System.out.println("星期三");
//                break;
//            case 100 :
//                System.out.println("星期四");
//                break;
//            case 101 :
//                System.out.println("星期五");
//                break;
//            case 102 :
//                System.out.println("星期六");
//                break;
//            case 103 :
//                System.out.println("星期日");
//                break;
//            default:
//                System.out.println("输入有误");
//        }

//        double a = 1.1;
//
//        // 判断分数合法
//        if (a >=0 && a <= 100) {
//            switch ((int)a / 60) {
//                case 0 :
//                    System.out.println("不及格");
//                    break;
//                case 1 :
//                    System.out.println("及格");
//            }
//        } else {
//            System.out.println("输入有误");
//        }

        //根据用于指定月份，
        //打印该月份所属的季节。
        //3,4,5 春季 6,7,8 夏季  9,10,11 秋季 12, 1, 2 冬季

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入月份");
        int month = scanner.nextInt();

        // 对月份进行判断
        switch (month) {
            case 3:
            case 4:
            case 5:
                System.out.println("春季");
                break;
            case 6:
            case 7:
            case 8:
                System.out.println("夏季");
                break;
            case 9:
            case 10:
            case 11:
                System.out.println("秋季");
                break;
            case 12:
            case 1:
            case 2:
                System.out.println("冬季");
                break;

        }
    }
}
