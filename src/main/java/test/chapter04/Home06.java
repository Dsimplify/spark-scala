package test.chapter04;

public class Home06 {
    public static void main(String[] args) {
        Cale cale = new Cale(2, 10);
        System.out.println(cale.add());
        System.out.println(cale.reduce());
        System.out.println(cale.multiply());
        System.out.println(cale.divide());

    }
}

/*
 编程创建一个Cale计算类，在其中定义2个变量表示两个操作数，
 定义四个方法实现求和、差、乘、商(要求除数为0的话，要提示) 并创建两个对象，分别测试
 */
class Cale {
    double num1;
    double num2;

    public Cale(double num1, double num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    // 加
    public double add() {
        return num1 + num2;
    }

    // 减
    public double reduce() {
        return num1 - num2;
    }

    // 乘
    public double multiply() {
        return num1 * num2;
    }

    // 除
    public double divide() {
        if (num2 == 0) {
            System.out.println("除数为0");
        }
        return num1 / num2;
    }
}