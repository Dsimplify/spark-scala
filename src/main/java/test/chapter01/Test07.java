package test.chapter01;

import java.util.Scanner;

public class Test07 {
    public static void main(String[] args) {

        // 实现登录验证，有3次机会，如果用户名为"丁真" ,密码"666"提示登录成功，
        // 否则提示还有几次机会，请使用for+break完成
        // 从键盘输入
        Scanner scanner = new Scanner(System.in);


        for (int i = 3; i > 0; i--) {
            // 账号
            System.out.println("请输入账号：");
            String account = scanner.next();

            // 密码
            System.out.println("请输入密码：");
            String pw = scanner.next();
            if ("丁真".equals(account) && "666".equals(pw)) {
                System.out.println("登录成功");
                break;
            } else {
                System.out.println("登录失败");
                System.out.println("你还有" + (i - 1) + "次机会");
            }

        }
    }
}
