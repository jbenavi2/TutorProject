package edu.asu.CSE360._05._01;

/**

* Description:
* 	CompanionPanel sets the companion of choice on a JPanel
* 	use showYourself() to display the desired companion. 
* 
* Assignment number:
* 	Recitation Project 4
* Completion time:
* 	1 Hours
*
* @author Javier Benavides
* @version 1
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CompanionPanel extends JLayeredPane{
	public Companion brain;
	
	public void setCompanion(Companion x) {
		brain = x;
	}
	
	public void showYourself() {
		removeAll();
		setLayout(new GridLayout(1,1));
		brain.doSomething(this);
		revalidate();
	}

}
