package test.chapter03;

public class Test27 {
    public static void main(String[] args) {

        int [][] map =  {{0,0,1},{1,1,1},{1,1,3}};
        MyTools tools = new MyTools();
        tools.printArr(map);
    }
}

class MyTools {
    public void printArr(int[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
}
