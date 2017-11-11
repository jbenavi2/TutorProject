package edu.asu.CSE360._05._01;

/**

* Description:
* 	Third Quiz.  Uses Combination of Multiple Choice, T/F, Multiple Answers, and 
* 	single response type questions
* 	
* 	An animated companion provides feedback
* 
* 	Immediate grade at end of quiz
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

public class RevisedAssessor3 extends JPanel{
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
	
	private JCheckBox chkBox1, chkBox2, chkBox3, chkBox4;
	
	private JTextField textfield;
	
	private JButton next, submit, goBack;
	
	
	
	//default constructor
	public RevisedAssessor3() {
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
		labelQuestion = new JLabel("What is the safe minimum cooking temperature for Ground Meat?");
		labelQuestion.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		//create textfield
		textfield = new JTextField();
		textfield.setAlignmentX(Component.CENTER_ALIGNMENT);
						
		//place questions and options in same panel
		JPanel questionAnswer = new JPanel();
		questionAnswer.setLayout(new BoxLayout(questionAnswer, BoxLayout.Y_AXIS));
		questionAnswer.add(labelQuestion);
		questionAnswer.add(textfield);
		
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
				
				String text = textfield.getText();
				String answer = "160F";
				if(text.toLowerCase().equals(answer)) {
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
		labelQuestion = new JLabel("The safe minimum cooking temperature is the same for whole cuts of meat and ground meat.");
		labelQuestion.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		//radio buttons with possible answers
		RBoption1 = new JRadioButton("False");
		RBoption2 = new JRadioButton("True");
		
		ButtonGroup group = new ButtonGroup();
		group.add(RBoption1);
		group.add(RBoption2);
		
		//place questions and options in same panel
		JPanel questionAnswer = new JPanel();
		questionAnswer.setLayout(new BoxLayout(questionAnswer, BoxLayout.Y_AXIS));
		questionAnswer.add(labelQuestion);
		questionAnswer.add(RBoption1);
		questionAnswer.add(RBoption2);
		
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
		labelQuestion = new JLabel("What happens when meat is seared?");
		labelQuestion.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		//check boxes
		chkBox1 = new JCheckBox("Gives the meat flavor");
		chkBox2 = new JCheckBox("Caramelizes the outside of the meat");
		chkBox3 = new JCheckBox("Creates a golden-brown crust");
		chkBox4 = new JCheckBox("Seals in moisture");
		
				
		//place questions and options in same panel
		JPanel questionAnswer = new JPanel();
		questionAnswer.setLayout(new BoxLayout(questionAnswer, BoxLayout.Y_AXIS));
		questionAnswer.add(labelQuestion);
		questionAnswer.add(chkBox1);
		questionAnswer.add(chkBox2);
		questionAnswer.add(chkBox3);
		questionAnswer.add(chkBox4);

		
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
				if(chkBox1.isSelected() && chkBox2.isSelected() && chkBox3.isSelected() && !chkBox4.isSelected()) {
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
		labelQuestion = new JLabel("How long should meat rest after it is cooked?");
		labelQuestion.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		//radio buttons with possible answers
		RBoption1 = new JRadioButton("0 mins");
		RBoption2 = new JRadioButton("15-30 mins");
		RBoption3 = new JRadioButton("5-10 mins");
		
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
				questionFive();
			}
		});
	}
	
	public void questionFive() {
		//create question
		labelQuestion = new JLabel("What are some Tough, Slow-cooking Cuts of Meat?");
		labelQuestion.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		//create 4 checkboxes
		chkBox1 = new JCheckBox("Ribeye Steak");
		chkBox2 = new JCheckBox("Pork Shoulder");
		chkBox3 = new JCheckBox("Beef Chuck");
		chkBox4 = new JCheckBox("Pork Chops");
				
		
		//place questions and options in same panel
		JPanel questionAnswer = new JPanel();
		questionAnswer.setLayout(new BoxLayout(questionAnswer, BoxLayout.Y_AXIS));
		questionAnswer.add(labelQuestion);
		questionAnswer.add(chkBox1);
		questionAnswer.add(chkBox2);
		questionAnswer.add(chkBox3);
		questionAnswer.add(chkBox4);
		
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
				if(!chkBox1.isSelected() && chkBox2.isSelected() && chkBox3.isSelected() && !chkBox4.isSelected()) {
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
		session.lessonThreeInput(correct, incorrect, time);
		
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
