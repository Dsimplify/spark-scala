package test.chapter01;

public class Test06 {
    public static void main(String[] args) {

        // do while
//        int i = 0;
//        do {
//            System.out.println("yo");
//            i++;
//        } while (i < 10);
//
        // 统计1---200之间能被5整除但不能被3整除的 个数
//        int i = 1;
//        int count = 0;
//        do {
//            if (i % 5 == 0 && i % 3 != 0) {
//                count++;
//            }
//            i++;
//        } while (i <= 200);
//        System.out.println(count);
        // 1-100以内的数求和，求出 当和 第一次大于20的当前数
//        int a = 1;
//        int sum = 0;
//        do {
//            sum += a;
//            if (sum > 20) {
//                System.out.println(a);
//                break;
//            }
//            a++;
//        } while (a <= 100);
        int sum = 0; //累积和

        //注意i 的作用范围在 for{}
        int n = 0;
        for (int i = 1; i <= 100; i++) {
            sum += i;//累积
            if (sum > 20) {
                System.out.println("和>20时候 当前数i=" + i);
                n = i;
                break;
            }
        }
    }
}
