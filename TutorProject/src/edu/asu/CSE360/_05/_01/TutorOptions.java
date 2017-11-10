package edu.asu.CSE360._05._01;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
//import com.jgoodies.forms.layout.FormLayout;
//import com.jgoodies.forms.layout.ColumnSpec;
//import com.jgoodies.forms.layout.RowSpec;
//import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class TutorOptions extends JPanel {

	/**
	 * Create the panel.
	 */
	public TutorOptions() {
		setBackground(Color.DARK_GRAY);
		setForeground(Color.DARK_GRAY);
		setLayout(null);
		
		JButton lessonButton = new JButton("LESSONS");
		lessonButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (lessonButton.isEnabled()) {
					removeAll();
					setLayout(new BorderLayout());
					lessonList chooseLesson = new lessonList();
					add(chooseLesson, BorderLayout.CENTER);
					revalidate();
					repaint();
				}
			}
		});
		lessonButton.setBounds(550, 141, 196, 74);
		add(lessonButton);
		
		JButton reviewButton = new JButton("RATE");
		reviewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeAll();
				setLayout(new BorderLayout());
				RateLesson rateScreen = new RateLesson();
				add(rateScreen, BorderLayout.CENTER);
				revalidate();
				repaint();
			}
		});
		reviewButton.setBounds(923, 141, 196, 74);
		add(reviewButton);
		
		JButton profile = new JButton("PROFILE");
		profile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				removeAll();
				setLayout(new BorderLayout());
				viewProfile profile = new viewProfile();
				add(profile);
				revalidate();
				repaint();
			}
		});
		profile.setBounds(177, 141, 196, 74);
		add(profile);
		
		ImageIcon meat = new ImageIcon("resources/fireGordon.gif");
		
		JLabel introRamsay = new JLabel();
		introRamsay.setIcon(meat);
		introRamsay.setHorizontalAlignment(SwingConstants.CENTER);
		introRamsay.setBounds(391, 315, 514, 279);
		add(introRamsay);
		
		JButton logoutButton = new JButton("LOGOUT");
		logoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (logoutButton.isEnabled()) {
					removeAll();
					setLayout(new BorderLayout());
					Login loginScreen = new Login();
					add(loginScreen);
					revalidate();
					repaint();
				}
			}
		});
		logoutButton.setBounds(10, 11, 89, 23);
		add(logoutButton);

	}

}
