package edu.tucn.lab11.ex2;

public class Product {
    private String name;
    private int quantity;
    private float price;

    public Product(String name, int quantity, float price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Name:" + this.name + "; Quantity: " + this.quantity+ "; Price: "+ this.price;
    }
}
