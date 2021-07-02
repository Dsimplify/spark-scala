package test.chapter01;

import java.util.Scanner;

public class Test18 {
    public static void main(String[] args) {
//
//        // array
//        double[] hen ={3, 5, 10};
//
//        double sum = 0;
//
//        for (int i = 0; i < hen.length; i++ ) {
//            sum += hen[i];
//        }
//
//        System.out.println(sum);

//        double[] hen = new double[5];
//        Scanner scanner = new Scanner(System.in);
//        for (int i = 0; i < hen.length; i++) {
//            hen[i] = scanner.nextDouble();
//        }

//        int[] arr = {1,2,3};
//        int[] arrNew = new int[arr.length + 1];
//        //遍历 arr 数组，依次将arr的元素拷贝到 arrNew数组
//        for(int i = 0; i < arr.length; i++) {
//            arrNew[i] = arr[i];
//        }
//        //把4赋给arrNew最后一个元素
//        arrNew[arrNew.length - 1] = 4;
//        //让 arr 指向 arrNew,
//        arr = arrNew;
//        //输出arr 看看效果
//        System.out.println("====arr扩容后元素情况====");
//        for(int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i] + "\t");
//        }

//        char aa = 97;
//        // 创建一个char类型的26个元素的数组，分别 放置'A'-'Z'。
//        // 使用for循环访问所有元素并打印出来。
//
//        char[] chars = new char[26];
//        for (int i = 0; i < chars.length; i++) {
//            chars[i] = (char)('A' + i) ;
//            System.out.println(chars[i]);
//        }

//        // 请求出一个数组int[]的最大值 {4,-1,9, 10,23}，并得到对应的下标
//        int[] a = {4,-1,9, 10,23};
//        int max = 0;
//        int index = 0;
//        for (int i = 0; i < a.length - 1; i++) {
//            if (a[i] > a[i + 1]) {
//                max = a[i];
//                index = i;
//            }else if (a[i] < a[i + 1]) {
//                max = a[i + 1];
//                index = i + 1;
//            }
//        }
//        System.out.println(index);
//
//        // 翻转
//        int[] arr = {11, 22, 33, 44, 55, 66};
//        int temp = 0;
//        for (int i = 0; i < arr.length / 2; i++) {
//            temp = arr[i];
//            arr[i] = arr[arr.length - i - 1];
//            arr[arr.length - i - 1] = temp;
//        }
//
//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i]);
//        }

        // 翻转
//        int[] arr = {11, 22, 33, 44, 55, 66};
//        int[] arr1 = new int[6];
//
//        for (int i = 0; i < arr.length; i++) {
//            arr1[arr.length - 1 - i] = arr[i];
//        }
//
//        for (int i = 0; i < arr1.length; i++) {
//            System.out.println(arr1[i]);
//        }

        // 已知有个升序的数组，要求插入一个元素，该数组顺序依然是升序, 比如:
        // [10， 12， 45， 90],  添加23 后, 数组为 [10， 12，23， 45， 90]
        int[] a = {10, 12, 45, 90};
        int[] a1 = new int[a.length + 1];

        int index =0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] > 23) {
                index = i;
                break;
            }
        }



        for (int i = 0, j = 0; i < a1.length; i++) {
            if (i != index) {
                a1[i] = a[j];
                j++;
            }else {
                a1[i] = 23;
            }
        }

        a = a1;

        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }




    }
}
