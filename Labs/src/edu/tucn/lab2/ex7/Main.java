package edu.tucn.lab2.ex7;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner input = new Scanner(System.in);
        boolean won = false;
        int nb = rand.nextInt(10);
        for(int i = 0; i < 3; ++i)
        {
            System.out.println("Enter a number: ");
            int guess = input.nextInt();
            if(guess < nb)
                System.out.println("Wrong answer, your number is too low");
            else if(guess > nb)
                System.out.println("Wrong answer, your number is too high");
            else
            {
                System.out.println("You won");
                won = true;
                break;
            }
        }
        if(!won)
            System.out.println("You lost");


    }
}
