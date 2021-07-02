package test.chapter04;

public class Home01 {
    public static void main(String[] args) {

        // 编写类A01，定义方法max，实现求某个double数组的最大值，并返回i
        double[] a = {25, 60, 21, 33, 22, 666};
        A01 a01 = new A01();
        double max  = a01.findMax(a);
        System.out.println(max);
    }
}

class A01 {
    public Double findMax(double[] arr) {
        if (arr != null && arr.length > 0) {
            double max = arr[0];
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] > max) {
                    max = arr[i];
                }
            }
            return max;
        } else {
            return null;
        }

    }
}
