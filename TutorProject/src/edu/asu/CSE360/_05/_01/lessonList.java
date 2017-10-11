package edu.asu.CSE360._05._01;


import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class lessonList extends JPanel {
	public static int lessonChoice = 0;
	private JButton goButton;
	private JComboBox lessonList;
		
	public static void changeLessonChoice(int x) {
		lessonChoice = x;
	}
	
	public static int checkLessonChoice() {
		return lessonChoice;
	}
	
	public lessonList() {
		//Drop down menu for lessons
		String[] lessons = {"Select A Lesson...", "Basics of Cooking"};
		JComboBox lessonList = new JComboBox(lessons);
		lessonList.setSelectedIndex(0);

		//Button To Move to next screen
		JButton goButton = new JButton("GO!");
		goButton.setFont(new Font("Arial", Font.PLAIN,40));
		//Jpanel holds drop down menu and "Go button"
		JPanel chooseLessonPanel = new JPanel();
		chooseLessonPanel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		//lessons list
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.0;
		c.weighty = 1.0;
		c.ipady = 40;
		c.ipadx = 600;
		c.gridwidth = 2;
		c.gridx = 1;
		c.gridy = 1;
		chooseLessonPanel.add(lessonList,c);
		
		//go Button
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 50;
		c.ipadx = 100;
		c.weighty = 2.0;
		c.gridx = 1;
		c.gridy = 2;
		c.insets = new Insets(0,500,0,500);
		chooseLessonPanel.add(goButton, c);
		
		//Create JFrame to hold content and add close operation
		setLayout(new BorderLayout());
		add(chooseLessonPanel,BorderLayout.CENTER);
		
		//variable to hold choice
		//action listener for drop down menu
		lessonList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (lessonList.getSelectedItem() == "Basics of Cooking") {
					changeLessonChoice(1);
				}
				else {
					changeLessonChoice(0);
				}
			}
		});
		goButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (goButton.isEnabled()) {
					if (checkLessonChoice() == 1) {
						removeAll();
						//revalidate/repaint
						revalidate();
						repaint();
						lessonChoices lessonPanel = new lessonChoices();
						//add to frame
						add(lessonPanel);
					}
				}
			}
		});
	}
}
