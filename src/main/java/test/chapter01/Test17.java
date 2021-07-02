package test.chapter01;

import org.codehaus.jackson.annotate.JacksonAnnotation;

public class Test17 {
    public static void main(String[] args) {

        // 外层循环
        for (int i = 1; i < 10; i++) {

//            // 内层
//            // 打印空格
//            for (int j = 1; j <= 9 - i; j++) {
//
//                System.out.print(" ");
//            }

            // 打印 *
            for (int j = 1; j <= 2 * i - 1; j++) {
                if (j == 1 || j == 2 * i - 1 || i == 9) {
                    System.out.print("*");
                }else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
