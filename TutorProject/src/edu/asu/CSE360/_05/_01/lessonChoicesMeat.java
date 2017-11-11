package edu.asu.CSE360._05._01;

/**

* Description:
* 	Creates a JPanel that allows a user to choose a lesson option: assessment, learn, and recipe. 
* 	Plays music
* Assignment number:
* 	Recitation Project 4
* Completion time:
* 	1 Hours
*
* @author Andrew Bui
* @version 1
*/

import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class lessonChoicesMeat extends JPanel {

	/**
	 * Create the panel.
	 */
	public lessonChoicesMeat() {
		setBackground(Color.DARK_GRAY);
		setLayout(null);
		
		JButton backButton = new JButton("BACK");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeAll();
				setLayout(new BorderLayout());
				lessonList chooseLesson = new lessonList();
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
 					textLessonMeat text = new textLessonMeat();
 					add(text);
 					revalidate();
 					repaint();
 				}
			}
		});
		learnButton.setFont(new Font("Tahoma", Font.BOLD, 30));
		learnButton.setBounds(68, 268, 335, 184);
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
		assButton.setBounds(471, 268, 335, 184);
		add(assButton);
		
		JButton recipeButton = new JButton("GIVE ME A RECIPE!");
		recipeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (recipeButton.isEnabled()) {
					removeAll();
					setLayout(new BorderLayout());
					randomRecipe giveRecipe = new randomRecipe(0);
					add(giveRecipe);
					revalidate();
					repaint();
				}
			}
		});
		recipeButton.setFont(new Font("Tahoma", Font.BOLD, 30));
		recipeButton.setBounds(874, 268, 335, 184);
		add(recipeButton);

	}

}
