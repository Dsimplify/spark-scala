package test.chapter03;

public class Test26 {
    public static void main(String[] args) {

        // 1) 编写类 AA ，有一个方法：判断一个数是奇数 odd 还是偶数, 返回 boolean
        // 2) 根据行、列、字符打印 对应行数和列数的字符，比如：行：4，列：4，字符#,则打印相应的效果
        AA01 aa = new AA01();
        if (aa.isOdd(2)) {
            System.out.println("偶数");
        }else {
            System.out.println("奇数");
        }

        aa.print(4,4,'?');


    }
}

class AA01 {
    public boolean isOdd(int a) {
        if (a % 2 == 0) {
            return true;
        }else {
            return false;
        }
    }

    public void print(int row, int col, char c) {
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
}



