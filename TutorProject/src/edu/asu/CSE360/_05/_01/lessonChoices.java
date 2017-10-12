package edu.asu.CSE360._05._01;


import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;

import javax.print.attribute.standard.Media;
import javax.swing.*;


public class lessonChoices extends JPanel {
	
	private JPanel lessonPanel;	
	private JButton audioButton, videoButton,testButton, backButton;
	
	public lessonChoices() {
		audioButton = new JButton("Text");
		audioButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		videoButton = new JButton("Video");
		videoButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		testButton = new JButton("Assessments");
		testButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		backButton = new JButton("BACK");
		backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		//create my panel that will only contain my name
		lessonPanel = new JPanel();
		lessonPanel.setLayout(new GridLayout(1,2));
		lessonPanel.add(audioButton);
		lessonPanel.add(videoButton);
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		//lessons type
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 0;
		c.ipadx = 800;
		c.ipady = 30;
		c.weighty = 1.0;
		c.insets = new Insets(100,0,50,0);
		add(lessonPanel,c);
		
		//go to test button
		c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 1;
		c.ipadx = 100;
		c.ipady = 40;
		c.weightx = 0.0;
		c.weighty = 1.0;
		c.insets = new Insets(300,0,20,0);
		add(testButton,c);
		
		//back Button
		c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 2;
		c.ipadx = 50;
		c.ipady = 20;
		c.weightx = 0.0;
		c.weighty = 1.0;
		c.insets = new Insets(10,300,10,300);
		add(backButton,c);
		
		videoButton.addActionListener(new ActionListener() {
 			public void actionPerformed(ActionEvent e) {
 				if (videoButton.isEnabled()) {
 				}
 			}
 		});
		audioButton.addActionListener(new ActionListener() {
 			public void actionPerformed(ActionEvent e) {
 				if (audioButton.isEnabled()) {
 					removeAll();
 					revalidate();
 					repaint();
 					textLesson text = new textLesson();
 					add(text);
 				}
 			}
		});
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
							Assessor quiz = new Assessor();
							quiz.questionOne();
							add(quiz);
							revalidate();
							repaint();
						}
					}
				});
	}
}
