/*package edu.asu.CSE360._05._01;
*//**
* 10 question will be displayed.  One on each slider
* with different option styles for selecting answers.
* Those option styles include using a Jradiobuttons, checkboxes,
* buttons, and a textfield.
* Recitation Project 3
* Completion time: 10 hours
*
* @author Javier Benavides
* @version 1.0
*//*


import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.TimeUnit;

import javax.swing.*;


//Javier Benavides
@SuppressWarnings("serial")
public class Assessor extends JPanel{
	
	// initial score when program starts.	
	int score = 0;
	
	//Grid Layout to hold Questions and Avatar
	private JPanel questionAvatar;	
	
	// The panels for questions
	private JPanel panelDefault;
	private JPanel panelQuestion;
	
	// The title labels for each panel
	private JLabel myName;
	private JLabel labelQuestion1;
	private JLabel labelQuestion2;
	
	
	//Jradio buttons for answer options
	private JRadioButton RBoption1, RBoption2, RBoption3;
	
	// checkboxes for Question
	private JCheckBox chkBoxOption1, chkBoxOption2, chkBoxOption3, chkBoxOption4;
	
	
	// buttons for Next and Submit
	private JButton next, submit;
	
	// textfield for Question 4
	private JTextField textField;
	
	//default constructor
	public Assessor() {
		
		//initialize the outer grid to contain question and avatar
		questionAvatar = new JPanel();
		questionAvatar.setLayout(new GridLayout(1,2));
		
		//create my label that only show my name
		myName = new JLabel("Javier Benavides");
		myName.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		//initialize the Companion class for the avatar. initial state 0
		Companion companionDefault = new Companion();
		
		//add myName and companion to questionAvatar layout
		questionAvatar.add(myName);
		questionAvatar.add(companionDefault);
		
		//create submit and back buttons
		submit = new JButton("Submit");
		submit.setPreferredSize(new Dimension(40,40));
		next = new JButton("Next");
		next.setPreferredSize(new Dimension(40,40));
		
		//create panel to hold buttons
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
//		buttonPanel.setLayout(new CardLayout());
		
		//add buttons to panel
		buttonPanel.add(submit);
		buttonPanel.add(next);
		
		//create my panel that will contain questionAvatar and submit/next buttons
		panelDefault = new JPanel();
		panelDefault.setLayout(new BoxLayout(panelDefault, BoxLayout.Y_AXIS));
		panelDefault.add(questionAvatar);
		panelDefault.add(buttonPanel);
		setLayout(new BorderLayout());
		add(panelDefault);
	}
	
	public void results(int score) {
		JLabel practiceResult = new JLabel("RESULTS");
		practiceResult.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		//Generate a percent score
		float percentage = ((float) score/10)*100;
		String grade = Float.toString(percentage)+"%";
		JLabel showGrade = new JLabel(grade);
		
		//Generate avatar based on score
		Companion emotion = new Companion();
		if(percentage >= 70.0) {
			emotion.changeState(1);
		}
		else {
			emotion.changeState(3);
		}
		
		//group grade and Avatar together
		JPanel gradeAvatar = new JPanel();
		gradeAvatar.setLayout(new GridLayout(1,2));
		gradeAvatar.add(showGrade);
		gradeAvatar.add(emotion);
		
		JButton back = new JButton("BACK");
		
		panelDefault = new JPanel();
		panelDefault.setLayout(new BoxLayout(panelDefault, BoxLayout.Y_AXIS));
		panelDefault.add(practiceResult);
		panelDefault.add(gradeAvatar);
		panelDefault.add(back);
		
		add(panelDefault);
		panelDefault.updateUI();
		
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
	
	public void questionOne() {
		
		//create my label
		labelQuestion1 =  new JLabel("Question 1");
		labelQuestion1.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		//generate the first question
		JLabel practiceQuestion_1 = new JLabel(
				"How do you put out a grease fire?");
		
		//create radiobutton answer options and group them
		RBoption1 = new JRadioButton("with water");
		RBoption2 = new JRadioButton("smother with baking soda");
		RBoption3 = new JRadioButton("blow on it");
		
		ButtonGroup group = new ButtonGroup();
		group.add(RBoption1);
		group.add(RBoption2);
		group.add(RBoption3);		
		
		//place questions and options in same panel
		JPanel questionAnswer = new JPanel();
		questionAnswer.setLayout(new BoxLayout(questionAnswer, BoxLayout.Y_AXIS));
		questionAnswer.add(practiceQuestion_1);
		questionAnswer.add(RBoption1);
		questionAnswer.add(RBoption2);
		questionAnswer.add(RBoption3);
		
		//initiate avatar.  initial state thinking
		Companion thinking = new Companion();
		thinking.changeState(2);
		
		//place question question and avatar in a panel with grid layout
		questionAvatar = new JPanel();
		questionAvatar.setLayout(new BoxLayout(questionAvatar, BoxLayout.X_AXIS));
		
		questionAvatar.add(questionAnswer);
		questionAvatar.add(thinking);
		
		//create sumbit and next buttons
		submit = new JButton("Submit");
		next = new JButton("Next");
		next.setEnabled(false);
		
		//create panel to hold buttons
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
		
		//add buttons to buttonPanel
		buttonPanel.add(submit);
		buttonPanel.add(next);		

		
		//create my panel for when in state 1
		panelQuestion = new JPanel();
		panelQuestion.setLayout(new BoxLayout(panelQuestion, BoxLayout.Y_AXIS));
		panelQuestion.add(labelQuestion1);
		panelQuestion.add(questionAvatar);
		panelQuestion.add(buttonPanel);
		
		add(panelQuestion);
		
		//add actionListener to buttons
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if(RBoption2.isSelected()) {
					score++;
					questionAvatar.remove(thinking);
					Companion happy = new Companion();
					happy.changeState(1);
					questionAvatar.add(happy);
					panelQuestion.updateUI();
				}
				else {
					questionAvatar.remove(thinking);
					Companion sorry = new Companion();
					sorry.changeState(4);
					questionAvatar.add(sorry);
					panelQuestion.updateUI();
				}
				submit.setEnabled(false);
				next.setEnabled(true);
				
			}
		});
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				remove(panelQuestion);
				questionTwo();
				
			}				
		});
		
	}
	
	public void questionTwo() {
		labelQuestion2 = new JLabel("Question 2");
		labelQuestion2.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		//generate Question 2
		JLabel practiceQuestion_2 = new JLabel(
				"How are shrimps categorized?");
		
		//radiobuttons for answer options
		RBoption1 = new JRadioButton("By size");
		RBoption2 = new JRadioButton("By expiration date");
		RBoption3 = new JRadioButton("By quality");
		
		ButtonGroup group = new ButtonGroup();
		group.add(RBoption1);
		group.add(RBoption2);
		group.add(RBoption3);
		
		//place questions and options in same panel
		JPanel questionAnswer = new JPanel();
		questionAnswer.setLayout(new BoxLayout(questionAnswer, BoxLayout.Y_AXIS));
		questionAnswer.add(practiceQuestion_2);
		questionAnswer.add(RBoption1);
		questionAnswer.add(RBoption2);
		questionAnswer.add(RBoption3);
		
		//initiate avatar.  intial thinking
		Companion thinking = new Companion();
		thinking.changeState(2);
		
		//place questionAnswer and Avatar in same panel
		questionAvatar = new JPanel();
		questionAvatar.setLayout(new BoxLayout(questionAvatar, BoxLayout.X_AXIS));
		
		questionAvatar.add(questionAnswer);
		questionAvatar.add(thinking);
		
		//submit and next buttons
		submit = new JButton("Submit");
		next = new JButton("Next");
		next.setEnabled(false);
		
		//create panel to hold buttons
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
		//add buttons to panel
		buttonPanel.add(submit);
		buttonPanel.add(next);
		
		//put it all together in the same panel
		panelQuestion = new JPanel();
		panelQuestion.setLayout(new BoxLayout(panelQuestion, BoxLayout.Y_AXIS));
		panelQuestion.add(labelQuestion2);
		panelQuestion.add(questionAvatar);
		panelQuestion.add(buttonPanel);
		
		add(panelQuestion);
		panelQuestion.updateUI();
		
		//add ActionListener to buttons
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if(RBoption1.isSelected()) {
					score++;
					questionAvatar.remove(thinking);
					Companion happy = new Companion();
					happy.changeState(1);
					questionAvatar.add(happy);
					panelQuestion.updateUI();
				}
				else {
					questionAvatar.remove(thinking);
					Companion sorry = new Companion();
					sorry.changeState(4);
					questionAvatar.add(sorry);
					panelQuestion.updateUI();
				}
				submit.setEnabled(false);
				next.setEnabled(true);
			}
		});
		
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				remove(panelQuestion);
				questionThree();
			}
		});
		
	}
	
	public void questionThree() {
		labelQuestion2 = new JLabel("Question 3");
		labelQuestion2.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		//generate Question 2
		JLabel practiceQuestion_3 = new JLabel(
				"What oil has the highest smoking point?");
		
		//radiobuttons for answer options
		RBoption1 = new JRadioButton("Peanut Oil");
		RBoption2 = new JRadioButton("Olive Oil");
		RBoption3 = new JRadioButton("Avocado Oil");
		
		ButtonGroup group = new ButtonGroup();
		group.add(RBoption1);
		group.add(RBoption2);
		group.add(RBoption3);
		
		//place questions and options in same panel
		JPanel questionAnswer = new JPanel();
		questionAnswer.setLayout(new BoxLayout(questionAnswer, BoxLayout.Y_AXIS));
		questionAnswer.add(practiceQuestion_3);
		questionAnswer.add(RBoption1);
		questionAnswer.add(RBoption2);
		questionAnswer.add(RBoption3);
		
		//initiate avatar.  intial thinking
		Companion thinking = new Companion();
		thinking.changeState(2);
		
		//place questionAnswer and Avatar in same panel
		questionAvatar = new JPanel();
		questionAvatar.setLayout(new BoxLayout(questionAvatar, BoxLayout.X_AXIS));
		
		questionAvatar.add(questionAnswer);
		questionAvatar.add(thinking);
		
		//submit and next buttons
		submit = new JButton("Submit");
		next = new JButton("Next");
		next.setEnabled(false);
		
		//create panel to hold buttons
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
		//add buttons to panel
		buttonPanel.add(submit);
		buttonPanel.add(next);
		
		//put it all together in the same panel
		panelQuestion = new JPanel();
		panelQuestion.setLayout(new BoxLayout(panelQuestion, BoxLayout.Y_AXIS));
		panelQuestion.add(labelQuestion2);
		panelQuestion.add(questionAvatar);
		panelQuestion.add(buttonPanel);
		
		add(panelQuestion);
		panelQuestion.updateUI();
		
		//add ActionListener to buttons
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if(RBoption3.isSelected()) {
					score++;
					questionAvatar.remove(thinking);
					Companion happy = new Companion();
					happy.changeState(1);
					questionAvatar.add(happy);
					panelQuestion.updateUI();
				}
				else {
					questionAvatar.remove(thinking);
					Companion sorry = new Companion();
					sorry.changeState(4);
					questionAvatar.add(sorry);
					panelQuestion.updateUI();
				}
				submit.setEnabled(false);
				next.setEnabled(true);
			}
		});
		
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				remove(panelQuestion);
				questionFour();
			}
		});
	}
	
	public void questionFour() {
		labelQuestion2 = new JLabel("Question 4");
		labelQuestion2.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		//generate Question 2
		JLabel practiceQuestion_4 = new JLabel(
				"When you poach something, you cook it with what?");
		
		//radiobuttons for answer options
		RBoption1 = new JRadioButton("Vegetables");
		RBoption2 = new JRadioButton("Liquid");
		RBoption3 = new JRadioButton("Oil");
		
		ButtonGroup group = new ButtonGroup();
		group.add(RBoption1);
		group.add(RBoption2);
		group.add(RBoption3);
		
		//place questions and options in same panel
		JPanel questionAnswer = new JPanel();
		questionAnswer.setLayout(new BoxLayout(questionAnswer, BoxLayout.Y_AXIS));
		questionAnswer.add(practiceQuestion_4);
		questionAnswer.add(RBoption1);
		questionAnswer.add(RBoption2);
		questionAnswer.add(RBoption3);
		
		//initiate avatar.  intial thinking
		Companion thinking = new Companion();
		thinking.changeState(2);
		
		//place questionAnswer and Avatar in same panel
		questionAvatar = new JPanel();
		questionAvatar.setLayout(new BoxLayout(questionAvatar, BoxLayout.X_AXIS));
		
		questionAvatar.add(questionAnswer);
		questionAvatar.add(thinking);
		
		//submit and next buttons
		submit = new JButton("Submit");
		next = new JButton("Next");
		next.setEnabled(false);
		
		//create panel to hold buttons
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
		//add buttons to panel
		buttonPanel.add(submit);
		buttonPanel.add(next);
		
		//put it all together in the same panel
		panelQuestion = new JPanel();
		panelQuestion.setLayout(new BoxLayout(panelQuestion, BoxLayout.Y_AXIS));
		panelQuestion.add(labelQuestion2);
		panelQuestion.add(questionAvatar);
		panelQuestion.add(buttonPanel);
		
		add(panelQuestion);
		panelQuestion.updateUI();
		
		//add ActionListener to buttons
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if(RBoption2.isSelected()) {
					score++;
					questionAvatar.remove(thinking);
					Companion happy = new Companion();
					happy.changeState(1);
					questionAvatar.add(happy);
					panelQuestion.updateUI();
				}
				else {
					questionAvatar.remove(thinking);
					Companion sorry = new Companion();
					sorry.changeState(4);
					questionAvatar.add(sorry);
					panelQuestion.updateUI();
				}
				submit.setEnabled(false);
				next.setEnabled(true);
			}
		});
		
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				remove(panelQuestion);
				questionFive();
			}
		});
		
	}
	
	public void questionFive() {
		labelQuestion2 = new JLabel("Question 5");
		labelQuestion2.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		//generate Question 2
		JLabel practiceQuestion_5 = new JLabel(
				"What do you call the cook who makes sauces?");
		
		//radiobuttons for answer options
		RBoption1 = new JRadioButton("Sommelier");
		RBoption2 = new JRadioButton("Saucier");
		RBoption3 = new JRadioButton("Sauce Guy");
		
		ButtonGroup group = new ButtonGroup();
		group.add(RBoption1);
		group.add(RBoption2);
		group.add(RBoption3);
		
		//place questions and options in same panel
		JPanel questionAnswer = new JPanel();
		questionAnswer.setLayout(new BoxLayout(questionAnswer, BoxLayout.Y_AXIS));
		questionAnswer.add(practiceQuestion_5);
		questionAnswer.add(RBoption1);
		questionAnswer.add(RBoption2);
		questionAnswer.add(RBoption3);
		
		//initiate avatar.  intial thinking
		Companion thinking = new Companion();
		thinking.changeState(2);
		
		//place questionAnswer and Avatar in same panel
		questionAvatar = new JPanel();
		questionAvatar.setLayout(new BoxLayout(questionAvatar, BoxLayout.X_AXIS));
		
		questionAvatar.add(questionAnswer);
		questionAvatar.add(thinking);
		
		//submit and next buttons
		submit = new JButton("Submit");
		next = new JButton("Next");
		next.setEnabled(false);
		
		//create panel to hold buttons
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
		//add buttons to panel
		buttonPanel.add(submit);
		buttonPanel.add(next);
		
		//put it all together in the same panel
		panelQuestion = new JPanel();
		panelQuestion.setLayout(new BoxLayout(panelQuestion, BoxLayout.Y_AXIS));
		panelQuestion.add(labelQuestion2);
		panelQuestion.add(questionAvatar);
		panelQuestion.add(buttonPanel);
		
		add(panelQuestion);
		panelQuestion.updateUI();
		
		//add ActionListener to buttons
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if(RBoption2.isSelected()) {
					score++;
					questionAvatar.remove(thinking);
					Companion happy = new Companion();
					happy.changeState(1);
					questionAvatar.add(happy);
					panelQuestion.updateUI();
				}
				else {
					questionAvatar.remove(thinking);
					Companion sorry = new Companion();
					sorry.changeState(4);
					questionAvatar.add(sorry);
					panelQuestion.updateUI();
				}
				submit.setEnabled(false);
				next.setEnabled(true);
			}
		});
		
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				remove(panelQuestion);
				questionSix();
				//results(score);
			}
		});
		
	}
	
	public void questionSix() {
		
		labelQuestion2 = new JLabel("Question 6");
		labelQuestion2.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		//generate Question 2
		JLabel practiceQuestion_6 = new JLabel(
				"What is called \"Food of the gods\"?");
		
		//create textfield
		textField = new JTextField();
		textField.setAlignmentX(Component.CENTER_ALIGNMENT);
		
				
		//place questions and options in same panel
		JPanel questionAnswer = new JPanel();
		questionAnswer.setLayout(new BoxLayout(questionAnswer, BoxLayout.Y_AXIS));
		questionAnswer.add(practiceQuestion_6);
		questionAnswer.add(textField);
		
		//initiate avatar.  intial thinking
		Companion thinking = new Companion();
		thinking.changeState(2);
		
		//place questionAnswer and Avatar in same panel
		questionAvatar = new JPanel();
		questionAvatar.setLayout(new BoxLayout(questionAvatar, BoxLayout.X_AXIS));
		
		questionAvatar.add(questionAnswer);
		questionAvatar.add(thinking);
		
		//submit and next buttons
		submit = new JButton("Submit");
		next = new JButton("Next");
		next.setEnabled(false);
		
		//create panel to hold buttons
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
		//add buttons to panel
		buttonPanel.add(submit);
		buttonPanel.add(next);
		
		//put it all together in the same panel
		panelQuestion = new JPanel();
		panelQuestion.setLayout(new BoxLayout(panelQuestion, BoxLayout.Y_AXIS));
		panelQuestion.add(labelQuestion2);
		panelQuestion.add(questionAvatar);
		panelQuestion.add(buttonPanel);
		
		add(panelQuestion);
		panelQuestion.updateUI();
		
		//add ActionListener to buttons
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {				
				
				String text = textField.getText();
				String answer = "chocolate";
				if(text.toLowerCase().equals(answer)) {
					score++;
					questionAvatar.remove(thinking);
					Companion happy = new Companion();
					happy.changeState(1);
					questionAvatar.add(happy);
					panelQuestion.updateUI();
				}
				else {
					questionAvatar.remove(thinking);
					Companion sorry = new Companion();
					sorry.changeState(4);
					questionAvatar.add(sorry);
					panelQuestion.updateUI();
				}
				submit.setEnabled(false);
				next.setEnabled(true);
			}
		});
		
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				remove(panelQuestion);
				questionSeven();
				//results(score);
			}
		});
		
		
	}
	
	public void questionSeven() {
		
		labelQuestion2 = new JLabel("Question 7");
		labelQuestion2.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		//generate Question 2
		JLabel practiceQuestion_7 = new JLabel(
				"When you add white wine to the bottom of a pan that has brown bits, what is that technique called?");
		
		//create textfield
		textField = new JTextField();
		textField.setAlignmentX(Component.CENTER_ALIGNMENT);
		
				
		//place questions and options in same panel
		JPanel questionAnswer = new JPanel();
		questionAnswer.setLayout(new BoxLayout(questionAnswer, BoxLayout.Y_AXIS));
		questionAnswer.add(practiceQuestion_7);
		questionAnswer.add(textField);
		
		//initiate avatar.  intial thinking
		Companion thinking = new Companion();
		thinking.changeState(2);
		
		//place questionAnswer and Avatar in same panel
		questionAvatar = new JPanel();
		questionAvatar.setLayout(new BoxLayout(questionAvatar, BoxLayout.X_AXIS));
		
		questionAvatar.add(questionAnswer);
		questionAvatar.add(thinking);
		
		//submit and next buttons
		submit = new JButton("Submit");
		next = new JButton("Next");
		next.setEnabled(false);
		
		//create panel to hold buttons
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
		//add buttons to panel
		buttonPanel.add(submit);
		buttonPanel.add(next);
		
		//put it all together in the same panel
		panelQuestion = new JPanel();
		panelQuestion.setLayout(new BoxLayout(panelQuestion, BoxLayout.Y_AXIS));
		panelQuestion.add(labelQuestion2);
		panelQuestion.add(questionAvatar);
		panelQuestion.add(buttonPanel);
		
		add(panelQuestion);
		panelQuestion.updateUI();
		
		//add ActionListener to buttons
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {				
				
				String text = textField.getText();
				String answer = "deglazing";
				if(text.toLowerCase().equals(answer)) {
					score++;
					questionAvatar.remove(thinking);
					Companion happy = new Companion();
					happy.changeState(1);
					questionAvatar.add(happy);
					panelQuestion.updateUI();
				}
				else {
					questionAvatar.remove(thinking);
					Companion sorry = new Companion();
					sorry.changeState(4);
					questionAvatar.add(sorry);
					panelQuestion.updateUI();
				}
				submit.setEnabled(false);
				next.setEnabled(true);
			}
		});
		
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				remove(panelQuestion);
				questionEight();
				//results(score);
			}
		});
		
		
	}
	
	public void questionEight() {
		
		labelQuestion2 = new JLabel("Question 8");
		labelQuestion2.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		//generate Question 2
		JLabel practiceQuestion_8 = new JLabel(
				"What things should you do before you start cooking? (select all that apply)");
		
		//create 4 checkboxes
		chkBoxOption1 = new JCheckBox("Wash your hands");
		chkBoxOption2 = new JCheckBox("Put on apron");
		chkBoxOption3 = new JCheckBox("Tie back long hair");
		chkBoxOption4 = new JCheckBox("Make sure equipment is clean");
				
		//place questions and options in same panel
		JPanel questionAnswer = new JPanel();
		questionAnswer.setLayout(new BoxLayout(questionAnswer, BoxLayout.Y_AXIS));
		questionAnswer.add(practiceQuestion_8);
		questionAnswer.add(chkBoxOption1);
		questionAnswer.add(chkBoxOption2);
		questionAnswer.add(chkBoxOption3);
		questionAnswer.add(chkBoxOption4);
		
		//initiate avatar.  intial thinking
		Companion thinking = new Companion();
		thinking.changeState(2);
		
		//place questionAnswer and Avatar in same panel
		questionAvatar = new JPanel();
		questionAvatar.setLayout(new BoxLayout(questionAvatar, BoxLayout.X_AXIS));
		
		questionAvatar.add(questionAnswer);
		questionAvatar.add(thinking);
		
		//submit and next buttons
		submit = new JButton("Submit");
		next = new JButton("Next");
		next.setEnabled(false);
		
		//create panel to hold buttons
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
		//add buttons to panel
		buttonPanel.add(submit);
		buttonPanel.add(next);
		
		//put it all together in the same panel
		panelQuestion = new JPanel();
		panelQuestion.setLayout(new BoxLayout(panelQuestion, BoxLayout.Y_AXIS));
		panelQuestion.add(labelQuestion2);
		panelQuestion.add(questionAvatar);
		panelQuestion.add(buttonPanel);
		
		add(panelQuestion);
		panelQuestion.updateUI();
		
		//add ActionListener to buttons
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {				
				
				//correct answer only if all checkboxes are selected
				if(chkBoxOption1.isSelected() && chkBoxOption2.isSelected() && chkBoxOption3.isSelected() && chkBoxOption4.isSelected()) {
					score++;
					questionAvatar.remove(thinking);
					Companion happy = new Companion();
					happy.changeState(1);
					questionAvatar.add(happy);
					panelQuestion.updateUI();
				}
				else {
					questionAvatar.remove(thinking);
					Companion sorry = new Companion();
					sorry.changeState(4);
					questionAvatar.add(sorry);
					panelQuestion.updateUI();
				}
				submit.setEnabled(false);
				next.setEnabled(true);
			}
		});
		
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				remove(panelQuestion);
				questionNine();
				//results(score);
			}
		});
	}
	
	public void questionNine() {
		
		labelQuestion2 = new JLabel("Question 9");
		labelQuestion2.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		//generate Question 2
		JLabel practiceQuestion_9 = new JLabel(
				"What should you use to take something out of a hot oven?");
		
		//radiobuttons for answer options
		RBoption1 = new JRadioButton("Paper towel");
		RBoption2 = new JRadioButton("Your hands");
		RBoption3 = new JRadioButton("Oven mitts");
		
		ButtonGroup group = new ButtonGroup();
		group.add(RBoption1);
		group.add(RBoption2);
		group.add(RBoption3);
		
		//place questions and options in same panel
		JPanel questionAnswer = new JPanel();
		questionAnswer.setLayout(new BoxLayout(questionAnswer, BoxLayout.Y_AXIS));
		questionAnswer.add(practiceQuestion_9);
		questionAnswer.add(RBoption1);
		questionAnswer.add(RBoption2);
		questionAnswer.add(RBoption3);
		
		//initiate avatar.  intial thinking
		Companion thinking = new Companion();
		thinking.changeState(2);
		
		//place questionAnswer and Avatar in same panel
		questionAvatar = new JPanel();
		questionAvatar.setLayout(new BoxLayout(questionAvatar, BoxLayout.X_AXIS));
		
		questionAvatar.add(questionAnswer);
		questionAvatar.add(thinking);
		
		//submit and next buttons
		submit = new JButton("Submit");
		next = new JButton("Next");
		next.setEnabled(false);
		
		//create panel to hold buttons
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
		//add buttons to panel
		buttonPanel.add(submit);
		buttonPanel.add(next);
		
		//put it all together in the same panel
		panelQuestion = new JPanel();
		panelQuestion.setLayout(new BoxLayout(panelQuestion, BoxLayout.Y_AXIS));
		panelQuestion.add(labelQuestion2);
		panelQuestion.add(questionAvatar);
		panelQuestion.add(buttonPanel);
		
		add(panelQuestion);
		panelQuestion.updateUI();
		
		//add ActionListener to buttons
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if(RBoption3.isSelected()) {
					score++;
					questionAvatar.remove(thinking);
					Companion happy = new Companion();
					happy.changeState(1);
					questionAvatar.add(happy);
					panelQuestion.updateUI();
				}
				else {
					questionAvatar.remove(thinking);
					Companion sorry = new Companion();
					sorry.changeState(4);
					questionAvatar.add(sorry);
					panelQuestion.updateUI();
				}
				submit.setEnabled(false);
				next.setEnabled(true);
			}
		});
		
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				remove(panelQuestion);
				questionTen();
			}
		});
		
	}
	
	public void questionTen() {
		
		labelQuestion2 = new JLabel("Question 10");
		labelQuestion2.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		//generate Question 2
		JLabel practiceQuestion_10 = new JLabel(
				"A whisk would be a good choice for completing which of these tasks?  (select all that apply)");
		
		//create 4 checkboxes
		chkBoxOption1 = new JCheckBox("Mashing potatoes");
		chkBoxOption2 = new JCheckBox("Deboning a chicken");
		chkBoxOption3 = new JCheckBox("Mixing pancake batter");
		chkBoxOption4 = new JCheckBox("Scooping fritters from a deep fryer");
				
		//place questions and options in same panel
		JPanel questionAnswer = new JPanel();
		questionAnswer.setLayout(new BoxLayout(questionAnswer, BoxLayout.Y_AXIS));
		questionAnswer.add(practiceQuestion_10);
		questionAnswer.add(chkBoxOption1);
		questionAnswer.add(chkBoxOption2);
		questionAnswer.add(chkBoxOption3);
		questionAnswer.add(chkBoxOption4);
		
		//initiate avatar.  intial thinking
		Companion thinking = new Companion();
		thinking.changeState(2);
		
		//place questionAnswer and Avatar in same panel
		questionAvatar = new JPanel();
		questionAvatar.setLayout(new BoxLayout(questionAvatar, BoxLayout.X_AXIS));
		
		questionAvatar.add(questionAnswer);
		questionAvatar.add(thinking);
		
		//submit and next buttons
		submit = new JButton("Submit");
		next = new JButton("Next");
		next.setEnabled(false);
		
		//create panel to hold buttons
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
		//add buttons to panel
		buttonPanel.add(submit);
		buttonPanel.add(next);
		
		//put it all together in the same panel
		panelQuestion = new JPanel();
		panelQuestion.setLayout(new BoxLayout(panelQuestion, BoxLayout.Y_AXIS));
		panelQuestion.add(labelQuestion2);
		panelQuestion.add(questionAvatar);
		panelQuestion.add(buttonPanel);
		
		add(panelQuestion);
		panelQuestion.updateUI();
		
		//add ActionListener to buttons
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {				
				
				//correct answer only if all checkboxes are selected
				if(!chkBoxOption1.isSelected() && !chkBoxOption2.isSelected() && chkBoxOption3.isSelected() && !chkBoxOption4.isSelected()) {
					score++;
					questionAvatar.remove(thinking);
					Companion happy = new Companion();
					happy.changeState(1);
					questionAvatar.add(happy);
					panelQuestion.updateUI();
				}
				else {
					questionAvatar.remove(thinking);
					Companion sorry = new Companion();
					sorry.changeState(4);
					questionAvatar.add(sorry);
					panelQuestion.updateUI();
				}
				submit.setEnabled(false);
				next.setEnabled(true);
			}
		});
		
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				remove(panelQuestion);
				results(score);
			}
		});
		
	}
	
}*/