package test.chapter01;

import java.util.Scanner;

public class Test16 {
    public static void main(String[] args) {

        // 参加歌手比赛，如果初赛成绩大于8.0进入决赛，
        // 否则提示淘汰。并且根据性别提示进入男子组或女子组。
        // 【可以让学员先练习下】, 输入成绩和性别，进行判断和输出信息。

        Scanner scanner = new Scanner(System.in);

        // 输入分数
        double score = scanner.nextDouble();
        // 输入性别
        char sex = scanner.next().charAt(0);
        if (score > 8.0) {
            System.out.println("晋级决赛");
            if (sex == '男') {
                System.out.println("进入男子组");
            }else if (sex == '女') {
                System.out.println("进入女子组");
            }else {
                System.out.println("输入有误");
            }
        } else {
            System.out.println("很遗憾，你被淘汰");
        }

    }
}
