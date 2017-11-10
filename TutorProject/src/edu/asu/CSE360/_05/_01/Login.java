package edu.asu.CSE360._05._01;

import javax.swing.JPanel;
import java.awt.Canvas;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLayeredPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.JPasswordField;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;



public class Login extends JPanel {
	private JTextField usernameField;
	private JPasswordField passwordField;

	/**
	 * Create the panel.
	 */
	public Login() {
		setLayout(null);
		String fileName = "resources/login.txt";

		
		usernameField = new JTextField();
		usernameField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				usernameField.setText("");
			}
		});

		usernameField.setHorizontalAlignment(SwingConstants.CENTER);
		usernameField.setText("USERNAME");
		usernameField.setBounds(516, 249, 248, 43);
		add(usernameField);
		
		passwordField = new JPasswordField();
		passwordField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				passwordField.setText("");
			}
		});
		passwordField.setText("PleaseGiveUsAnA");
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setBounds(516, 315, 248, 43);
		add(passwordField);
		
		JButton loginButton = new JButton("LOGIN");
		loginButton.setBackground(UIManager.getColor("Button.darkShadow"));
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loginButton.isEnabled()) {
					try {
						String line = null;
						FileReader fileReader = new FileReader(fileName);
						BufferedReader bufferedReader = new BufferedReader(fileReader);
						while ((line = bufferedReader.readLine()) != null) {
								String[] split = line.split("\\s+");
								if (split[0].equals(usernameField.getText()) && split[1].equals(String.valueOf(passwordField.getPassword()))) {
									removeAll();
									setLayout(new BorderLayout());
									TutorOptions tutorChoice = new TutorOptions();
									add(tutorChoice, BorderLayout.CENTER);
									revalidate();
									repaint();
							}
						}
					}
					catch(FileNotFoundException ex) {
			            System.out.println(
			                "Unable to open file '" + 
			                fileName + "'");                
			        }
			        catch(IOException ex) {
			            System.out.println(
			                "Error reading file '" 
			                + fileName + "'");                  
			        }

				}
			}
		});
		loginButton.setBounds(529, 400, 222, 62);
		add(loginButton);
		
		JButton createAccount = new JButton("Create Account");
		createAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (createAccount.isEnabled()) {
					removeAll();
					setLayout(new BorderLayout());
					createAccount newAccount = new createAccount();
					add(newAccount);
					revalidate();
					repaint();
					
				}
			}
		});
		createAccount.setBackground(UIManager.getColor("Button.background"));
		createAccount.setBounds(542, 621, 195, 23);
		add(createAccount);
		
		JLabel titleLabel = new JLabel("DRAG ME TO HELL'S KITCHEN");
		titleLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setBounds(333, 69, 613, 62);
		add(titleLabel);
		


	}
}
