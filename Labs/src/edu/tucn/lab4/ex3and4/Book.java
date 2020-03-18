package edu.tucn.lab4.ex3and4;

import edu.tucn.lab4.ex2.Author;

public class Book
{
    private String name;
    private Author[] authors;
    private double price;
    private int qtyInStock = 0;

    public Book(String name, Author[] author, double price) {
        this.name = name;
        this.authors = author;
        this.price = price;
    }

    public Book(String name, Author[] author, double price, int qtyInStock) {
        this.name = name;
        this.authors = author;
        this.price = price;
        this.qtyInStock = qtyInStock;
    }

    public String getName() {
        return name;
    }

    public Author[] getAuthors() {
        return authors;
    }

    public double getPrice() {
        return price;
    }

    public int getQtyInStock() {
        return qtyInStock;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQtyInStock(int qtyInStock) {
        this.qtyInStock = qtyInStock;
    }

    @Override
    public String toString() {
        int i = 0 ;
        for(Author a: authors)
            i += 1;

        return "" + this.name + " by " + i + " authors";
    }

    public void printAuthors()
    {
        for (Author i:authors)
            System.out.println(i.toString());
    }
}
