package test.moneyproject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class HomePage {
    public static void main(String[] args) {

        // 相关的变量
        // 键盘输入命令
        Scanner scanner = new Scanner(System.in);

        // 余额
        double money = 0;
        double balance = 0;

        // 零钱明细 拼接
        String details = " ";

        // 日期
        Date date = null;

        // 循环控制
        boolean loop = true;

        // 日期格式化
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        do {
            System.out.println("----------零钱通菜单----------");
            System.out.println("       1 零钱通明细        ");
            System.out.println("       2 收益入账          ");
            System.out.println("       3 消    费         ");
            System.out.println("       4 退    出        ");

            System.out.println("请选择1-4：");
            int choose = scanner.nextInt();

            switch (choose) {
                case 1:
                    System.out.println("----------零钱通明细----------");
                    System.out.println(details);
                    break;
                case 2:
                    money = scanner.nextDouble();
                    if (money <= 0) {
                        System.out.println("收益需大于0" );
                        break;
                    }
                    date = new Date();
                    balance += money;
                    details = "收益入账 +" + money + "\t" + sdf.format(date) + "\t" + "余额：" + balance;

                    //System.out.println(details);
                    break;
                case 3:
                    money = scanner.nextDouble();
                    if (money <= 0 ) {
                        System.out.println("收益需大于0" );
                        break;
                    }
                    date = new Date();
                    balance -= money;
                    details = details + "\n" + "消费 -" + money + "\t" + sdf.format(date) + "\t" + "余额：" + balance;
                    //System.out.println(details);
                    break;
                case 4:
                    System.out.println("你确定要退出吗？");
                    System.out.println("输入y/n");
                    String c = scanner.next();

                    if ("y".equals(c)) {
                        System.out.println("退出系统");
                        loop = false;
                        break;
                    }

            }
        } while (loop);
    }
}

