package edu.tucn.lab6.ex4;
import java.util.Scanner;

public class ConsoleMenu {
    private Dictionary dict;
    private Scanner input;
    public ConsoleMenu(Dictionary dict) {
        this.dict = dict;
        input = new Scanner(System.in);
    }

    public void menu() {

        boolean running = true;

        while(running) {
            display();
            int ch = input.nextInt();
            input.nextLine();

            switch (ch){
                case 0:
                    running = false;
                    break;
                case 1:
                    addWord();
                    break;
                case 2:
                    getDefinition();
                    break;
                case 3:
                    getAllWords();
                    break;
                case 4:
                    getAllDefinitions();
                    break;
                default:
                    System.out.println("Enter a valid number");
                    break;
            }
        }
    }

    private void display(){
        System.out.println("\n1. Add word");
        System.out.println("2. Get word definition");
        System.out.println("3. Get all words");
        System.out.println("4. Get all definitions");
        System.out.println("0. Exit\n");
        System.out.flush();
    }

    private void addWord(){
        System.out.print("Enter the word: ");
        String word = input.nextLine();
        System.out.print("Enter the definition: ");
        String definition = input.nextLine();
        dict.addWord(new Word(word), new Definition(definition));
    }
    private void getDefinition(){
        System.out.print("Enter the word: ");
        System.out.println("Definition: " + dict.getDefinition(new Word(input.nextLine())));
    }
    private void getAllWords(){
        dict.getAllWords().forEach(System.out::println);
    }
    private void getAllDefinitions(){
        dict.getAllDefinitions().forEach(System.out::println);
    }
}