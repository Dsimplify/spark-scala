package test.chapter01;

public class BubbleSort {
    public static void main(String[] args) {

        // 将五个无序：24,69,80,57,13 使用冒泡排序法将其排成一个从小到大的有序数列
        int[] a = {24,69,80,57,13};
        int temp = 0;
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - 1; j++) {
                if (a[j] > a[j + 1]) {
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }

        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
