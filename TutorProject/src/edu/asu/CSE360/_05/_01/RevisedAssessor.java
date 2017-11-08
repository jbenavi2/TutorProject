package edu.asu.CSE360._05._01;

import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.TimeUnit;
import javax.swing.*;

public class RevisedAssessor extends JPanel{
	int score = 0;
	
	private CompanionPanel companion;
	
	private JPanel defaultPanel;
	private JPanel panelQuestion;
	
	private JLabel labelQuestion;
	
	private JRadioButton RBoption1, RBoption2, RBoption3;
	
	//default constructor
	public RevisedAssessor() {
		
		defaultPanel = new JPanel();
		defaultPanel.setLayout(new GridLayout(1,2));
		
		//ask user if they are ready
		labelQuestion = new JLabel("ARE YOU READY?");
		labelQuestion.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		//initiate companion
		companion = new CompanionPanel();
		BasicCompanion basic = new BasicCompanion();
		companion.setCompanion(basic);
		companion.showYourself();
		
		
		defaultPanel.add(labelQuestion);
		defaultPanel.add(companion);
		
		add(defaultPanel);
		
	}

}
