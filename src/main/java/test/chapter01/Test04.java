package test.chapter01;

public class Test04 {
    public static void main(String[] args) {

//        // for循环
//        for (int i = 1; i < 10; i++ ) {
//            System.out.println("yo");
//        }
//
//        int count = 3;
//        for (int i = 0,j = 0;  i < count; i++, j += 2) {
//            System.out.println("i=" + i + " j=" + j);
//        }

        //  0 0 1 2
        //  1 2 2 4
        //  2 4 3 6


        // 打印1~100之间所有是9的倍数的整数，统计个数及总和.
//        int count = 0;
//        int sum = 0;
//
//        for (int i = 1; i < 101; i++) {
//            if (i % 9 == 0) {
//                count++;
//                sum += i;
//            }
//        }

//        int count = 0; //统计9的倍数个数 变量
////        int sum = 0; //总和
////        int start = 1;
////        int end = 100;
////        int t = 9; // 倍数
////        for(int i = start; i <= end; i++) {
////            if( i % t == 0) {
////                System.out.println("i=" + i);
////                count++;
////                sum += i;//累积
////            }
////        }
////
////        System.out.println(count);
////        System.out.println(sum);


        int n = 9;
        for( int i = 0; i <= n; i++) {
            System.out.println(i + "+" + (n-i) + "=" + n);
        }
    }
}
