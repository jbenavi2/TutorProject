package edu.asu.CSE360._05._01;

import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.TimeUnit;
import javax.swing.*;

public class RevisedAssessor extends JPanel{
	int correct = 0;		//keep score of questions answered correctly
	int incorrect = 0;
	
	
	private CompanionPanel companion;	
	private JPanel entirePanel;
	private JPanel panelQuestion;
	
	
	private JLabel labelQuestion;
	
	private JRadioButton RBoption1, RBoption2, RBoption3;
	
	private JButton next, submit, goBack;
	
	
	
	
	//default constructor
	public RevisedAssessor() {
		setLayout(null);
		//entirePanel = new JPanel();
		
		//ask user if they are ready
		//panelQuestion = new JPanel();
		//panelQuestion.setBounds(10, 11, 328, 264);
		//add(panelQuestion);
		//panelQuestion.setLayout(new GridLayout(0, 1, 0, 0));
		
		labelQuestion = new JLabel("ARE YOU READY TO ENTER HELL'S KITCHEN?");
		labelQuestion.setAlignmentX(Component.CENTER_ALIGNMENT);
		labelQuestion.setBounds(504, 528, 257, 53);		
		add(labelQuestion);
		
		//initiate companion
		companion = new CompanionPanel();
		companion.setBounds(436, 40, 450, 470);
		companion.setLayout(new GridLayout(0, 1, 0, 0));
		add(companion);
		BasicCompanion basic = new BasicCompanion();
		companion.setCompanion(basic);
		companion.showYourself();
		
		//add proceed or return buttons
		goBack = new JButton("No, I'm scared!");
		goBack.setBounds(464, 603, 119, 23);
		add(goBack);
		
		next = new JButton("Yes");
		next.setBounds(688, 603, 89, 23);
		add(next);		
		
		//add actionListeners to buttons
		goBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if(goBack.isEnabled()) {
					removeAll();
					setLayout(new BorderLayout());
					TutorOptions tutorChoice = new TutorOptions();
					add(tutorChoice, BorderLayout.CENTER);
					revalidate();
					repaint();
				}
			}
		});
		
		
	}

}
