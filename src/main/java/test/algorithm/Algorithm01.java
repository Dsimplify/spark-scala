package test.algorithm;

import java.util.Scanner;

public class Algorithm01 {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个数:");
        long number = scanner.nextLong();

        // 在静态方法中不能访问类的非静态成员变量和非静态成员方法，
        // 因为非静态成员方法/变量都是必须依赖具体的对象才能够被调用。
        System.out.println(primeFactors(number));


    }

    /**
     * 求最大质因数
     * 思路：通过不断的递归调用，判断number是否为质数
     * @param number
     * @return
     */
    public static long primeFactors(long number) {
        if (number == 1) {
            return 1;
        }
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return primeFactors(number / i );
            }
        }
        return number;
    }
}
