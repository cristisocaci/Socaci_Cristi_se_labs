package edu.tucn.lab6.ex3;

import edu.tucn.lab6.ex1.BankAccount;

import java.util.TreeSet;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Bank {
    private TreeSet<BankAccount> accounts = new TreeSet<BankAccount>();

    public void addAccount(String owner, double balance){
        accounts.add(new BankAccount(owner, balance));
    }

    public void printAccounts(){
        accounts.stream().sorted(Comparator.comparingDouble(BankAccount::getBalance))
                        .forEach(System.out::println);
    }
    public void printAccounts(double minBalance, double maxBalance){
        accounts.stream().filter(account -> account.getBalance()>=minBalance && account.getBalance() <= maxBalance)
                .sorted(Comparator.comparingDouble(BankAccount::getBalance))
                .forEach(System.out::println);
    }
    public BankAccount getAccount(String owner){
        return accounts.stream().filter(account->account.getOwner().equals(owner))
                        .collect(Collectors.toList()).get(0);
    }
}
