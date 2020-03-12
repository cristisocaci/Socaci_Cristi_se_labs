package edu.tucn.lab2.ex2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        String[] s = {"ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE"};
        System.out.println("Enter a number from 1 to 9: ");
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        System.out.println(s[a-1]);
    }
}
