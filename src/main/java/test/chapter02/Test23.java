package test.chapter02;

public class Test23 {
    public static void main(String[] args) {
        /*
		使用二维数组打印一个 10 行杨辉三角
		1
		1 1
		1 2 1
		1 3 3  1
		1 4 6  4  1
		1 5 10 10 5 1


		 */
        int[][] arr = new int[10][];
        for (int i = 0; i < arr.length; i++) {

            // *****给每个一维数组(行) 开空间
            arr[i] = new int[i + 1];


            for (int j = 0; j <= i; j++) {
                if (j == 0 || i == j) {
                    arr[i][j] = 1;
                }else {
                    arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
                }

            }
        }

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(arr[i][j]);

            }
            System.out.println();
        }


    }
}
