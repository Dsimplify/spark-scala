package test.chapter01;

import java.util.Scanner;

public class Test19 {
    public static void main(String[] args) {

        // 判断旺季还是淡季
        Scanner scanner = new Scanner(System.in);

        int season = 5;
        int age = 60;
        if (season >= 4 && season <= 10 ) {
            if (age > 18 && age < 60) {
                System.out.println("票价60");
            } else if (age < 18) {
                System.out.println("票价半价");
            }else {
                System.out.println("票价1/3");
            }
        }else {
            if (age > 18 && age < 60) {
                System.out.println("票价40");
            }else {
                System.out.println("票价20");
            }
        }

    }
}
