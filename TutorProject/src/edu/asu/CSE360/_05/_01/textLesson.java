package edu.asu.CSE360._05._01;


import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class textLesson extends JPanel {
	
	private JTextArea textArea;
	private JScrollPane scroll;
	private JButton doneButton;
	
	
	public textLesson() {
		setLayout(new BorderLayout());
		
		doneButton = new JButton("DONE");
		doneButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(doneButton,BorderLayout.SOUTH);
		
		JTextArea textArea = new JTextArea(30,100);
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.append("I opened the letter and pulled out a sheaf of half a dozen pages, all written in the same laborious script. Thanks to my work, I am experienced in the reading of difficult manuscripts. There is no great secret to it. Patience and practice are all that is required. That and the willingness to cultivate an inner eye. When you read a manuscript that has been damaged by water, fire, light or just the passing of the years, your eye needs to study not just the shape of the letters but other marks of production. The speed of the pen. The pressure of the hand on the page. Breaks and releases in the flow. You must relax. Think of nothing. Until you wake into a dream where you are at once a pen flying over vellum and the vellum itself with the touch of ink tickling your surface. Then you can read it. The intention of the writer, his thoughts, his hesitations, his longings and his meaning. You can read as clearly as if you were the very candlelight illuminating the page as the pen speeds over it.");

		JScrollPane scroll = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		add(scroll,BorderLayout.CENTER);
		
		doneButton.addActionListener(new ActionListener() {
 			public void actionPerformed(ActionEvent e) {
 				if (doneButton.isEnabled()) {
 					removeAll();
 					revalidate();
 					repaint();
					lessonChoices lessonPanel = new lessonChoices();
					add(lessonPanel,BorderLayout.CENTER);
 				}
 			}
       });
	}
}
