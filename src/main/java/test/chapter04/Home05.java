package test.chapter04;

public class Home05 {
    public static void main(String[] args) {

        Circle circle = new Circle(10);
        System.out.println(circle.Perimeter());
        System.out.println(circle.Area());
    }
}

/*
定义一个圆类Circle, 定义属性：半径，提供显示圆周长功能的方法， 提供显示圆面积的方法
 */
class Circle {
    double r;

    public Circle(double r) {
        this.r = r;
    }

    public double Perimeter() {
        return Math.PI * 2 * r;
    }

    public double Area() {
        return Math.PI * r * r;
    }
}
