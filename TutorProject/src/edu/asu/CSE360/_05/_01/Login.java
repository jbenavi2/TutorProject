package edu.asu.CSE360._05._01;

/**

* Description:
* 	Creates a JPanel that is serves as a login screen for the program. Checks username and password with stored file. 
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
import java.awt.Canvas;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLayeredPane;
import javax.swing.ImageIcon;
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
import java.awt.Image;
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

	public Login() {
		setBackground(Color.DARK_GRAY);
		setLayout(null);
		String fileName = "resources/login.txt";

		//enter username
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
		
		//enter password
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
		
		//attempt to login. Checks if info is valid. Only allows registered accounts in
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
		
		//go to account creation
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
		
		//Title
		JLabel titleLabel = new JLabel("DRAG ME TO HELL'S KITCHEN");
		titleLabel.setForeground(Color.WHITE);
		titleLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setBounds(235, 31, 809, 100);
		add(titleLabel);
		JLabel lblaCooking = new JLabel("- A Cooking Tutor featuring Gordon Ramsay");
		lblaCooking.setForeground(Color.WHITE);
		lblaCooking.setHorizontalAlignment(SwingConstants.CENTER);
		lblaCooking.setBounds(482, 117, 315, 14);
		add(lblaCooking);
		
		//torches for flavor
		ImageIcon torch = new ImageIcon("resources/torch.gif");
		JLabel torch1 = new JLabel();
		torch1.setIcon(torch);
		torch1.setBounds(10, 429, 331, 320);
		add(torch1);
		JLabel torch2 = new JLabel();
		torch2.setIcon(torch);
		torch2.setBounds(939, 429, 331, 320);
		add(torch2);
		

		

		




	}
}
