package test.chapter01;

import java.math.BigDecimal;
import java.util.Scanner;

public class Test15 {
    public static void main(String[] args) {

//        for(int i = 0; i < 2; i++) { //先思考
//            for( int j = 0; j < 3; j++) {
//                System.out.println("i=" + i + "j=" + j);
//            }
//        }

        // 统计3个班成绩情况，每个班有5名同学，
        // 求出各个班的平均分和所有班级的平均分[学生的成绩从键盘输入]。
        // 统计三个班及格人数，每个班有5名同学。

        Scanner scanner = new Scanner(System.in);

//        for (int i = 1; i <= 3; i++) {
//            System.out.println(i + "班5名同学成绩：");
//            double a1 = scanner.nextDouble();
//            double a2 = scanner.nextDouble();
//            double a3 = scanner.nextDouble();
//            double a4 = scanner.nextDouble();
//            double a5 = scanner.nextDouble();
//            double avg = (a1 + a2 + a3 + a4 + a5) / 5;
//            System.out.println(i + "班平均分：" + avg);
//        }

        double sum = 0;
        int pass = 0;
        for (int i = 1; i <= 3; i++) {
            double s = 0;
            for (int j = 1; j <= 5; j++) {
                System.out.println("请输入" + i + "班第" + j + "个同学分数：");
                double score = scanner.nextDouble();
                if (score > 60) {
                    pass++;
                }
                s += score;
            }

            System.out.println(i + "班平均分：" + (s / 5));
            System.out.println(i + "班及格人数" + pass);
            sum += s;
        }

        System.out.println("3个班的平均分：" + (sum / 3));

    }
}
