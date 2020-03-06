package Socaci.Cristi.lab2.ex1;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter 2 numbers");
        int a = input.nextInt();
        int b = input.nextInt();
        System.out.print("Max: ");
        System.out.println(Math.max(a,b));
    }
}
