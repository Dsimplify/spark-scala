package test.homework;

public class Homework04 {
    public static void main(String[] args) {
        Manager manager = new Manager("w", 500, 20, 1.2);
        manager.printSalary();
    }
}

/**
 * 员工类
 */
class Employee {
    private String name;
    private double day_salary;
    private int days;
    private double level;

    public Employee(String name, double day_salary, int days, double level) {
        this.name = name;
        this.day_salary = day_salary;
        this.days = days;
        this.level = level;
    }

    public double getLevel() {
        return level;
    }

    public void setLevel(double level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDay_salary() {
        return day_salary;
    }

    public void setDay_salary(double day_salary) {
        this.day_salary = day_salary;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public void printSalary() {
        System.out.println("name的工资是" + days * day_salary);
    }
}


/**
 * 部门经理类
 */
class Manager extends Employee{
    private double bound = 1000;

    public Manager(String name, double day_salary, int days, double level) {
        super(name, day_salary, days, level);
    }

    @Override
    public void printSalary() {
        System.out.println("经理的工资=" + (this.bound + getDay_salary() * getDays() * getLevel()));
    }
}

/**
 * 普通员工类
 */
class Worker01 extends Employee{

    public Worker01(String name, double day_salary, int days, double level) {
        super(name, day_salary, days, level);
    }
}
