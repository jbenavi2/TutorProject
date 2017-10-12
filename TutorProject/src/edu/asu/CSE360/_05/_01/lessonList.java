package edu.asu.CSE360._05._01;


import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class lessonList extends JPanel {

	//button and drop down box
	private JButton goButton;
	private JComboBox lessonList;
	//picture of gordon
	private ImageIcon gordon1;
	private JLabel gordonLabel;
	
	//acessor method to keep track of lesson choice
	public static int lessonChoice = 0;
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
		lessonList.setFont(new Font("Arial", Font.PLAIN,20));
		((JLabel)lessonList.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);

		
		//Button To Move to next screen
		JButton goButton = new JButton("GO!");
		goButton.setFont(new Font("Arial", Font.PLAIN,40));
		
		//picture of the very talented Gordon Ramsey
		gordon1 = new ImageIcon("resources/gr1.png");
		gordonLabel = new JLabel("", gordon1, JLabel.CENTER);
		gordonLabel.setSize(getMinimumSize());
		
		//Jpanel holds drop down menu and "Go button"
		JPanel chooseLessonPanel = new JPanel();
		chooseLessonPanel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		

		
		//lessons list
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 40;
		c.ipadx = 600;
		c.gridx = 1;
		c.gridy = 0;
		c.insets = new Insets(0,275,0,300);
		chooseLessonPanel.add(lessonList,c);
		
		//go Button
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 50;
		c.ipadx = 100;
		c.gridx = 1;
		c.gridy = 1;
		c.insets = new Insets(50,475,0,500);
		chooseLessonPanel.add(goButton, c);
		
		//gordon
		c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 2;
		c.insets = new Insets(10,100,0,100);
		chooseLessonPanel.add(gordonLabel, c);

		
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
