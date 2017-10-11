package edu.asu.CSE360._05._01;
/**
* 4 question will be displayed.  One on each slider
* with different option styles for selecting answers.
* Those option styles include using a menu, checkboxes,
* buttons, and a textfield.
* Recitation Project 1
* Completion time: 4 hours
*
* @author Javier Benavides
* @version 1.0
*/


import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.TimeUnit;

import javax.swing.*;


//Javier Benavides
public class Assessor extends JPanel{
	
	// initial state when program starts.  Will show my name
	int state = 0;
	
	int score = 0;
	
	//Grid Layout to hold Questions and Avatar
	private JPanel questionAvatar;
	
	
	// The panels for questions
	private JPanel panelDefault;
	private JPanel panelQuestion;
	private JPanel panelQuestion2;
	private JPanel panelQuestion3;
	private JPanel panelQuestion4;
	
	//
	private String answer;
	
	
	// The title labels for each panel
	private JLabel myName;
	private JLabel labelQuestion1;
	private JLabel labelQuestion2;
	private JLabel labelQuestion3;
	private JLabel labelQuestion4;
	
	// Combo box with answer options for Question 1
	private String[] optionsList = {"with water", "smother with baking soda", "blow on it"};
	private JComboBox<String> questionOneList;
	
	//Jradio buttons for answer options
	private JRadioButton RBoption1, RBoption2, RBoption3;
	
	// checkboxes for Question2
	private JCheckBox chkBoxOption1, chkBoxOption2, chkBoxOption3;
	
	// buttons for Question 3
	private JButton buttonOption1, buttonOption2, buttonOption3;
	
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
		float percentage = ((float) score/5)*100;
		String grade = Float.toString(percentage)+"%";
		JLabel showGrade = new JLabel(grade);
		
		//Generate avatar based on score
		Companion emotion = new Companion();
		if(score >= 4) {
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
		
		panelDefault = new JPanel();
		panelDefault.setLayout(new BoxLayout(panelDefault, BoxLayout.Y_AXIS));
		panelDefault.add(practiceResult);
		panelDefault.add(gradeAvatar);
		
		add(panelDefault);
		panelDefault.updateUI();
		
		
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
				results(score);
			}
		});
		
	}
	
	//method for when the slider changes in Universe
	public void changeState(int state) {
		
		// if state = 1 Question 1 (menu)
		// if state = 2 Question 2 (checkboxes)
		// if state = 3 Question 3 (buttons)
		// if state = 4 Question 4 (text field)
		// if state = 0 <Javier>
		
		if(state == 0) {
			//create my label that only contains my name
			myName = new JLabel("Javier Benavides");
			myName.setAlignmentX(Component.CENTER_ALIGNMENT);
			
			//create my panel that only contains my name			
			panelDefault = new JPanel();
			panelDefault.setLayout(new BoxLayout(panelDefault, BoxLayout.Y_AXIS));
			panelDefault.add(myName);
			//setLayout(new BorderLayout());
			add(panelDefault);
		}
		
		else if(state == 1) {
			
			//create my label
			labelQuestion1 =  new JLabel("Question 1");
			labelQuestion1.setAlignmentX(Component.CENTER_ALIGNMENT);
			
			//generate the first question
			JLabel practiceQuestion_1 = new JLabel(
					"How do you put out a grease fire?");
			
			//practiceQuestion_1.setEditable(false);
			//practiceQuestion_1.setLineWrap(true);
			
//			//create the combo box with answer options
//			questionOneList = new JComboBox<String>(optionsList);
//			questionOneList.setEditable(false);
//			questionOneList.setAlignmentX(Component.CENTER_ALIGNMENT);
			
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
			
			//setLayout(new BorderLayout());
			add(panelQuestion);
			
			//add actionListener to JComboBox to store value in String			
//			questionOneList.addActionListener(new ActionListener() {
//				public void actionPerformed(ActionEvent event) {
//					answer = (String)questionOneList.getSelectedItem();
//				}
//			});
			
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

//					panelQuestion1.updateUI();				
					
				}				
			});
