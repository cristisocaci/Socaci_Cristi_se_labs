package edu.tucn.lesson4.homework;

import javax.swing.*;

/**
 * @author Radu Miron
 * @version 1
 * @since WS 11.6
 */
public class Main {
    public static void main(String[] args) {
        PersonRepository repo = new PersonRepository();
        Menu m = new Menu("Menu", repo);
        m.mainWindow();
    }
}
