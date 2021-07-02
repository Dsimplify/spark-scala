package test.homework;

public class Homework08 {
}

class BankAccount {
    private double balance ;//余额
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }
    //存款
    public void deposit(double amount)  {
        balance += amount;
    }
    //取款
    public void withdraw(double amount)  {
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

class CheckingAccount extends BankAccount{

    public CheckingAccount(double initialBalance) {
        super(initialBalance);
    }

    // 存款
    @Override
    public void deposit(double amount) {
        super.deposit(amount - 1);
    }

    // 取款
    @Override
    public void withdraw(double amount) {
        super.withdraw(amount - 1);
    }
}

class SavingsAccount extends BankAccount{

    private double interest;
    private int count = 3;
    private double rate = 0.01;

    public SavingsAccount(double initialBalance) {
        super(initialBalance);
    }

    public void earnMonthlyInterest() {
        count = 3;
        super.deposit(getBalance() * rate);
    }

    @Override
    public void deposit(double amount) {
        if (count > 0) {
            super.deposit(amount);
        } else {
            super.deposit(amount - 1);
        }
        count--;
    }

    @Override
    public void withdraw(double amount) {
        super.withdraw(amount);
    }
}