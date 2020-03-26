package edu.tucn.lesson4.homework;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class Menu extends JFrame {

    private int windowHeight = 400;
    private int windowWidth = 400;
    private PersonRepository repository;
    private JPanel mainPanel = new JPanel();
    private JPanel createPanel = new JPanel();
    private JPanel updatePanel = new JPanel();
    private JPanel readPanel = new JPanel();
    private JPanel deletePanel = new JPanel();
    private JComboBox selectMenuUpdate;
    private JTextField[] text = new JTextField[3];
    private PersonEntity oldP;
    private boolean update;

    public Menu(String title, PersonRepository repository) throws HeadlessException {
        super(title);
        this.repository = repository;

        super.setSize(windowWidth, windowHeight);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setLayout(null);

        mainPanel.setBounds(20, 20, windowWidth - 60, windowHeight - 80);
        mainPanel.setLayout(null);

        createPanel.setBounds(20, 20, windowWidth - 60, windowHeight - 80);
        createPanel.setLayout(null);

        updatePanel.setBounds(20, 20, windowWidth - 60, windowHeight - 80);
        updatePanel.setLayout(null);

        readPanel.setBounds(20, 20, windowWidth - 60, windowHeight - 80);
        readPanel.setLayout(null);

        deletePanel.setBounds(20, 20, windowWidth - 60, windowHeight - 80);
        deletePanel.setLayout(null);

        int textW = 170;
        int textH = 50;
        int y = 25;
        for (int i = 0; i < 3; ++i)
            text[i] = new JTextField();
        for (JTextField t : text) {
            t.setBounds(170, y, textW, textH);
            y += 75;
            t.setLayout(null);
            t.setEditable(true);
            t.setText("");
            createPanel.add(t);
        }
    }

    public void mainWindow() {

        mainPanel.setBounds(20, 20, windowWidth - 60, windowHeight - 80);
        mainPanel.setLayout(null);

        int buttonWidth = 340;
        int buttonHeight = 60;

        JButton create = new JButton("Create");
        create.setBounds(0, 10, buttonWidth, buttonHeight);
        create.addActionListener(e ->
        {
            this.update = false;
            createWindow();
        });
        mainPanel.add(create);
        JButton update = new JButton("Update");
        update.setBounds(0, 90, buttonWidth, buttonHeight);
        update.addActionListener(e -> updateWindow());
        mainPanel.add(update);
        JButton read = new JButton("Read");
        read.setBounds(0, 170, buttonWidth, buttonHeight);
        read.addActionListener(e -> readWindow());
        mainPanel.add(read);
        JButton delete = new JButton("Delete");
        delete.setBounds(0, 250, buttonWidth, buttonHeight);
        delete.addActionListener(e -> deleteWindow());
        mainPanel.add(delete);

        super.add(mainPanel);
        super.setVisible(true);

    }

    public void createWindow() {

        int labelW = 170;
        int labelH = 50;
        JLabel id = new JLabel("ID: ");
        id.setBounds(0, 25, labelW, labelH);
        createPanel.add(id);
        JLabel firstname = new JLabel("First Name: ");
        firstname.setBounds(0, 100, labelW, labelH);
        createPanel.add(firstname);
        JLabel lastname = new JLabel("Last Name: ");
        lastname.setBounds(0, 175, labelW, labelH);
        createPanel.add(lastname);
        JLabel info = new JLabel();
        info.setBounds(0, 300, 300, 20);
        info.setText("");
        createPanel.add(info);

        JButton add = new JButton("Add");
        add.setBounds(20, 250, 140, 40);
        add.addActionListener(
                e -> {
                    String[] contents = new String[3];
                    for (int i = 0; i < 3; ++i) {
                        contents[i] = text[i].getText();
                        if (contents[i].equals("")) {
                            text[i].setBackground(Color.RED);
                            return;
                        }
                        text[i].setBackground(null);
                    }
                    PersonEntity p = new PersonEntity(contents[0], contents[1], contents[2]);
                    if (!this.update) {
                        if (!repository.contains(p.getIdNumber())) {
                            for (int i = 0; i < 3; ++i)
                                text[i].setText("");
                            repository.create(p);
                            info.setText("File created successfully");
                        } else {
                            text[0].setBackground(Color.red);
                            System.out.println("A person with the same id already exists");
                            info.setText("A person with the same id already exists");
                        }
                    } else {
                        for (int i = 0; i < 3; ++i)
                            text[i].setText("");
                        //System.out.println(oldP);
                        if (p.getIdNumber().equals(oldP.getIdNumber())) {
                            repository.update(p, oldP);
                            info.setText("File updated successfully");
                        } else if (repository.contains(p.getIdNumber())) {
                            info.setText("A person with the same id already exists");
                        } else {
                            repository.update(p, oldP);
                            info.setText("File updated successfully");
                        }
                    }
                    refreshPanel(true);
                });
        createPanel.add(add);

        JButton back = new JButton("Back");
        back.setBounds(180, 250, 140, 40);
        back.addActionListener(
                e -> {
                    for (int i = 0; i < 3; ++i) {
                        text[i].setBackground(null);
                        text[i].setText("");
                    }
                    info.setText("");
                    createPanel.setVisible(false);
                    mainPanel.setVisible(true);
                });
        createPanel.add(back);

        mainPanel.setVisible(false);
        createPanel.setVisible(true);
        super.add(createPanel);

    }

    public void updateWindow() {
        refreshPanel(true);

        JLabel update = new JLabel("Update: ");
        update.setBounds(0, 50, 170, 20);
        updatePanel.add(update);

        JButton updateB = new JButton("Update");
        updateB.setBounds(20, 250, 140, 40);
        updateB.addActionListener(
                e -> {
                    String id = ((String) selectMenuUpdate.getItemAt(selectMenuUpdate.getSelectedIndex())).split(":")[0];

                    oldP = repository.getPerson(id);
                    //System.out.println(oldP);
                    text[0].setText(oldP.getIdNumber());
                    text[1].setText(oldP.getFirstName());
                    text[2].setText(oldP.getLastName());
                    updatePanel.setVisible(false);
                    createPanel.setVisible(true);
                    this.update = true;
                    createWindow();
                });
        updatePanel.add(updateB);

        JButton back = new JButton("Back");
        back.setBounds(180, 250, 140, 40);
        back.addActionListener(
                e -> {
                    updatePanel.setVisible(false);
                    mainPanel.setVisible(true);
                });
        updatePanel.add(back);

        mainPanel.setVisible(false);
        updatePanel.setVisible(true);
        super.add(updatePanel);
    }

    public void refreshPanel(boolean flag) {
        int size = repository.getNbOfPersons();
        String[] names = new String[size];
        LinkedList<PersonEntity> persons = repository.getFullNames();
        // System.out.println(persons);
        for (int i = 0; i < size; ++i) {
            PersonEntity person = persons.get(i);
            names[i] = person.getIdNumber() + ": " + person.getFirstName() + " " + person.getLastName();
        }
        try {
            selectMenuUpdate.removeAllItems();
            for (String n : names)
                selectMenuUpdate.addItem(n);
            updatePanel.add(selectMenuUpdate);
        } catch (java.lang.NullPointerException e) {
            selectMenuUpdate = new JComboBox(names);
            selectMenuUpdate.setBounds(170, 50, 170, 20);
            updatePanel.add(selectMenuUpdate);
        }

    }

    public void readWindow() {

        int labelW = 170;
        int labelH = 45;
        JLabel enterid = new JLabel("Enter ID: ");
        enterid.setBounds(0, 0, labelW, labelH);
        readPanel.add(enterid);
        JLabel id = new JLabel("ID: ");
        id.setBounds(0, 65, labelW, labelH);
        readPanel.add(id);
        JLabel firstname = new JLabel("First Name: ");
        firstname.setBounds(0, 135, labelW, labelH);
        readPanel.add(firstname);
        JLabel lastname = new JLabel("Last Name: ");
        lastname.setBounds(0, 205, labelW, labelH);
        readPanel.add(lastname);

        JTextField[] textL = new JTextField[3];
        int y = 65;
        for (int i = 0; i < 3; ++i) {
            textL[i] = new JTextField();
            textL[i].setBounds(170, y, labelW, labelH);
            y += 70;
            textL[i].setLayout(null);
            textL[i].setEditable(false);
            textL[i].setText("");
            readPanel.add(textL[i]);
        }

        JTextField enterIdTxt = new JTextField("");
        enterIdTxt.setEditable(true);
        enterIdTxt.setBounds(170, 0, labelW, labelH);
        enterIdTxt.addActionListener(e -> {
            PersonEntity p = repository.read(enterIdTxt.getText() + ".txt");
            if (p != null) {
                // System.out.println(p);
                textL[0].setText(p.getIdNumber());
                textL[1].setText(p.getFirstName());
                textL[2].setText(p.getLastName());
                enterIdTxt.setText("");
            } else
                enterIdTxt.setText("Enter a correct ID");
        });
        readPanel.add(enterIdTxt);

        JButton back = new JButton("Back");
        back.setBounds(100, 280, 140, 40);
        back.addActionListener(
                e -> {
                    readPanel.setVisible(false);
                    mainPanel.setVisible(true);
                });
        readPanel.add(back);

        mainPanel.setVisible(false);
        readPanel.setVisible(true);
        super.add(readPanel);
    }

    public void deleteWindow() {

        JLabel info = new JLabel();
        info.setBounds(0, 300, 170, 20);
        deletePanel.add(info);

        JLabel delete = new JLabel("Delete: ");
        delete.setBounds(0, 50, 170, 20);
        deletePanel.add(delete);

        JTextField text = new JTextField();
        text.setBounds(170, 50, 170, 20);
        deletePanel.add(text);

        JButton deleteB = new JButton("Delete");
        deleteB.setBounds(20, 250, 140, 40);
        deleteB.addActionListener(
                e -> {
                    if(repository.delete(repository.getPerson(text.getText())))
                        info.setText("File deleted successfully");
                    else
                        info.setText("Failed to delete the text");
                });
        deletePanel.add(deleteB);

        JButton back = new JButton("Back");
        back.setBounds(180, 250, 140, 40);
        back.addActionListener(
                e -> {
                    deletePanel.setVisible(false);
                    mainPanel.setVisible(true);
                });
        deletePanel.add(back);

        mainPanel.setVisible(false);
        deletePanel.setVisible(true);
        super.add(deletePanel);
    }

}
