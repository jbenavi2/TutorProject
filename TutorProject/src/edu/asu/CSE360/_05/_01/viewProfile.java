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

	public viewProfile() {
		setBackground(Color.DARK_GRAY);
		setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		setLayout(null);
		
		//label shows # correct answers for lesson
		JLabel correctLabel = new JLabel("CORRECT: -");
		correctLabel.setForeground(Color.WHITE);
		correctLabel.setHorizontalAlignment(SwingConstants.CENTER);
		correctLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		correctLabel.setBounds(525, 334, 230, 41);
		add(correctLabel);
		
		//label shows number of incorrect answers for a lesson
		JLabel incorrectLabel = new JLabel("INCORRECT: -");
		incorrectLabel.setForeground(Color.WHITE);
		incorrectLabel.setHorizontalAlignment(SwingConstants.CENTER);
		incorrectLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		incorrectLabel.setBounds(525, 408, 230, 41);
		add(incorrectLabel);
		
		//label shows time taken to complete lesson
		JLabel timeLabel = new JLabel("TIME: -");
		timeLabel.setForeground(Color.WHITE);
		timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		timeLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		timeLabel.setBounds(525, 486, 230, 41);
		add(timeLabel);
		
		//progress bar that shows percentage of correct answers
		JProgressBar progressBar = new JProgressBar();
		progressBar.setMaximum(5);
		progressBar.setBounds(271, 189, 737, 78);
		add(progressBar);
		
		//dropdown menu to select which lesson stats to show. Uses Singleton.
		JComboBox selectLesson = new JComboBox();
		selectLesson.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (selectLesson.getSelectedItem() == "Basics of Cooking") {
					ControlCenter session = ControlCenter.getInstance();
					double lessonOneCorrect = session.getLessonOneCorrect();
					double lessonOneIncorrect = session.getLessonOneIncorrect();
					double lessonOneTime = session.getLessonOneTime();
					correctLabel.setText("CORRECT: " + lessonOneCorrect);
					incorrectLabel.setText("INCORRECT: " + lessonOneIncorrect);
					timeLabel.setText("TIME: " + lessonOneTime);
					progressBar.setValue((int)lessonOneCorrect);

				}
				if (selectLesson.getSelectedItem() == "Eggs and Baking") {
					ControlCenter session = ControlCenter.getInstance();
					double lessonTwoCorrect = session.getLessonTwoCorrect();
					double lessonTwoIncorrect = session.getLessonTwoIncorrect();
					double lessonTwoTime = session.getLessonTwoTime();
					correctLabel.setText("CORRECT: " + lessonTwoCorrect);
					incorrectLabel.setText("INCORRECT: " + lessonTwoIncorrect);
					timeLabel.setText("TIME: " + lessonTwoTime);
					progressBar.setValue((int)lessonTwoCorrect);
				}
				if (selectLesson.getSelectedItem() == "Meat"){
					ControlCenter session = ControlCenter.getInstance();
					double lessonThreeCorrect = session.getLessonThreeCorrect();
					double lessonThreeIncorrect = session.getLessonThreeIncorrect();
					double lessonThreeTime = session.getLessonThreeTime();
					correctLabel.setText("CORRECT: " + lessonThreeCorrect);
					incorrectLabel.setText("INCORRECT: " + lessonThreeIncorrect);
					timeLabel.setText("TIME: " + lessonThreeTime);
					progressBar.setValue((int)lessonThreeCorrect);
				}
			}
		});
		//drop down menu of all lessons
		selectLesson.setModel(new DefaultComboBoxModel(new String[] {"Select a Lesson...", "Basics of Cooking", "Eggs and Baking", "Meat"}));
		selectLesson.setBounds(511, 72, 257, 20);
		add(selectLesson);
		
		//back button - go back to tutor options
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
	}
}
