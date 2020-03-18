package edu.tucn.lab4.ex3;

import edu.tucn.lab4.ex2.Author;

public class Main
{
    public static void main(String[] args)
    {
        Author author = new Author("Cristi", "crisit@mail.com", 'm');
        Book a = new Book("carte1", author, 22.5);
        Book b = new Book("carte2", author, 22.5, 5);

        System.out.println(a.toString());
        System.out.println(b.toString());
    }
}
