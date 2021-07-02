package test.algorithm;

import java.lang.management.MemoryUsage;

public class Algorithm02 {
    /**
     * 求最大回文乘积
     * @return
     */
    public static int bigPalindrome() {

        int num1 = 0;
        int num2 = 0;
        for (int i = 999; i > 0 ; i--) {
            for (int j = 999; j > 0; j--) {
                num1 = i * j;
                if (num1 > num2 && palindrome(num1)) {
                    num2 = num1;
                }
            }
        }
        return num2;
    }

    /**
     * 判断是否是回文数
     * @param num
     * @return
     */
    public static boolean palindrome(int num) {
        int flag = 0;
        int bit[] = new int[10];

        while (num != 0) {
            bit[flag++] = num % 10;
            num = num / 10;
        }

        for (int i = 0; i < flag; i++) {
            if (bit[i] == bit[flag - 1 - i]) {
                return true;
            }
        }
        return false;
    }
}

