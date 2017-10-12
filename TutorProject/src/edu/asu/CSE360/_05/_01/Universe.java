package edu.asu.CSE360._05._01;


/**

* Description:
* 	Creates a Jframe that holds the first panel, a list of lessons and all subsequent panels
* Assignment number:
* 	Recitation Project 3
* Completion time:
* 	0.5 Hours
*
* @author Andrew Bui
* @version 1
*/

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Universe extends JFrame
{
	public static void main(String[] args) 
	{
			
		//Create JFrame to hold content and add close operation
		JFrame frame = new JFrame("Cooking Tutor");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container content = frame.getContentPane();
		
		//initial State - Choose Lesson
		content.setLayout(new GridBagLayout());
		lessonList chooseLesson = new lessonList();
		content.add(chooseLesson);
		
		//set frame size and visible
		frame.setSize(1280,720);
		frame.setVisible(true);
	  }
}
