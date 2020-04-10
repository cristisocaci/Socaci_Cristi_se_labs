package edu.tucn.lab7.ex3;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean running = true;
        while(running) {
            Scanner in = new Scanner(System.in);
            System.out.println("Enter file name without any extension: ");
            String filename = in.nextLine();
            System.out.println("Enter operation: ");
            System.out.println("1. Encrypt");
            System.out.println("2. Decrypt");
            System.out.println("0. Exit");

            switch (in.nextInt())
            {
                case 0:
                    running = false;
                    break;
                case 1:
                    encrypt(filename);
                    break;
                case 2:
                    decrypt(filename);
                    break;
            }
        }
    }

    private static void encrypt(String filename){
        try {
            FileReader infile = new FileReader("src\\edu\\tucn\\lab7\\ex3\\" + filename + ".txt");
            FileWriter outfile = new FileWriter("src\\edu\\tucn\\lab7\\ex3\\" + filename + ".enc");
            int ch;
            while( (ch = infile.read()) != -1) {
                outfile.append((char) (ch << 1));
            }

            infile.close();
            outfile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void decrypt(String filename){
        try {
            FileReader infile = new FileReader("src\\edu\\tucn\\lab7\\ex3\\" + filename + ".enc");
            FileWriter outfile = new FileWriter("src\\edu\\tucn\\lab7\\ex3\\" + filename + ".dec");
            int ch;
            while( (ch = infile.read()) != -1) {
                outfile.append((char) (ch >> 1));
            }
            infile.close();
            outfile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
