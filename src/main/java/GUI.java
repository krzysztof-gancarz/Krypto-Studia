package main.java;

import java.awt.EventQueue;
import java.io.*;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.stream.Collectors;

import javax.swing.JFrame;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;

import java.awt.BorderLayout;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class GUI {

	private JFrame frame;
	private JTextField textField_Encryption;
	private JTextField textField_Key;
	private JTextField textField_EncryptedText;
	private JTextField textField_Decryption;
	private JTextField textField_DecryptedText;
	
	private JTextField whereInput;
	
	
	private String userKey = null;
	private String encryptedText = null;
	private String encryptedTextToDecrypt;
	private String decryptedText = null;
	private JTextField textField;
	private JTextField textField_1;
	

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
		
		
		
		frame = new JFrame("Encrypt your text!");
		frame.getContentPane().setFont(new Font("Calibri Light", Font.PLAIN, 13));
		frame.getContentPane().setBackground(Color.ORANGE);
		frame.setBounds(100, 100, 777, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblEnterYourText = new JLabel("Enter your text to encrypt below");
		lblEnterYourText.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblEnterYourText.setBounds(10, 11, 391, 14);
		frame.getContentPane().add(lblEnterYourText);
		
		textField_Encryption = new JTextField();
		textField_Encryption.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				whereInput = textField_Encryption;
			}
		});
		
		
		
	
		
		
		textField_Encryption.setBackground(Color.CYAN);
		textField_Encryption.setFont(new Font("Calibri Light", Font.PLAIN, 13));
		textField_Encryption.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					
					String encodedMessage = new String(Transformation.toCharArray(Cipher.encodeMessage(textField_Encryption.getText().toString(), textField_Key.getText().toString())));
					textField_EncryptedText.setText(encodedMessage);				//GET TEXT FROM USER
				}
				
			}
		});
		textField_Encryption.setBounds(10, 28, 391, 20);
		frame.getContentPane().add(textField_Encryption);
		textField_Encryption.setColumns(10);
		
		JLabel lblEnterYourPersonal = new JLabel("Enter your personal key");
		lblEnterYourPersonal.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblEnterYourPersonal.setBounds(10, 59, 171, 14);
		frame.getContentPane().add(lblEnterYourPersonal);
		
		textField_Key = new JTextField();
		textField_Key.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				whereInput = textField_Key;
			}
		});
		textField_Key.setFont(new Font("Calibri Light", Font.PLAIN, 13));
		textField_Key.setBackground(Color.CYAN);
		/*textField_Key.addKeyListener(new KeyAdapter() {
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
		});*/
		
		textField_Key.setColumns(10);
		textField_Key.setBounds(10, 76, 391, 20);
		frame.getContentPane().add(textField_Key);
		
		JLabel lblEncryptedText = new JLabel("Encrypted text");
		lblEncryptedText.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblEncryptedText.setBounds(10, 107, 171, 14);
		frame.getContentPane().add(lblEncryptedText);
		
		textField_EncryptedText = new JTextField();
		textField_EncryptedText.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				whereInput = textField_EncryptedText;
			}
		});
		textField_EncryptedText.setFont(new Font("Calibri Light", Font.PLAIN, 13));
		textField_EncryptedText.setBackground(Color.CYAN);
		
		
		
		//textField_EncryptedText.setEditable(false);
		textField_EncryptedText.setColumns(10);							//ENCRYPTED TEXT 
		textField_EncryptedText.setBounds(10, 132, 391, 20);
		frame.getContentPane().add(textField_EncryptedText);
		
		JLabel lblEnterYourText_1 = new JLabel("Enter your text to decrypt below");
		lblEnterYourText_1.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblEnterYourText_1.setBounds(10, 163, 391, 14);
		frame.getContentPane().add(lblEnterYourText_1);
		
		textField_Decryption = new JTextField();
		textField_Decryption.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				whereInput = textField_Decryption;
			}
		});
		textField_Decryption.setFont(new Font("Calibri Light", Font.PLAIN, 13));
		textField_Decryption.setBackground(Color.CYAN);
		
		textField_Decryption.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					encryptedTextToDecrypt = textField_Decryption.getText();				//GET ENCRYPTED TEXT FROM USER
					
					if ((!textField_Key.getText().isEmpty() && !textField_Decryption.getText().isEmpty()) )
					{
						String decodedMessage = new String(Transformation.toCharArray(Cipher.decodeMessage(textField_Decryption.getText().toString(), textField_Key.getText().toString())));
						textField_DecryptedText.setText(decodedMessage);
					}
					
					
				}
			}
		});
		
		textField_Decryption.setColumns(10);
		textField_Decryption.setBounds(10, 180, 391, 20);
		frame.getContentPane().add(textField_Decryption);
		
		JLabel lblDecryptedText = new JLabel("Decrypted text");
		lblDecryptedText.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblDecryptedText.setBounds(10, 211, 171, 14);
		frame.getContentPane().add(lblDecryptedText);
		
		textField_DecryptedText = new JTextField();
		textField_DecryptedText.setFont(new Font("Calibri Light", Font.PLAIN, 13));
		textField_DecryptedText.setBackground(Color.CYAN);
		textField_DecryptedText.setColumns(10);
		textField_DecryptedText.setBounds(10, 236, 391, 20);
		frame.getContentPane().add(textField_DecryptedText);
		
		JButton btnReadFromFile = new JButton("Encrypt");
		btnReadFromFile.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent c) {
				
				JFileChooser fc = new JFileChooser();

			   
			      int returnVal = fc.showOpenDialog(frame);
			      if (returnVal == JFileChooser.APPROVE_OPTION) {
			        File file = fc.getSelectedFile();
			        try {
			          
					  byte[] byteMessage = Files.readAllBytes(file.toPath());
					 
					  
					  byte[][] encodedMessage=Cipher.encodeMessage(byteMessage, textField_Key.getText().toString());
			
					  byte[] encodedbytes = Transformation.toByteArray(encodedMessage);
					  FileOutputStream saveHash = new FileOutputStream(file.getName() + ".hash");
					  saveHash.write(encodedbytes);
					  saveHash.close();
			        } catch (Exception e) {
			          e.printStackTrace();
			        }
			      } else {
			        System.out.println("Operation is CANCELLED ");
			      }
			}
		});
		btnReadFromFile.setBounds(545, 27, 123, 23);
		frame.getContentPane().add(btnReadFromFile);
		
		JButton btnDecrypt = new JButton("Decrypt");
		btnDecrypt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JFileChooser fc = new JFileChooser();

				   
			      int returnVal = fc.showOpenDialog(frame);
			      if (returnVal == JFileChooser.APPROVE_OPTION) {
			        File file = fc.getSelectedFile();
			        try {
						byte[] byteMessage = Files.readAllBytes(file.toPath());
						byte[][] decodedMessage=Cipher.decodeMessage(byteMessage, textField_Key.getText().toString());

						byte[] decodedbytes = Transformation.toByteArray(decodedMessage);
						int numberOfZeros = 0;
						for (int i=decodedbytes.length-1; i > 0; i--) {
							if(decodedbytes[i] == 0) {
								numberOfZeros++;
							}
							else break;
						}
						FileOutputStream saveHash = new FileOutputStream(file.getName().substring(0, file.getName().length()-5));
						saveHash.write(Arrays.copyOfRange(decodedbytes, 0, decodedbytes.length-numberOfZeros));
						saveHash.close();
			        } catch (Exception e) {
			          e.printStackTrace();
			        }
			      } else {
			        System.out.println("Operation is CANCELLED ");
			      }
				
			}
		});
		btnDecrypt.setBounds(545, 131, 123, 23);
		frame.getContentPane().add(btnDecrypt);
		
		JLabel lblNameYourFile = new JLabel("Name your file here");
		lblNameYourFile.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblNameYourFile.setBounds(544, 59, 148, 14);
		frame.getContentPane().add(lblNameYourFile);
		
		JLabel label = new JLabel("Name your file here");
		label.setFont(new Font("Calibri", Font.PLAIN, 15));
		label.setBounds(545, 163, 148, 14);
		frame.getContentPane().add(label);
		
		textField = new JTextField();
		textField.setBackground(Color.CYAN);
		textField.setBounds(545, 76, 123, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBackground(Color.CYAN);
		textField_1.setBounds(545, 180, 123, 20);
		frame.getContentPane().add(textField_1);
		
		try {									//IMAGE
		BufferedImage myPicture = ImageIO.read(new File("image.png"));
		
		JLabel panel = new JLabel(new ImageIcon(myPicture));
		
		//add(picLabel);
		panel.setBounds(10, 267, 729, 83);
		frame.getContentPane().add(panel);
		} catch (Exception e) {
	          e.printStackTrace();
		}

		
	}
}