//			questionOneList.addActionListener(new ComboBoxListener());
			
			
		}
		
		else if(state == 2) {
			//create my label
			labelQuestion2 = new JLabel("Question 2");
			labelQuestion2.setAlignmentX(Component.CENTER_ALIGNMENT);
			
			//create my 3 checkboxes
			chkBoxOption1 = new JCheckBox("Option 1");
			chkBoxOption1.setAlignmentX(Component.CENTER_ALIGNMENT);
			chkBoxOption2 = new JCheckBox("Option 2");
			chkBoxOption2.setAlignmentX(Component.CENTER_ALIGNMENT);
			chkBoxOption3 = new JCheckBox("Option 3");
			chkBoxOption3.setAlignmentX(Component.CENTER_ALIGNMENT);
			
			//create my panel for when in state 2
			panelQuestion2 = new JPanel();
			panelQuestion2.setLayout(new BoxLayout(panelQuestion2, BoxLayout.Y_AXIS));
			panelQuestion2.add(labelQuestion2);
			panelQuestion2.add(chkBoxOption1);
			panelQuestion2.add(chkBoxOption2);
			panelQuestion2.add(chkBoxOption3);
			
			//setLayout(new BorderLayout());
			add(panelQuestion2);
			
			chkBoxOption1.addActionListener(new CheckBoxListener());
			chkBoxOption2.addActionListener(new CheckBoxListener());
			chkBoxOption3.addActionListener(new CheckBoxListener());
			
			
		}
		
		else if(state == 3) {
			//create my label
			labelQuestion3 = new JLabel("Question 3");
			labelQuestion3.setAlignmentX(Component.CENTER_ALIGNMENT);
			
			//create my 3 option buttons
			buttonOption1 = new JButton("option 1");
			buttonOption1.setAlignmentX(Component.CENTER_ALIGNMENT);
			buttonOption2 = new JButton("option 2");
			buttonOption2.setAlignmentX(Component.CENTER_ALIGNMENT);
			buttonOption3 = new JButton("option 3");
			buttonOption3.setAlignmentX(Component.CENTER_ALIGNMENT);
			
			//create my panel for when in state 3
			panelQuestion3 = new JPanel();
			panelQuestion3.setLayout(new BoxLayout(panelQuestion3, BoxLayout.Y_AXIS));
			panelQuestion3.add(labelQuestion3);
			panelQuestion3.add(buttonOption1);
			panelQuestion3.add(buttonOption2);
			panelQuestion3.add(buttonOption3);
			
			//setLayout(new BorderLayout());
			add(panelQuestion3);
			
			buttonOption1.addActionListener(new ButtonListener());
			buttonOption2.addActionListener(new ButtonListener());
			buttonOption3.addActionListener(new ButtonListener());
			
		}
		
		else if(state == 4) {
			//create my label
			labelQuestion4 = new JLabel("Question 4");
			labelQuestion4.setAlignmentX(Component.CENTER_ALIGNMENT);
			
			//create my textfield
			textField = new JTextField();
			textField.setAlignmentX(Component.CENTER_ALIGNMENT);
			
			//create my panel for when in state 4
			panelQuestion4 = new JPanel();
			panelQuestion4.setLayout(new BoxLayout(panelQuestion4, BoxLayout.Y_AXIS));
			panelQuestion4.add(labelQuestion4);
			panelQuestion4.add(textField);
			
			add(panelQuestion4);			
			
			textField.addActionListener(new TextFieldListener());
		}
		
	}
	
	//TextFieldListener class listens for text is typed in the texfield
	private class TextFieldListener implements ActionListener{
		
		public void actionPerformed(ActionEvent event) {
			
			String text = textField.getText();
			JOptionPane.showMessageDialog(null, text);
		}
		
	}//end TextFieldListener
	
	//CheckBoxListner class listens to which boxes are selected
	private class CheckBoxListener implements ActionListener{
		
		public void actionPerformed(ActionEvent event) {
			
			Object source = event.getSource();
			if(source == chkBoxOption1 || source == chkBoxOption2 || source == chkBoxOption3) {
				JOptionPane.showMessageDialog(null, "hello world!");
			}
			
		}

		
	}//end CheckBoxListener
	
	//question 1 ButtonListener
	private class questionOneButtonListener implements ActionListener{
		
		public void actionPerformed(ActionEvent event) {
			Object source = event.getSource();
		}
	}
	
	//ButtonListener class listens to see if Option 1, 2, or 3 is pushed.
	private class ButtonListener implements ActionListener{
		
		public void actionPerformed(ActionEvent event) {
			
			Object source = event.getSource();
			
			if(source == buttonOption1 || source == buttonOption2 || source == buttonOption3) {
				JOptionPane.showMessageDialog(null, "hello world!");
			}
			
		}
	}//end ButtonListener
	
	//ComboBoxListener class listens to see which options are selected from the Combo box
	private class ComboBoxListener implements ActionListener{
		
		public void actionPerformed(ActionEvent event) {
			
			JComboBox<String> source = (JComboBox<String>)event.getSource();
			String option = (String)source.getSelectedItem();
			
			if(option == "option1" || option == "option2" || option == "option3") {
				JOptionPane.showMessageDialog(null, "hello world!");
			}
			
		}
		
	}//end ComboBoxListener
	
}
