package edu.asu.CSE360._05._01;

/**

* Description:
* 	JPanel that holds student info. Amount of questions answered correctly/incorrectly and time taken per lesson
* Assignment number:
* 	Recitation Project 4
* Completion time:
* 	1.5 Hours
*
* @author Andrew Bui
* @version 1
*/

import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JProgressBar;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class viewProfile extends JPanel {

	/**
	 * Create the panel.
	 */
	public viewProfile() {
		setBackground(Color.DARK_GRAY);
		setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		setLayout(null);
		
		JComboBox selectLesson = new JComboBox();
		selectLesson.setModel(new DefaultComboBoxModel(new String[] {"Select a Lesson...", "Basics of Cooking"}));
		selectLesson.setBounds(511, 72, 257, 20);
		add(selectLesson);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setValue(50);
		progressBar.setBounds(271, 189, 737, 78);
		add(progressBar);
		
		JButton backButton = new JButton("BACK");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeAll();
				setLayout(new BorderLayout());
				TutorOptions tutorChoice = new TutorOptions();
				add(tutorChoice, BorderLayout.CENTER);
				revalidate();
				repaint();
			}
		});
		backButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		backButton.setBounds(10, 11, 89, 23);
		add(backButton);
		
		ControlCenter session = ControlCenter.getInstance();
		double lessonOneCorrect = session.getLessonOneCorrect();
		
		JLabel lblNewLabel = new JLabel("CORRECT: " + lessonOneCorrect);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(525, 334, 230, 41);
		add(lblNewLabel);
		
		double lessonOneIncorrect = session.getLessonOneIncorrect();
		
		JLabel lblIncorrect = new JLabel("INCORRECT: " + lessonOneIncorrect);
		lblIncorrect.setForeground(Color.WHITE);
		lblIncorrect.setHorizontalAlignment(SwingConstants.CENTER);
		lblIncorrect.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblIncorrect.setBounds(525, 408, 230, 41);
		add(lblIncorrect);
		
		JLabel lblTime = new JLabel("TIME: ");
		lblTime.setForeground(Color.WHITE);
		lblTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblTime.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTime.setBounds(525, 486, 230, 41);
		add(lblTime);

	}
}
