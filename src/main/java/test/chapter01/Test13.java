package test.chapter01;

public class Test13 {
    public static void main(String[] args) {

        // 求出1-1/2+1/3-1/4…..1/100的和
//        double sum = 0;
//        for (double i = 1, j = 1; j <= 100; j++) {
//            if (j % 2 == 0) {
//                sum -= i/j;
//            }else {
//                sum += i/j;
//            }
//        }
//        System.out.println(sum);

        double sum = 0;
        for(int i = 1; i <= 100; i++) {
            //判断是奇数还是偶数，然后做不同的处理
            if( i % 2 != 0) {//分母为奇数
                sum += 1.0/i;
            } else { //分母我偶数
                sum -= 1.0/i;
            }
        }

        System.out.println("sum=" + sum);
    }
}
