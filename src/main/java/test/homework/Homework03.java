package test.homework;

import jdk.nashorn.api.scripting.ScriptUtils;

public class Homework03 {
    public static void main(String[] args) {
        Professor professor = new Professor("w", 58, "教授", 20000);
        professor.introduce();
    }
}

class Teacher {
    private String name;
    private int age;
    private String post;
    private double salary;

    public Teacher(String name, int age, String post, double salary) {
        this.name = name;
        this.age = age;
        this.post = post;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void introduce() {
        System.out.println("name = " + name + "age = " + age + "post = " + post + "salary = " + salary);
    }
}

class Professor extends Teacher{

    public Professor(String name, int age, String post, double salary) {
        super(name, age, post, salary);
    }

    @Override
    public void introduce() {
        System.out.println("这是教授");
        super.introduce();
    }
}

class AssociateProfessor extends Teacher{

    public AssociateProfessor(String name, int age, String post, double salary) {
        super(name, age, post, salary);
    }

    @Override
    public void introduce() {
        System.out.println("这是副教授");
        super.introduce();
    }
}

class Lecturer extends Teacher{

    public Lecturer(String name, int age, String post, double salary) {
        super(name, age, post, salary);
    }

    @Override
    public void introduce() {
        System.out.println("这是讲师");
        super.introduce();
    }
}