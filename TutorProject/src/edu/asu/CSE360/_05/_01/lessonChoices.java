package edu.asu.CSE360._05._01;


import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;

import javax.print.attribute.standard.Media;
import javax.swing.*;

/**

* Description:
* 	Creates a JPanel that holds the options of a lesson, Learn, take assessment, and return to the list of lessons
* Assignment number:
* 	Recitation Project 3
* Completion time:
* 	2 Hours
*
* @author Andrew Bui
* @version 1
*/

public class lessonChoices extends JPanel {
	
	private JPanel lessonPanel;	
	private JButton textButton, testButton, backButton;
	private ImageIcon gordonA;
	private JLabel gordonLabel;
	
	public lessonChoices() {
		//button inits
		textButton = new JButton("Learn!");
		textButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		textButton.setFont(new Font("Arial", Font.PLAIN,20));
		
		testButton = new JButton("Assessments");
		testButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		testButton.setFont(new Font("Arial", Font.PLAIN,20));
		
		backButton = new JButton("BACK");
		backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		backButton.setFont(new Font("Arial", Font.PLAIN,20));
		
		//create my panel that will only contain my name
		lessonPanel = new JPanel();
		lessonPanel.setLayout(new GridLayout(1,2));
		lessonPanel.add(textButton);
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		//lessons type
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 0;
		c.ipadx = 800;
		c.ipady = 30;
		c.insets = new Insets(0,0,10,0);
		add(lessonPanel,c);
		
		//go to test button
		c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 1;
		c.ipadx = 100;
		c.ipady = 40;
		c.insets = new Insets(50,0,50,0);
		add(testButton,c);
		
		//back Button
		c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 2;
		c.ipadx = 50;
		c.ipady = 20;
		c.insets = new Insets(10,300,10,300);
		add(backButton,c);
		
		//picture of gordon
		c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 3;
		gordonA = new ImageIcon("resources/gr2.jpg");
		gordonLabel = new JLabel("", gordonA, JLabel.CENTER);
		add(gordonLabel,c);
		
		//go to text on topics
		textButton.addActionListener(new ActionListener() {
 			public void actionPerformed(ActionEvent e) {
 				if (textButton.isEnabled()) {
 					removeAll();
 					revalidate();
 					repaint();
 					textLesson text = new textLesson();
 					add(text);
 				}
 			}
		});
		//listen for back button
		backButton.addActionListener(new ActionListener() {
 			public void actionPerformed(ActionEvent e) {
 				if (backButton.isEnabled()) {
 					removeAll();
 					lessonList chooseLesson = new lessonList();
 					add(chooseLesson);
 					revalidate();
 					repaint();
 					
 				}
 			}
		});
		//actionListener for TestButton added by Javier B
				testButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent event) {
						if(testButton.isEnabled()) {
							removeAll();
							RevisedAssessor quiz = new RevisedAssessor();
							//quiz.questionOne();
							add(quiz);
							revalidate();
							repaint();
						}
					}
				});
	}
}
