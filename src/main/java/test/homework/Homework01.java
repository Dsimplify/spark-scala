package test.homework;

public class Homework01 {
    public static void main(String[] args) {
        Person[] people = new Person[3];
        people[0] = new Person("x", 20, "java");
        people[1] = new Person("y", 25, "python");
        people[2] = new Person("z", 22, "php");

        for (int i = 0; i < people.length; i++) {
            for (int j = 0; j < people.length - 1; j++) {
                Person temp = null;
                if (people[j].age < people[j + 1].age) {
                    temp = people[j];
                    people[j] = people[j + 1];
                    people[j + 1] = temp;
                }
            }
        }

        for (int i = 0; i < people.length; i++) {
            System.out.println(people[i].name);
        }



    }
}

class Person {
    String name;
    int age;
    String job;

    public Person(String name, int age, String job) {
        this.name = name;
        this.age = age;
        this.job = job;
    }

}

