package test.chapter01;

public class Test05 {
    public static void main(String[] args) {

        // while
        // 打印1―100之间所有能被3整除的数
//        int i = 1;
//        while (i < 101) {
//            if (i % 3 == 0) {
//                System.out.println(i);
//            }
//            i++;
//        }

        // 打印40―200之间所有的偶数
        int i = 40;

        while (i >= 40 && i <= 200) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
            i++;
        }
    }
}
