package edu.asu.CSE360._05._01;

/**

* Description:
* 	Creates a JPanel that allows a user to create an account with the tutor program. 
* 	Plays music
* Assignment number:
* 	Recitation Project 4
* Completion time:
* 	2 Hours
*
* @author Andrew Bui
* @version 1
*/

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTextArea;


public class createAccount extends JPanel {
	private JTextField nameField;
	private JTextField passField;

	//function check if input is 1 word. used to check username and password
	private boolean isOneWord(String string) {
		String[] split = string.split("\\s+");
		if (split.length > 1) {
			return false;
		}
		else {
			return true;
		}
	}
	
	//Jpanel that allows creation of account
	public createAccount(){
		setBackground(Color.DARK_GRAY);
		setLayout(null);
		
		//enter username
		nameField = new JTextField();
		nameField.setBounds(527, 117, 225, 39);
		add(nameField);
		nameField.setColumns(10);
		
		//enter password
		passField = new JTextField();
		passField.setColumns(10);
		passField.setBounds(527, 306, 225, 39);
		add(passField);
		
		//username label
		JLabel userName = new JLabel("Username:");
		userName.setForeground(Color.WHITE);
		userName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		userName.setHorizontalAlignment(SwingConstants.CENTER);
		userName.setBounds(552, 80, 175, 25);
		add(userName);
		
		//password label
		JLabel passwordLabel = new JLabel("Password:");
		passwordLabel.setForeground(Color.WHITE);
		passwordLabel.setHorizontalAlignment(SwingConstants.CENTER);
		passwordLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		passwordLabel.setBounds(552, 274, 175, 25);
		add(passwordLabel);
		
		//create button. Checks if input is valid. Will only create once all inputs are valid. Not empty, no spaces
		JButton createButton = new JButton("CREATE");
		createButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!nameField.getText().isEmpty() && !passField.getText().isEmpty()) {
					if (isOneWord(nameField.getText()) && isOneWord(passField.getText())) {
						try {
							BufferedWriter outStream = new BufferedWriter( new FileWriter("resources/login.txt",true));
							PrintWriter printWriter = new PrintWriter(outStream);
							printWriter.print(nameField.getText().trim() + " ");
							printWriter.print(passField.getText().trim() + "\n");
							printWriter.close();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						removeAll();
						setLayout(new BorderLayout());
						Login loginScreen = new Login();
						add(loginScreen);
						revalidate();
						repaint();
					}
					
				}
			}
		});
		createButton.setFont(new Font("Tahoma", Font.BOLD, 22));
		createButton.setBounds(552, 484, 175, 70);
		add(createButton);
		
		//account creation info
		JTextArea txtrMustFillIn = new JTextArea();
		txtrMustFillIn.setText("Must fill in all fields\r\nAll characters allowed except spaces\r\nLagging and leading spaces will be trimmed\r\n");
		txtrMustFillIn.setBounds(10, 11, 298, 61);
		add(txtrMustFillIn);

	}
}
