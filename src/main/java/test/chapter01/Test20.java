package test.chapter01;

import java.util.Scanner;

public class Test20 {
    public static void main(String[] args) {

        // 如果李三不还钱，则老韩将一直使出五连鞭，直到李三说还钱为止

        Scanner scanner = new Scanner(System.in);


        char answer = ' ';
        do {
            System.out.println("打");
            System.out.println("是否还钱，y/n");
            answer = scanner.next().charAt(0);
        }while (answer != 'y');

    }
}
