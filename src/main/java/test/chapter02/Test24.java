package test.chapter02;

import jdk.nashorn.api.scripting.ScriptUtils;

public class Test24 {
    public static void main(String[] args) {

        int index = 0;
        int a = 23;
        int[] arr = {10, 12, 45, 90};

        int[] newArr = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > a) {
                index = i;
                //System.out.println(index);
                break;
            }
        }

        for (int i = 0; i < newArr.length ; i++) {
            if (i == index) {
                newArr[i] = a;
            }else if (i > index) {
                newArr[i] = arr[i - 1];
            }else {
                newArr[i] = arr[i];
            }
        }

        arr = newArr;
        for (int i = 0; i < newArr.length; i++) {
            System.out.println(arr[i]);
        }

    }
}
