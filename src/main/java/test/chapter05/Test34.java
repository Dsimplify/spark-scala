package test.chapter05;

public class Test34 {
    public static void main(String[] args) {
        Person person = new Person("jack", 50);
        System.out.println(person.say());

        Student student = new Student("smith", 20, 123456, 99.8);
        System.out.println(student.say());
    }
}

class Person {
    private String name;
    private int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
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

    public String say() {
        return "name = " + this.name + "age = " + this.age;
    }
}

class Student extends Person {
    private int id;
    private double score;

    Student(String name, int age, int id, double score) {
        super(name, age);
        this.id = id;
        this.score = score;
    }

    public String say() {
        return super.say() + "id = " + id + "score = " + score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
