package test.chapter02;

public class Test30 {
    public static void main(String[] args) {

        // 打印菱形
        //      *
        //   *     *
//        int row = 9;
//        for (int i = 1; i <= row; i++) {
            // 打印空格
//            if (i <= row / 2 + 1) {
//                for (int j = 1; j <= row / 2 - i + 1; j++) {
//                    System.out.print(" ");
//                }
//            } else {
//                for (int j = 1; j <= i - row / 2 - 1; j++ ) {
//                    System.out.print(" ");
//                }
//            }
//
//            // 打印*
//            if (i <= 5) {
//                for (int j = 1; j <= 2 * i - 1; j++ ) {
//                    if(row - i) * 2 + 1 (j == 1 || j == 2 * i - 1) {
//                        System.out.print("*");
//                    } else {
//                        System.out.print(" ");
//                    }
//                }
//            } else {
//                for (int j = 1; j <= (row - i) * 2 + 1; j++ ) {
//                    if (j == 1 || j == (row - i) * 2 + 1) {
//                        System.out.print("*");
//                    } else {
//                        System.out.print(" ");
//                    }
//                }
//            }
//
//            System.out.println();
//            int n = 10;
//            for (int i = 1; i <= row; i++ ) {
//                // 上部分
//                if (i <= row / 2 + 1) {
//                    // 打印空格
//                    for (int j = 1; j <= row / 2 + 1 - i; j++) {
//                        System.out.print(" ");
//                    }
//
//                    // 打印*
//                    for (int j = 1; j <= 2 * i - 1; j++) {
//                        if (j == 1 || j == 2 * i - 1) {
//                            System.out.print("*");
//                        } else {
//                            System.out.print(" ");
//                        }
//
//                    }
//                } else {//下部分
//                    for (int j = 1; j <= i - row / 2 - 1 ; j++) {
//                        System.out.print(" ");
//                    }
//                    for (int j = 1; j <= (row - i) * 2 + 1; j++) {
//                        if (j == 1 || j == (row - i) * 2 + 1) {
//                            System.out.print("*");
//                        } else {
//                            System.out.print(" ");
//                        }
//
//                    }
//                }
//                System.out.println();
//            }

        // n为上半个菱形的层数
//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= (n - i); j++)
//                System.out.print(" ");
//            // 打印*的个数
//            if (i == 1)
//                System.out.print("*");
//            else {
//                System.out.print("*");
//                // 打印菱形里的空格
//                for (int j = 1; j <= (2 * i - 3); j++)
//                    System.out.print(" ");
//                System.out.print("*");
//            }
//            System.out.println();
//        }
//
//        // 打印下半部分
//        for (int i = n - 1; i > 0; i--) {
//            for (int j = 1; j <= (n - i); j++)
//                System.out.print(" ");
//            // 打印*的个数
//            if (i == 1)
//                System.out.print("*");
//            else {
//                System.out.print("*");
//                // 打印菱形里的空格
//                for (int j = 1; j <= (2 * i - 3); j++)
//                    System.out.print(" ");
//                System.out.print("*");
//            }
//            System.out.println();
//        }
        // 上部分
        int n = 9; // 菱形的层数
        for (int i = 1; i <= n; i++) {
            // 打印空格
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }

            // 打印*
            for (int j = 1; j <= 2 * i - 1; j++) {
                if (j == 1 || j == 2 * i - 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }

            System.out.println();
        }

        // 下部分
        for (int i = n; i > 0 ; i--) {
            // 打印空格
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }

            // 打印*
            for (int j = 1; j <= 2 * i - 1; j++) {
                if (j == 1 || j == 2 * i - 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }

            System.out.println();
        }
    }
}
