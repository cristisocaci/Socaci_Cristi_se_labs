package edu.tucn.lab6.ex3;

public class Main {
    public static void main(String[] args) {
        edu.tucn.lab6.ex3.Bank bank = new Bank();
        bank.addAccount("nu", 200);
        bank.addAccount("dada", 10);
        bank.addAccount("da", 20);
        bank.printAccounts();
        System.out.println();
        bank.printAccounts(15, 250);
        System.out.println();
        System.out.println(bank.getAccount("da").toString());
    }
}
