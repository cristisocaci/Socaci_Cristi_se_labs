package edu.tucn.lab5.ex2;

public class Main {
    public static void main(String[] args) {
        ProxyImage p = new ProxyImage("dadada", true);
        ProxyImage p2 = new ProxyImage("nununu", false) ;
        p.display();
        p2.display();
    }
}
