package test.chapter04;

public class Test31 {
    public static void main(String[] args) {

        T t = new T();
        System.out.println(t.f("k", 80, 8590));
    }
}
class T {

    public T() {
    }

    public String f(String name, double... score) {
        double total = 0;
        for (int i = 0; i < score.length; i++) {
            total += score[i];
        }
        return "name:" + name + total;
    }
}

