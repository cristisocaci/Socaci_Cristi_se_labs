package edu.tucn.lab2.ex3;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the numbers: ");
        int a = input.nextInt();
        int b = input.nextInt();
        boolean[] bool = new boolean[b];

        for(int i = 0; i < b; ++i)
            bool[i] = true;

        for (int i = 2; i< Math.sqrt(b); i++) {
            if(bool[i]) {
                for(int j = (i*i); j<b; j = j+i) {
                    bool[j] = false;
                }
            }
        }
        int count = 0;
        System.out.println("List of prime numbers upto given number are : ");
        for (int i = a; i< bool.length; i++) {
            if(bool[i] && i != 1) {
                System.out.println(i);
                ++count;
            }
        }
        System.out.println(count + " prime numbers");
    }
}
