package test.chapter05;

public class Account {
    private String name;
    private double money;
    private String pwd;

//    public Account(String name, double money, String pwd) {
//        this.name = name;
//        this.money = money;
//        this.pwd = pwd;
//    }

    public void setName(String name) {
        if (this.name.length() == 2
                || this.name.length() == 3
                || this.name.length() == 4) {
            this.name = name;
        } else {
            System.out.println("名字输入有误");
            this.name = "空白";
        }
    }

    public  String getName() {
        return this.name;
    }

    public void setMoney(double money) {
        if (money > 20) {
            this.money = money;
        } else {
            System.out.println("金额不能少于20");
            this.money = 21;
        }
    }

    public void setPwd(String pwd) {
        if (pwd.length() == 6) {
            this.pwd = pwd;
        } else  {
            System.out.println("密码不能少于6位");
            this.pwd = "000000";
        }
    }

    public void print() {
        System.out.println(this.name + "的金额还有" + this.money + "密码" + pwd);
    }

    public Account() {
    }

    public Account(String name, double money, String pwd) {
        this.name = name;
        this.money = money;
        this.pwd = pwd;
    }
}

class AccountTest {
    public static void main(String[] args) {
        Account account = new Account("划划水", 25, "123456");
        account.print();
    }

}
