package test.homework;

public class Homework13 {
    public static void main(String[] args) {
        Teacher01 teacher01 = new Teacher01("ww", '男', 30, 5);
        System.out.println(teacher01.basicInfo());

        Student01 student01 = new Student01("w", '男', 15, 110);
        student01.printInfo();

        Person01[] s = new Person01[3];
        s[0] = teacher01;
        s[1] = student01;
        Homework13 homework13 = new Homework13();
        homework13.test(student01);
    }

    public void test(Person01 p) {
        if (p instanceof Student01) {
            ((Student01) p).study();
        } else if (p instanceof Teacher01){
            ((Teacher01) p).teach();
        } else {
            System.out.println("nothing.....");
        }
    }
}

class Person01 {
    private String name;
    private char sex;
    private int age;

    public Person01(String name, char sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String play(String name) {
       return name + "爱玩";
    }

    public String basicInfo() {
        return "name:" + name + ", sex: " + sex + ", age:" + age;
    }
}

class Student01 extends Person01 {
    private int stu_id;

    public Student01(String name, char sex, int age, int stu_id) {
        super(name, sex, age);
        this.stu_id = stu_id;
    }

    public int getStu_id() {
        return stu_id;
    }

    public void setStu_id(int stu_id) {
        this.stu_id = stu_id;
    }

    public void study() {
        System.out.println("我承诺，我会好好学习");
    }

    @Override
    public String play(String name) {
        return super.play(name) + "足球";
    }

    public void printInfo() {
        System.out.println(super.basicInfo());
        System.out.println(this.stu_id);
        System.out.println(play(this.getName()));
    }
}

class Teacher01 extends Person01 {
    private int work_id;

    public Teacher01(String name, char sex, int age, int work_id) {
        super(name, sex, age);
        this.work_id = work_id;
    }

    public int getWork_id() {
        return work_id;
    }

    public void setWork_id(int work_id) {
        this.work_id = work_id;
    }

    public void teach () {
        System.out.println("我承诺，我会认真教学");
    }

    @Override
    public String play(String name) {
        return super.play(name) + "象棋";
    }

}