package main.java;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
public class TextFieldEx {
    JFrame frame;
    JPanel buttonPane, fieldsPanel;
    JLabel tekst, klucz;
    JTextField tField, kField;
    JButton ok, cancel;

    public TextFieldEx() {
        frame = new JFrame("Krypto");
        frame.setSize(600,600);
        buttonPane = new JPanel();
        fieldsPanel = new JPanel();
        tekst = new JLabel("Wprowadz tekst");
        klucz = new JLabel("Podaj klucz");
        tField = new JTextField("");
        kField = new JTextField("");
        ok = new JButton("Encryption");
        cancel = new JButton("Decryption");

        fieldsPanel.setLayout(new BoxLayout(fieldsPanel, BoxLayout.PAGE_AXIS));
        buttonPane.setLayout(new FlowLayout());

        
        fieldsPanel.add(tekst);
        fieldsPanel.add(tField);
        fieldsPanel.add(klucz);
        fieldsPanel.add(kField);
        buttonPane.add(ok);
        buttonPane.add(cancel);
        frame.add(fieldsPanel, BorderLayout.PAGE_START);
        frame.add(buttonPane, BorderLayout.PAGE_END);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.pack();
        frame.setVisible(true);
        
 
        
    


    
    }
    public String actionPerformed() {
        String userInput = tField.getText();
        System.out.println(userInput);
        return userInput;
    }
    
    
    public static void main(String args[]) {
        new TextFieldEx();
        
        
    }
}