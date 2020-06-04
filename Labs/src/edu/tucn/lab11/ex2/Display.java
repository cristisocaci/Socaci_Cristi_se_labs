package edu.tucn.lab11.ex2;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Display extends JFrame {
    private StockManagement stock;

    public Display(StockManagement stock) {
        this.stock = stock;
        super.setBounds(600, 400, 600, 400);
        super.setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel productNameLabel = new JLabel("Name: ");
        JLabel productQuantityLabel = new JLabel("Quantity: ");
        JLabel productPriceLabel = new JLabel("Price: ");
        JTextArea productName = new JTextArea();
        JTextArea productQuantity = new JTextArea();
        JTextArea productPrice = new JTextArea();
        JPanel input = new JPanel();
        input.setLayout(new GridLayout(3, 2));
        input.add(productNameLabel);
        input.add(productName);
        input.add(productQuantityLabel);
        input.add(productQuantity);
        input.add(productPriceLabel);
        input.add(productPrice);
        add(input, BorderLayout.PAGE_START);

        JButton newProd = new JButton("New Product");
        JButton viewProd = new JButton("View Products");
        JButton delProd = new JButton("Delete Product");
        JButton changeQuantity = new JButton("Change Quantity");
        JPanel buttons = new JPanel();
        buttons.setLayout(new GridLayout(1, 4));
        buttons.add(newProd);
        buttons.add(viewProd);
        buttons.add(delProd);
        buttons.add(changeQuantity);
        add(buttons, BorderLayout.CENTER);

        JTextArea info = new JTextArea();
        info.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(info);
        scrollPane.setPreferredSize(new Dimension(600, 250));
        add(scrollPane, BorderLayout.PAGE_END);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);


        newProd.addActionListener(e -> {
            stock.addProduct(new Product(productName.getText(),
                    Integer.parseInt(productQuantity.getText()),
                    Float.parseFloat(productPrice.getText()) ));
            info.setText("Product added successfully");
            productName.setText("");
            productPrice.setText("");
            productQuantity.setText("");
        });

        viewProd.addActionListener(e -> {
            ArrayList<String> strings = stock.toStr();
            String s = "List of products: \n";
            for (String aux : strings) {
                s = s + aux + "\n";
            }
            info.setText(s);
        });

        delProd.addActionListener(e -> {
            stock.deleteProduct(productName.getText());
            info.setText("Product deleted successfully");
            productName.setText("");
            productPrice.setText("");
            productQuantity.setText("");
        });

        changeQuantity.addActionListener(e -> {
            stock.changeQuantity(productName.getText(), Integer.parseInt(productQuantity.getText()));
            info.setText("Quantity changed successfully");
            productName.setText("");
            productPrice.setText("");
            productQuantity.setText("");
        });


        super.setVisible(true);
    }


}
