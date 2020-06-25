package edu.tucn.Examen;

import java.util.ArrayList;

class Card{
}
class Account{
    Card associatedCard;
    Account(Card c){
        associatedCard = c;
    }
}
class Transaction{
    Account payerAccount;
    Account receiverAccount;
    private int amount;
    Transaction(Account payerAccount, Account receiverAccount, int amount){
        this.payerAccount = payerAccount;
        this.receiverAccount = receiverAccount;
        this.amount = amount;
    }
}
class User{
    ArrayList<Account> userAccounts = new ArrayList<>();

    public User(ArrayList<Account> userAccounts) {
        this.userAccounts = userAccounts;
    }
    public void addAccount(Account a){
        userAccounts.add(a);
    }

    public ArrayList<Account> getUserAccounts() {
        return userAccounts;
    }
}

class Bank{
    ArrayList<User> users = new ArrayList<>();
    ArrayList<Account> accounts = new ArrayList<>();

    public Bank(ArrayList<User> users, ArrayList<Account> accounts) {
        this.users = users;
        this.accounts = accounts;
    }
    public void addUser(User u){
        users.add(u);
        accounts.addAll(u.getUserAccounts());
    }
}



public class ex2 {
    public static void main(String[] args) {

    }
}
