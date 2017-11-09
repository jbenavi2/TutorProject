package edu.asu.CSE360._05._01;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
//import com.jgoodies.forms.layout.FormLayout;
//import com.jgoodies.forms.layout.ColumnSpec;
//import com.jgoodies.forms.layout.RowSpec;
//import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TutorOptions extends JPanel {

	/**
	 * Create the panel.
	 */
	public TutorOptions() {
		setLayout(null);
		
		JButton lessonButton = new JButton("LESSONS");
		lessonButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (lessonButton.isEnabled()) {
					removeAll();
					setLayout(new BorderLayout());
					lessonList2 chooseLesson = new lessonList2();
					add(chooseLesson, BorderLayout.CENTER);
					revalidate();
					repaint();
				}
			}
		});
		lessonButton.setBounds(542, 230, 196, 74);
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
		reviewButton.setBounds(911, 230, 196, 74);
		add(reviewButton);
		
		JButton profile = new JButton("PROFILE");
		profile.setBounds(173, 230, 196, 74);
		add(profile);
		
		JLabel placeholder = new JLabel("placeholder img");
		placeholder.setHorizontalAlignment(SwingConstants.CENTER);
		placeholder.setBounds(532, 577, 215, 14);
		add(placeholder);
		
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
