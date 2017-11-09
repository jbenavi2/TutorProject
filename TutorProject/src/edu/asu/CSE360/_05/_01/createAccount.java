package edu.asu.CSE360._05._01;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class createAccount extends JPanel {
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public createAccount() {
		setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(527, 117, 225, 39);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(527, 306, 225, 39);
		add(textField_1);
		
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
