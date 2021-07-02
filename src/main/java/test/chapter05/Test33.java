package test.chapter05;

public class Test33 {
    public static void main(String[] args) {
        PC pc = new PC("intel", 16, 500, "IBM");
        pc.Info();

        //NotePad notePad = new NotePad();


    }
}
class Computer {
    private String cpu;
    private double memory;
    private double disk;

    Computer(String cpu, double memory, double disk) {
        this.cpu = cpu;
        this.memory = memory;
        this.disk = disk;
    }

    public String getDetails() {
       return  "该电脑的CPU:" + cpu + ",内存：" + memory + ",硬盘:" + disk;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public double getMemory() {
        return memory;
    }

    public void setMemory(double memory) {
        this.memory = memory;
    }

    public double getDisk() {
        return disk;
    }

    public void setDisk(double disk) {
        this.disk = disk;
    }
}

class PC extends Computer {
    private String brand;


    PC(String cpu, double memory, double disk, String brand) {
        super(cpu, memory, disk);
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void Info() {
        System.out.println(getDetails() + ",brand:" + brand);
    }
}

class NotePad extends Computer {
    private String color;

    NotePad(String cpu, double memory, double disk, String color) {
        super(cpu, memory, disk);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}

