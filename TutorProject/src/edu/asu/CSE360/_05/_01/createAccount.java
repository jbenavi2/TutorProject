package edu.asu.CSE360._05._01;

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

public class createAccount extends JPanel {
	private JTextField nameField;
	private JTextField passField;

	/**
	 * Create the panel.
	 */
	public createAccount(){
		setLayout(null);
		
		nameField = new JTextField();
		nameField.setBounds(527, 117, 225, 39);
		add(nameField);
		nameField.setColumns(10);
		
		passField = new JTextField();
		passField.setColumns(10);
		passField.setBounds(527, 306, 225, 39);
		add(passField);
		
		JLabel userName = new JLabel("Username:");
		userName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		userName.setHorizontalAlignment(SwingConstants.CENTER);
		userName.setBounds(552, 80, 175, 25);
		add(userName);
		
		JLabel passwordLabel = new JLabel("Password:");
		passwordLabel.setHorizontalAlignment(SwingConstants.CENTER);
		passwordLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		passwordLabel.setBounds(552, 274, 175, 25);
		add(passwordLabel);
		
		JButton createButton = new JButton("CREATE");
		createButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					BufferedWriter outStream = new BufferedWriter( new FileWriter("resources/login.txt",true));
					PrintWriter printWriter = new PrintWriter(outStream);
					printWriter.print(nameField.getText() + " ");
					printWriter.print(passField.getText() + "\n");
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
		});
		createButton.setFont(new Font("Tahoma", Font.BOLD, 22));
		createButton.setBounds(552, 484, 175, 70);
		add(createButton);

	}

}
