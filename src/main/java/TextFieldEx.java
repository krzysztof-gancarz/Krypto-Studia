package main.java;

import javax.swing.*;
import java.awt.Graphics;

public class TextFieldEx extends JFrame {

    private static final long serialVersionUID = -5624404136485946868L;

    String userWord = "";
    JTextField userInput;
    JTextField userInput1;
    JTextField encryptedInput;
    JTextField decryptedInput;

    public TextFieldEx() {
        //First okienko
        JFrame jf = new JFrame("Fajny program");
        JPanel panel = new JPanel();
        JLabel jl = new JLabel("Wprowadz tekst");
        JButton jButton = new JButton("Klik");
        
        userInput = new JTextField("", 30);
        //encryptedInput  new JTextField(*encryptedInput*, 30)
        //decryptedInput  new JTextField(*decryptedInput*, 30)

        //Second okienko
        JPanel panel1 = new JPanel();
        JLabel jl1 = new JLabel("Wprowadz klucz");
        JButton jButton1 = new JButton("Klik klucz");
        userInput1 = new JTextField("", 30);

        jButton.addActionListener((e) -> {
            submitAction();
        });

        jButton1.addActionListener((e) -> {
            actionPerformed();
        });

        jf.setSize(500, 500);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.add(panel);
        panel.add(jl);
        panel.add(userInput);
        panel.add(jButton);
 
        panel1.add(jl1);
        panel1.add(userInput1);
        panel.add(jButton1);
    }

    private String submitAction() {
        userWord = userInput.getText();
        // do something with the variabe userWord here (print it to the console, etc.)
        System.out.println("test: " + userWord);
        return userWord;
    }

    public void actionPerformed() {
        userWord = userInput.getText();
        System.out.println("test1: " + userWord);
        
    }








    public static void main(String[] args) {
        new TextFieldEx();
    }
}