package test.chapter03;

public class Test28 {

    //编写一个main方法
    public static void main(String[] args) {

        T03 t = new T03();

        int a = t.sum(8);
        if(a != -1) {
            System.out.println(" 对应的斐波那契数=" + a);
        }

        System.out.println(t.peach(0));
    }
}

class T03 {
    public int sum(int n){
        if (n >= 1) {
            if (n == 1 || n == 2) {
                return 1;
            }else {
                return sum(n - 1) + sum(n - 2);
            }
        }else {
            System.out.println("输入有误");
            return -1;
        }
    }

    public int peach(int day) {
        if (day == 10) {
            return 1;
        } else if (day >= 1 && day <= 9) {
            return (peach(day - 1 )  + 1) * 2;
        } else {
            return -1;
        }
    }
}

