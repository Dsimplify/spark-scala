package test.chapter01;

import java.util.Scanner;

public class Test22 {
    public static void main(String[] args) {
//        int[] arr = {11, 22, 33, 44, 55, 66};
//
//        int[] arr2 = new int[arr.length];
//        //逆序遍历 arr
//        for(int i = arr.length - 1, j = 0; i >= 0; i--, j++) {
//            arr2[j] = arr[i];
//        }
//        //4. 当 for 循环结束，arr2 就是一个逆序的数组 {66, 55, 44,33, 22, 11}
//        //5. 让 arr 指向 arr2 数据空间, 此时 arr 原来的数据空间就没有变量引用
//        // 会被当做垃圾，销毁
//        //arr = arr2;
//        System.out.println("====arr 的元素情况=====");
//        //6. 输出 arr 看看
//        for(int i = 0; i < arr2.length; i++) {
//            System.out.print(arr2[i] + "\t");

//        }

         // 有一个数组 {1， 2， 3， 4， 5}， 可以将该数组进行缩减，提示用户是否继续缩减，每次缩减最后那个元素。
         // 当只剩 下最后一个元素，提示，不能再缩减。

        // 思路：
        // 1. 引入scanner类
        // 2. do...while循环
        // 3. 输入提示
        // 4. 判断输入结果
        Scanner scanner = new Scanner(System.in);

        int[] a = {1, 2, 3, 4, 5};
        do {
            System.out.println("是否继续缩减 y/n");
            char c = scanner.next().charAt(0);

            // 判断是否继续缩减
            if (c == 'y') {
                int[] b = new int[a.length - 1];

                for (int i = 0; i < a.length - 1; i++) {
                    b[i] = a[i];
                }
                a = b;

                // 打印缩减后的a
                for (int i = 0; i < a.length; i++) {
                    System.out.println(a[i]);
                }

                // 判断是否只剩一个元素
                if (a.length == 1) {
                    System.out.println("不能再缩减了");
                    break;
                }
            }else {
                System.out.println("退出循环");
                break;
            }
        }while (true);

//
    }
}
