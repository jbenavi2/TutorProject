package edu.asu.CSE360._05._01;

import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class lessonChoices2 extends JPanel {

	/**
	 * Create the panel.
	 */
	public lessonChoices2() {
		setLayout(null);
		
		JButton backButton = new JButton("BACK");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeAll();

				setLayout(new BorderLayout());
				lessonList2 chooseLesson = new lessonList2();
				add(chooseLesson, BorderLayout.CENTER);
				revalidate();
				repaint();
			}
		});
		backButton.setBounds(10, 11, 89, 23);
		add(backButton);
		
		JButton learnButton = new JButton("LEARN!");
		learnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (learnButton.isEnabled()) {
 					removeAll();
 					setLayout(new BorderLayout());
 					textLesson text = new textLesson();
 					add(text);
 					revalidate();
 					repaint();
 				}
			}
		});
		learnButton.setFont(new Font("Tahoma", Font.BOLD, 30));
		learnButton.setBounds(203, 268, 335, 184);
		add(learnButton);
		
		JButton assButton = new JButton("ASSESSMENTS");
		assButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeAll();
				RevisedAssessor quiz = new RevisedAssessor();
				setLayout(new BorderLayout());
				//quiz.questionOne();
				add(quiz);
				revalidate();
				repaint();
			}
		});
		assButton.setFont(new Font("Tahoma", Font.BOLD, 30));
		assButton.setBounds(741, 268, 335, 184);
		add(assButton);

	}

}
