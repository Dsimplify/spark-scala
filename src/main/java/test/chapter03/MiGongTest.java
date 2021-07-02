package test.chapter03;

import javax.sound.midi.Soundbank;

public class MiGongTest {
    public static void main(String[] args) {

        // 1：障碍  0：可以走 2：走过 3：走过 但走不通
        // 迷宫的四周为1
        int[][] map = new int[7][8];


        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                // 上下 1
                if (i == 0) {
                    map[0][j] = 1;
                    map[6][j] = 1;
                }
                // 左右 1
                if (j == 0) {
                    map[i][0] = 1;
                    map[i][7] = 1;
                }
            }
        }

        map[3][1] = 1;
        map[3][2] = 1;
        map[2][2] = 1;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        Tmg tmg = new Tmg();
        tmg.findWay(map, 1 ,1);

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

    }
}

class Tmg {
    //
    // 下->右->上->左 ==> 上->右->下->左
    public boolean findWay(int[][] map, int a, int b) {
        if (map[5][6] == 2) {
            return true;
        } else {
            if (map[a][b] == 0) {
                map[a][b] = 2;
                if (findWay(map, a + 1, b)) {
                    return true;
                } else if (findWay(map, a,b + 1)) {
                    return true;
                } else if (findWay(map, a -1, b)) {
                    return true;
                } else if (findWay(map, a, b - 1)) {
                    return true;
                } else {
                    map[a][b] = 3;
                    return false;
                }
            } else {
                return false;
            }
        }
    }

}
