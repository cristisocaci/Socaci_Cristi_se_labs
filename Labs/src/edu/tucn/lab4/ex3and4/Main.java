package edu.tucn.lab4.ex3and4;

import edu.tucn.lab4.ex2.Author;

public class Main
{
    public static void main(String[] args)
    {
        Author[] author = new Author[2];
        author[0] = new Author("Cristi", "crisit@mail.com", 'm');
        author[1] = new Author("Marius", "marius@mail.com", 'm');

        Book a = new Book("carte1", author, 22.5);

        System.out.println(a.toString());
        a.printAuthors();

    }
}
