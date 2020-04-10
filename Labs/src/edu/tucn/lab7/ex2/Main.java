package edu.tucn.lab7.ex2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter character: ");
        char input = in.next().charAt(0);
        try {
            FileReader file = new FileReader("src\\edu\\tucn\\lab7\\ex2\\data.txt");
            int ch;
            int count = 0;
            while( (ch = file.read()) != -1){
                if(input == (char)ch)
                    ++count;
            }
            System.out.println("The character '"+input+"' appears "+count+" times");
            file.close();
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
