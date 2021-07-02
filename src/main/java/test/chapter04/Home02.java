package test.chapter04;

public class Home02 {
    public static void main(String[] args) {
        String s = "abc";
        String[] a = {"a", "bc", "abc"};
        A02 a02 = new A02();
        a02.find(s, a);

    }
}

//编写类A02，定义方法find，实现查找某字符串是否在字符串数组中，
//并返回索引，如果找不到，返回-1
//分析
//1. 类名 A02
//2. 方法名 find
//3. 返回值 int
//4. 形参 (String , String[])
//
//自己补充代码健壮性
class A02 {
    public int find(String s, String[] a) {

        for (int i = 0; i < a.length; i++) {
            if (s.equals(a[i])) {
                return i;
            }
        }
        return -1;
    }
}
