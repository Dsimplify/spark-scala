package test.chapter01;

public class Test14 {
    public static void main(String[] args) {

        // 求(1)+（1+2）+（1+2+3）+（1+2+3+4）+...+(1+2+3+..+100)的结果
//        int s = 0;
//        int sum = 0;
//        for (int i =1; i <= 100; i++) {
//            s += i;
//            sum += s;
//        }
//
//        System.out.println(sum);

        int sum = 0;
        for(int i = 1; i <= 100; i++) {
            for(int j = 1;j <= i; j++) {//内层对1-i进行循环
                sum += j;
            }
        }
        System.out.println("sum=" + sum);
    }
}
