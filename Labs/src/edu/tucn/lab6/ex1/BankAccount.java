package edu.tucn.lab6.ex1;

import java.util.Objects;

public class BankAccount {
    private String owner;
    private double  balance;

    public BankAccount(String owner, double balance) {
        this.owner = owner;
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankAccount that = (BankAccount) o;
        return Double.compare(that.balance, balance) == 0 &&
                Objects.equals(owner, that.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(owner, balance);
    }

    public void withdraw(double amount){
        if(amount < 0)
            System.out.println("Enter a valid amount");
        else if(balance - amount < 0)
            System.out.println("Insufficient funds");
        else
            balance -= amount;
    }

    public void deposit(double amount){
        if(amount < 0)
            System.out.println("Enter a valid amount");
        else
            balance += amount;
    }

    public String getOwner() {
        return owner;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "owner='" + owner + '\'' +
                ", balance=" + balance +
                '}';
    }
}
