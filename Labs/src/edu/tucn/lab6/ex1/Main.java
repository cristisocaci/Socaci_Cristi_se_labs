package edu.tucn.lab6.ex1;

public class Main {
    public static void main(String[] args) {
        BankAccount b = new BankAccount("Cristi", 2000);
        BankAccount c = new BankAccount("Cristi", 2000);

        System.out.println(c.equals(b));
    }
}
