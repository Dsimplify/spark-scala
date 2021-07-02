package test.chapter04;

import java.util.Random;
import java.util.Scanner;

public class Home14 {
    public static void main(String[] args) {
        // 输入用户的选择
        int totalcount = 0;
        Scanner scanner = new Scanner(System.in);
        Play player = new Play();
        for (int i = 0; i < 3; i++) {
            System.out.println("请输入0~2之间的数字：");
            int num = scanner.nextInt();

            String s = player.playGame();

            player.winCount(s);
        }
        System.out.println("赢的次数" + totalcount);
    }
}

class Play {
    int playerNum; // 玩家出拳
    int computerNum; // 电脑出拳
    int count;// 赢的次数


    // 电脑出拳
    public int getComputerNum() {
        Random random = new Random(3);
        this.computerNum = random.nextInt();
        return this.computerNum;
    }

    // 0：石头   1：剪刀    2：布
    //
    public String playGame() {
        if (playerNum == 0 && computerNum == 1) {
            return  "你赢了";

        } else if (playerNum == 1 && computerNum == 2) {
            return  "你赢了";

        } else if (playerNum == 2 && computerNum == 0) {
            return  "你赢了";

        } else if (playerNum == computerNum) {
            return "平局";
        } else {
            return "你输了";
        }
    }

    public int winCount(String s) {
        count++;
        if ("你赢了".equals(s)) {
            return count++;
        }
        return count;
    }
}
