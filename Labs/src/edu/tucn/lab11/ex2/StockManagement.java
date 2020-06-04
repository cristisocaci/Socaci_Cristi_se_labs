package edu.tucn.lab11.ex2;

import java.util.ArrayList;

public class StockManagement {
    ArrayList<Product> products = new ArrayList<Product>();

    public ArrayList<Product> getProducts() {
        return products;
    }
    public void addProduct(Product p){
        products.add(p);
    }
    public void deleteProduct(String name) {
        for (Product p : products) {
            if (name.equals(p.getName())) {
                products.remove(p);
                break;
            }
        }
    }
    public void changeQuantity(String name, int quantity){
        for(Product p: products) {
            if (name.equals(p.getName())) {
                p.setQuantity(quantity);
                break;
            }
        }
    }
    public ArrayList<String> toStr(){
        ArrayList<String> s = new ArrayList<>();
        products.forEach(e->s.add(e.toString()));
        return s;
    }
}
