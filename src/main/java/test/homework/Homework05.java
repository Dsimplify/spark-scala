package test.homework;

public class Homework05 {
    public static void main(String[] args) {
        Worker worker = new Worker("w", 5000);
        worker.printSal();

        Peasant peasant = new Peasant("p", 4000);
        peasant.printSal();

        Waiter ww = new Waiter("ww", 6000);
        ww.printSal();
    }
}

class Staff {
    private String name;
    private double sal;

    public Staff(String name, double sal) {
        this.name = name;
        this.sal = sal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public void printSal() {
        System.out.println("name=" + name + ", sal=" +sal);
    }
}

class Worker extends Staff{

    public Worker(String name, double sal) {
        super(name, sal);
    }

    public void printSal() {
        System.out.print("工人 ");
        super.printSal();
    }
}

class Peasant extends Staff{

    public Peasant(String name, double sal) {
        super(name, sal);
    }

    @Override
    public void printSal() {
        System.out.print("农民 ");
        super.printSal();
    }
}

class Waiter extends Staff {

    public Waiter(String name, double sal) {
        super(name, sal);
    }

    @Override
    public void printSal() {
        System.out.print("服务生");
        super.printSal();
    }
}
