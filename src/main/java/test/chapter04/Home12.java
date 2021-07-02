package test.chapter04;

public class Home12 {
    public static void main(String[] args) {

    }
}

/*
创建一个Employee类，
属性有(名字，性别，年龄，职位，薪水)， 提供3个构造方法，可以初始化
(1) (名字，性别，年龄，职位，薪水),
(2) (名字，性别，年龄) (3) (职位，薪水), 要求充分复用构造器
*/

class  Employee {
    String name;
    char sex;
    int age;
    String position;
    double salary;

    public Employee(String name, char sex, int age, String position, double salary) {
        this.name = name;
        this.sex = sex;
        this.age =age;
        this.position = position;
        this.salary = salary;
    }

    public Employee(String name, char sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age =age;
    }

    public Employee(String position, double salary) {
        this.position = position;
        this.salary = salary;
    }
}