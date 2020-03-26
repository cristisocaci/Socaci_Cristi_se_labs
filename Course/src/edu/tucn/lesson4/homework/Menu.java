package edu.tucn.lesson4.homework;

import com.sun.xml.internal.messaging.saaj.soap.JpegDataContentHandler;

import javax.swing.*;
import java.awt.*;

public class Menu extends JFrame {

    private int windowHeight = 400;
    private int windowWidth = 400;
    private PersonRepository repository;
    private JPanel mainPanel = new JPanel();
    private JPanel createPanel = new JPanel();
    private JPanel updatePanel = new JPanel();
    private JPanel readPanel = new JPanel();
    private JPanel deletePanel = new JPanel();

    public Menu(String title, PersonRepository repository) throws HeadlessException {
        super(title);
        this.repository = repository;

        super.setSize(windowWidth, windowHeight);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setLayout(null);

        mainPanel.setBounds(20,20, windowWidth - 60,  windowHeight - 80);
        mainPanel.setLayout(null);

        createPanel.setBounds(20,20, windowWidth - 60,  windowHeight - 80);
        createPanel.setLayout(null);

        updatePanel.setBounds(20,20, windowWidth - 60,  windowHeight - 80);
        updatePanel.setLayout(null);

        readPanel.setBounds(20,20, windowWidth - 60,  windowHeight - 80);
        readPanel.setLayout(null);

        deletePanel.setBounds(20,20, windowWidth - 60,  windowHeight - 80);
        deletePanel.setLayout(null);
    }

    public void mainWindow()
    {

        mainPanel.setBounds(20,20, windowWidth - 60,  windowHeight - 80);
        mainPanel.setLayout(null);

        int buttonWidth = 340;
        int buttonHeight = 60;

        JButton create = new JButton("Create");
        create.setBounds(0,10, buttonWidth, buttonHeight);
        create.addActionListener( e -> createWindow());
        mainPanel.add(create);
        JButton update = new JButton("Update");
        update.setBounds(0,90, buttonWidth, buttonHeight);
        mainPanel.add(update);
        JButton read = new JButton("Read");
        read.setBounds(0,170, buttonWidth, buttonHeight);
        mainPanel.add(read);
        JButton delete = new JButton("Delete");
        delete.setBounds(0,250, buttonWidth, buttonHeight);
        mainPanel.add(delete);

        super.add(mainPanel);
        super.setVisible(true);

    }

    public void createWindow(){

        int labelW = 170;
        int labelH = 50;
        JLabel id = new JLabel("ID: ");
        id.setBounds(0, 25, labelW, labelH);
        createPanel.add(id);
        JLabel firstname = new JLabel("First Name: ");
        firstname.setBounds(0, 100, labelW, labelH);
        createPanel.add(firstname);
        JLabel lastname = new JLabel("Last Name: ");
        lastname.setBounds(0 ,175, labelW, labelH);
        createPanel.add(lastname);

        int textW = 170;
        int textH = 50;

        JTextField[] text = new JTextField[3];
        text[0] = new JTextField();
        text[0].setBounds(170, 25, textW, textH);
        createPanel.add(text[0]);
        text[1] = new JTextField();
        text[1].setBounds(170, 100, textW, textH);
        createPanel.add(text[1]);
        text[2] = new JTextField();
        text[2].setBounds(170, 175, textW, textH);
        createPanel.add(text[2]);
        for(int i = 0; i < 3; ++i)
            text[i].setText("");

        JButton add = new JButton("Add");
        add.setBounds(20, 250, 140, 50);
        add.addActionListener(
                e->{
                    String[] contents = new String[3];
                    for(int i = 0; i < 3; ++i){
                        contents[i] = text[i].getText();
                        if(contents[i].equals("")){
                            text[i].setBackground(Color.RED);
                            return;
                        }
                        text[i].setBackground(null);
                    }
                    for(int i = 0; i < 3; ++i)
                        text[i].setText("");
                    repository.create(new PersonEntity(contents[0], contents[1], contents[2]));
                });
        createPanel.add(add);
        JButton back = new JButton("Back");
        back.setBounds(180, 250, 140, 50 );
        back.addActionListener(
                e -> {
                    createPanel.setVisible(false);
                    mainPanel.setVisible(true);
        });
        createPanel.add(back);

        mainPanel.setVisible(false);
        createPanel.setVisible(true);
        super.add(createPanel);

    }

}
