package main.java;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JSplitPane;
import java.awt.BorderLayout;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI {

	private JFrame frame;
	private JTextField textField_Encryption;
	private JTextField textField_Key;
	private JTextField textField_EncryptedText;
	private JTextField textField_Decryption;
	private JTextField textField_DecryptedText;
	
	private String outcome;
	private String userKey = null;
	private String encryptedText = "aaaa";
	private String encryptedTextToDecrypt;
	private String decryptedText = "bbbb";
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblEnterYourText = new JLabel("Enter your text to encrypt below");
		lblEnterYourText.setBounds(10, 11, 391, 14);
		frame.getContentPane().add(lblEnterYourText);
		
		textField_Encryption = new JTextField();
		textField_Encryption.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
				      outcome = textField_Encryption.getText();				//GET TEXT FROM USER
				}
				
			}
		});
		textField_Encryption.setBounds(10, 28, 391, 20);
		frame.getContentPane().add(textField_Encryption);
		textField_Encryption.setColumns(10);
		
		JLabel lblEnterYourPersonal = new JLabel("Enter your personal key");
		lblEnterYourPersonal.setBounds(10, 59, 171, 14);
		frame.getContentPane().add(lblEnterYourPersonal);
		
		textField_Key = new JTextField();
		textField_Key.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					userKey = textField_Encryption.getText();				//GET KEY FROM USER
					
					if ((!textField_Key.getText().isEmpty() && !textField_Encryption.getText().isEmpty()) )
					{
					textField_EncryptedText.setText(encryptedText);
					}
					
				}
			}
		});
		
		textField_Key.setColumns(10);
		textField_Key.setBounds(10, 76, 391, 20);
		frame.getContentPane().add(textField_Key);
		
		JLabel lblEncryptedText = new JLabel("Encrypted text");
		lblEncryptedText.setBounds(10, 107, 171, 14);
		frame.getContentPane().add(lblEncryptedText);
		
		textField_EncryptedText = new JTextField();
		
		
		
		//textField_EncryptedText.setEditable(false);
		textField_EncryptedText.setColumns(10);							//ENCRYPTED TEXT 
		textField_EncryptedText.setBounds(10, 132, 391, 20);
		frame.getContentPane().add(textField_EncryptedText);
		
		JLabel lblEnterYourText_1 = new JLabel("Enter your text to decrypt below");
		lblEnterYourText_1.setBounds(10, 163, 391, 14);
		frame.getContentPane().add(lblEnterYourText_1);
		
		textField_Decryption = new JTextField();
		
		textField_Decryption.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					encryptedTextToDecrypt = textField_Decryption.getText();				//GET ENCRYPTED TEXT FROM USER
					
					if ((!textField_Key.getText().isEmpty() && !textField_Decryption.getText().isEmpty()) )
					{
						textField_DecryptedText.setText(decryptedText);
					}
					
					
				}
			}
		});
		
		textField_Decryption.setColumns(10);
		textField_Decryption.setBounds(10, 180, 391, 20);
		frame.getContentPane().add(textField_Decryption);
		
		JLabel lblDecryptedText = new JLabel("Decrypted text");
		lblDecryptedText.setBounds(10, 211, 171, 14);
		frame.getContentPane().add(lblDecryptedText);
		
		textField_DecryptedText = new JTextField();
		textField_DecryptedText.setColumns(10);
		textField_DecryptedText.setBounds(10, 236, 391, 20);
		frame.getContentPane().add(textField_DecryptedText);
	}
}
