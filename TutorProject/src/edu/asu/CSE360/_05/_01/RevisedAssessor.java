

package edu.asu.CSE360._05._01;

/**

* Description:
* 	First Quiz.  Uses Combination of Multiple Choice, T/F, Multiple Answers, and 
* 	single response type questions
* 	
* 	An animated companion provides feedback
* 
* 	Immediate grade at end of quiz
* 
* 	correct and incorrect answers as well as time spend on quiz are stored in 
* 	Control Center
* 
* Assignment number:
* 	Recitation Project 4
* Completion time:
* 	5 Hours
*
* @author Javier Benavides
* @version 1
*/

import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.TimeUnit;
import javax.swing.*;

import java.util.ArrayList;
import java.util.Observer;
import java.util.Timer;

public class RevisedAssessor extends JPanel{
	double correct = 0;		//keep score of questions answered correctly
	double incorrect = 0;
	double startTime = 0;
	double stopTime = 0;
	double totalTime = 0;
	
	private CompanionPanel companion;	
	private JPanel entirePanel;
	private JPanel panelQuestion;
	
	
	private JLabel labelQuestion;
	
	private JRadioButton RBoption1, RBoption2, RBoption3;
	
	private JButton next, submit, goBack;
	
	//default constructor
	public RevisedAssessor() {
		setBackground(Color.DARK_GRAY);
		setLayout(null);		
		
		
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
		FireCompanion fire = new FireCompanion();
		fire.add(basic);
		companion.setCompanion(fire);
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
		
		/*ADD ACTION LISTENER TO NEXT BUTTON*/
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				startTime = System.currentTimeMillis();
				removeAll();
				setLayout(new BorderLayout());
				questionOne();
				//revalidate();
				//repaint();
			}
		});
	}
	
	public void questionOne() {
		//create question
		labelQuestion = new JLabel("What is the optimal ratio of rice to water?");
		labelQuestion.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		//radio buttons with possible answers
		RBoption1 = new JRadioButton("1:2");
		RBoption2 = new JRadioButton("1:1");
		RBoption3 = new JRadioButton("1:3");
		
		ButtonGroup group = new ButtonGroup();
		group.add(RBoption1);
		group.add(RBoption2);
		group.add(RBoption3);
		
		//place questions and options in same panel
		JPanel questionAnswer = new JPanel();
		questionAnswer.setLayout(new BoxLayout(questionAnswer, BoxLayout.Y_AXIS));
		questionAnswer.add(labelQuestion);
		questionAnswer.add(RBoption1);
		questionAnswer.add(RBoption2);
		questionAnswer.add(RBoption3);
		
		//initiate companion
		CompanionPanel companion2 = new CompanionPanel();
		BasicCompanion basic = new BasicCompanion();
		ThinkingCompanion thinking = new ThinkingCompanion();
		
		thinking.add(basic);
		companion2.setCompanion(thinking);
		companion2.showYourself();
		
		//panel to hold questions and avatar
		JPanel questionAvatar = new JPanel();
		questionAvatar.setLayout(new BoxLayout(questionAvatar, BoxLayout.X_AXIS));
		
		questionAvatar.add(questionAnswer);
		questionAvatar.add(companion2);
		
		//create submit and next buttons
		submit = new JButton("Submit");
		next = new JButton("Next");
		next.setEnabled(false);
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
		buttonPanel.add(submit);
		buttonPanel.add(next);
		
		//put it all together
		JPanel entirePanel = new JPanel();
		entirePanel.setLayout(new BoxLayout(entirePanel, BoxLayout.Y_AXIS));
		entirePanel.add(questionAvatar);
		entirePanel.add(buttonPanel);
		
		add(entirePanel);
		entirePanel.updateUI();
		
		//add ActionListeners
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {	
				if(RBoption2.isSelected()) {
					correct++;
					HappyCompanion happy = new HappyCompanion();
					happy.add(basic);
					companion2.setCompanion(happy);
					companion2.showYourself();
					entirePanel.updateUI();
				}
				else {
					incorrect++;
					SorryCompanion sorry = new SorryCompanion();
					sorry.add(basic);
					companion2.setCompanion(sorry);
					companion2.showYourself();
					entirePanel.updateUI();
				}
				submit.setEnabled(false);
				next.setEnabled(true);
			}
		});
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				removeAll();
				setLayout(new BorderLayout());
				questionTwo();
			}
		});
	}
	
	public void questionTwo() {
		//create question
		labelQuestion = new JLabel("How much off the top should you cut from an Onion?");
		labelQuestion.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		//radio buttons with possible answers
		RBoption1 = new JRadioButton("1/2 inch");
		RBoption2 = new JRadioButton("1 inch");
		RBoption3 = new JRadioButton("0 inch");
		
		ButtonGroup group = new ButtonGroup();
		group.add(RBoption1);
		group.add(RBoption2);
		group.add(RBoption3);
		
		//place questions and options in same panel
		JPanel questionAnswer = new JPanel();
		questionAnswer.setLayout(new BoxLayout(questionAnswer, BoxLayout.Y_AXIS));
		questionAnswer.add(labelQuestion);
		questionAnswer.add(RBoption1);
		questionAnswer.add(RBoption2);
		questionAnswer.add(RBoption3);
		
		//initiate companion
		CompanionPanel companion2 = new CompanionPanel();
		BasicCompanion basic = new BasicCompanion();
		ThinkingCompanion thinking = new ThinkingCompanion();
		
		thinking.add(basic);
		companion2.setCompanion(thinking);
		companion2.showYourself();
		
		//panel to hold questions and avatar
		JPanel questionAvatar = new JPanel();
		questionAvatar.setLayout(new BoxLayout(questionAvatar, BoxLayout.X_AXIS));
		
		questionAvatar.add(questionAnswer);
		questionAvatar.add(companion2);
		
		//create submit and next buttons
		submit = new JButton("Submit");
		next = new JButton("Next");
		next.setEnabled(false);
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
		buttonPanel.add(submit);
		buttonPanel.add(next);
		
		//put it all together
		JPanel entirePanel = new JPanel();
		entirePanel.setLayout(new BoxLayout(entirePanel, BoxLayout.Y_AXIS));
		entirePanel.add(questionAvatar);
		entirePanel.add(buttonPanel);
		
		add(entirePanel);
		entirePanel.updateUI();
		
		//add ActionListeners
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if(RBoption1.isSelected()) {
					correct++;
					HappyCompanion happy = new HappyCompanion();
					happy.add(basic);
					companion2.setCompanion(happy);
					companion2.showYourself();
					entirePanel.updateUI();
				}
				else {
					incorrect++;
					SorryCompanion sorry = new SorryCompanion();
					sorry.add(basic);
					companion2.setCompanion(sorry);
					companion2.showYourself();
					entirePanel.updateUI();
				}
				submit.setEnabled(false);
				next.setEnabled(true);
			}
		});
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				removeAll();
				setLayout(new BorderLayout());
				questionThree();
			}
		});
	}
	
	public void questionThree() {
		//create question
		labelQuestion = new JLabel("How often should you sharpen your knives?");
		labelQuestion.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		//radio buttons with possible answers
		RBoption1 = new JRadioButton("Never");
		RBoption2 = new JRadioButton("Once a Year");
		RBoption3 = new JRadioButton("Twice a Year");
		
		ButtonGroup group = new ButtonGroup();
		group.add(RBoption1);
		group.add(RBoption2);
		group.add(RBoption3);
		
		//place questions and options in same panel
		JPanel questionAnswer = new JPanel();
		questionAnswer.setLayout(new BoxLayout(questionAnswer, BoxLayout.Y_AXIS));
		questionAnswer.add(labelQuestion);
		questionAnswer.add(RBoption1);
		questionAnswer.add(RBoption2);
		questionAnswer.add(RBoption3);
		
		//initiate companion
		CompanionPanel companion2 = new CompanionPanel();
		BasicCompanion basic = new BasicCompanion();
		ThinkingCompanion thinking = new ThinkingCompanion();
		
		thinking.add(basic);
		companion2.setCompanion(thinking);
		companion2.showYourself();
		
		//panel to hold questions and avatar
		JPanel questionAvatar = new JPanel();
		questionAvatar.setLayout(new BoxLayout(questionAvatar, BoxLayout.X_AXIS));
		
		questionAvatar.add(questionAnswer);
		questionAvatar.add(companion2);
		
		//create submit and next buttons
		submit = new JButton("Submit");
		next = new JButton("Next");
		next.setEnabled(false);
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
		buttonPanel.add(submit);
		buttonPanel.add(next);
		
		//put it all together
		JPanel entirePanel = new JPanel();
		entirePanel.setLayout(new BoxLayout(entirePanel, BoxLayout.Y_AXIS));
		entirePanel.add(questionAvatar);
		entirePanel.add(buttonPanel);
		
		add(entirePanel);
		entirePanel.updateUI();
		
		//add ActionListeners
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if(RBoption3.isSelected()) {
					correct++;
					HappyCompanion happy = new HappyCompanion();
					happy.add(basic);
					companion2.setCompanion(happy);
					companion2.showYourself();
					entirePanel.updateUI();
				}
				else {
					incorrect++;
					SorryCompanion sorry = new SorryCompanion();
					sorry.add(basic);
					companion2.setCompanion(sorry);
					companion2.showYourself();
					entirePanel.updateUI();
				}
				submit.setEnabled(false);
				next.setEnabled(true);
			}
		});
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				removeAll();
				setLayout(new BorderLayout());
				questionFour();
			}
		});
	}
	
	public void questionFour() {
		//create question
		labelQuestion = new JLabel("How soon should fresh fish be cooked?");
		labelQuestion.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		//radio buttons with possible answers
		RBoption1 = new JRadioButton("Within the Week");
		RBoption2 = new JRadioButton("Within the Day");
		RBoption3 = new JRadioButton("Within the Month");
		
		ButtonGroup group = new ButtonGroup();
		group.add(RBoption1);
		group.add(RBoption2);
		group.add(RBoption3);
		
		//place questions and options in same panel
		JPanel questionAnswer = new JPanel();
		questionAnswer.setLayout(new BoxLayout(questionAnswer, BoxLayout.Y_AXIS));
		questionAnswer.add(labelQuestion);
		questionAnswer.add(RBoption1);
		questionAnswer.add(RBoption2);
		questionAnswer.add(RBoption3);
		
		//initiate companion
		CompanionPanel companion2 = new CompanionPanel();
		BasicCompanion basic = new BasicCompanion();
		ThinkingCompanion thinking = new ThinkingCompanion();
		
		thinking.add(basic);
		companion2.setCompanion(thinking);
		companion2.showYourself();
		
		//panel to hold questions and avatar
		JPanel questionAvatar = new JPanel();
		questionAvatar.setLayout(new BoxLayout(questionAvatar, BoxLayout.X_AXIS));
		
		questionAvatar.add(questionAnswer);
		questionAvatar.add(companion2);
		
		//create submit and next buttons
		submit = new JButton("Submit");
		next = new JButton("Next");
		next.setEnabled(false);
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
		buttonPanel.add(submit);
		buttonPanel.add(next);
		
		//put it all together
		JPanel entirePanel = new JPanel();
		entirePanel.setLayout(new BoxLayout(entirePanel, BoxLayout.Y_AXIS));
		entirePanel.add(questionAvatar);
		entirePanel.add(buttonPanel);
		
		add(entirePanel);
		entirePanel.updateUI();
		
		//add ActionListeners
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if(RBoption2.isSelected()) {
					correct++;
					HappyCompanion happy = new HappyCompanion();
					happy.add(basic);
					companion2.setCompanion(happy);
					companion2.showYourself();
					entirePanel.updateUI();
				}
				else {
					incorrect++;
					SorryCompanion sorry = new SorryCompanion();
					sorry.add(basic);
					companion2.setCompanion(sorry);
					companion2.showYourself();
					entirePanel.updateUI();
				}
				submit.setEnabled(false);
				next.setEnabled(true);
			}
		});
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				removeAll();
				setLayout(new BorderLayout());
				questionFive();
			}
		});
	}
	
	public void questionFive() {
		//create question
		labelQuestion = new JLabel("What texture should the pasta have?");
		labelQuestion.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		//radio buttons with possible answers
		RBoption1 = new JRadioButton("Soft");
		RBoption2 = new JRadioButton("Firm");
		RBoption3 = new JRadioButton("Crunchy");
		
		ButtonGroup group = new ButtonGroup();
		group.add(RBoption1);
		group.add(RBoption2);
		group.add(RBoption3);
		
		//place questions and options in same panel
		JPanel questionAnswer = new JPanel();
		questionAnswer.setLayout(new BoxLayout(questionAnswer, BoxLayout.Y_AXIS));
		questionAnswer.add(labelQuestion);
		questionAnswer.add(RBoption1);
		questionAnswer.add(RBoption2);
		questionAnswer.add(RBoption3);
		
		//initiate companion
		CompanionPanel companion2 = new CompanionPanel();
		BasicCompanion basic = new BasicCompanion();
		ThinkingCompanion thinking = new ThinkingCompanion();
		
		thinking.add(basic);
		companion2.setCompanion(thinking);
		companion2.showYourself();
		
		//panel to hold questions and avatar
		JPanel questionAvatar = new JPanel();
		questionAvatar.setLayout(new BoxLayout(questionAvatar, BoxLayout.X_AXIS));
		
		questionAvatar.add(questionAnswer);
		questionAvatar.add(companion2);
		
		//create submit and next buttons
		submit = new JButton("Submit");
		next = new JButton("Next");
		next.setEnabled(false);
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
		buttonPanel.add(submit);
		buttonPanel.add(next);
		
		//put it all together
		JPanel entirePanel = new JPanel();
		entirePanel.setLayout(new BoxLayout(entirePanel, BoxLayout.Y_AXIS));
		entirePanel.add(questionAvatar);
		entirePanel.add(buttonPanel);
		
		add(entirePanel);
		entirePanel.updateUI();
		
		//add ActionListeners
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if(RBoption2.isSelected()) {
					correct++;
					HappyCompanion happy = new HappyCompanion();
					happy.add(basic);
					companion2.setCompanion(happy);
					companion2.showYourself();
					entirePanel.updateUI();
				}
				else {
					incorrect++;
					SorryCompanion sorry = new SorryCompanion();
					sorry.add(basic);
					companion2.setCompanion(sorry);
					companion2.showYourself();
					entirePanel.updateUI();
				}
				submit.setEnabled(false);
				next.setEnabled(true);
			}
		});
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				stopTime = System.currentTimeMillis();
				totalTime = (stopTime - startTime) / 1000;
				removeAll();
				setLayout(new BorderLayout());
				results(correct, incorrect, totalTime);
			}
		});
	}
	
	public void results(double correct, double incorrect, double time) {
		
		//initiate controlCenter
		ControlCenter session = ControlCenter.getInstance();
		session.lessonOneInput(correct, incorrect, time);
		
		JLabel practiceResult = new JLabel("RESULTS");
		practiceResult.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		//Generate a percent score
		float percentage = ((float) correct/5)*100;
		String grade = Float.toString(percentage)+"%";
		JLabel showGrade = new JLabel(grade);
		
		//Generate avatar based on score
		BasicCompanion basic = new BasicCompanion();
		HappyCompanion happy = new HappyCompanion();
		WorriedCompanion worried = new WorriedCompanion();
		
		if(percentage >= 70.0) {
			happy.add(basic);
			companion.setCompanion(happy);
			companion.showYourself();
			companion.updateUI();
		}
		else {
			worried.add(basic);
			companion.setCompanion(worried);
			companion.showYourself();
			companion.updateUI();
		}
		
		//group grade and Avatar together
		JPanel gradeAvatar = new JPanel();
		gradeAvatar.setLayout(new GridLayout(1,2));
		gradeAvatar.add(showGrade);
		gradeAvatar.add(companion);
		
		JButton back = new JButton("BACK");
		
		entirePanel = new JPanel();
		entirePanel.setLayout(new BoxLayout(entirePanel, BoxLayout.Y_AXIS));
		entirePanel.add(practiceResult);
		entirePanel.add(gradeAvatar);
		entirePanel.add(back);
		
		add(entirePanel);
		entirePanel.updateUI();
		
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if(back.isEnabled()) {
					removeAll();
					lessonList lesson = new lessonList();
					add(lesson);
					revalidate();
					repaint();
				}
			}
		});
		
	}
}
