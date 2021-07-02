package test.chapter04;

public class Home04 {
    public static void main(String[] args) {
        A03 a03 = new A03();
        int[] a = {1, 2, 3};
        int[] b = a03.copyArr(a);

        for (int i = 0; i < b.length; i++) {
            System.out.println(b[i]);
        }

    }
}

/*
编写类A03, 实现数组的复制功能copyArr，输入旧数组，返回一个新数组，元素和旧数组一样
 */
class A03 {
    public int[] copyArr(int[] arr) {
        int[] arr01 = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            arr01[i] = arr[i];
        }

        arr = arr01;
        return arr;
    }

}