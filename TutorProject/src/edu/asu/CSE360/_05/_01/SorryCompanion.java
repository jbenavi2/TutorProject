package edu.asu.CSE360._05._01;
/**

* Description:
* 	Decorator type
* 	Displays Gordon Ramsey with face of disapproval
* 
* Assignment number:
* 	Recitation Project 4
* Completion time:
* 	1 Hours
*
* @author Javier Benavides
* @version 1
*/
import javax.swing.*;

public class SorryCompanion extends CompanionDecorator{
	@Override
	public void doSomething(JComponent panel) {
		
		super.doSomething(panel);
		ImageIcon sorryFace = new ImageIcon("resources/sorry.gif");
		JLabel sorryLabel = new JLabel();
		sorryLabel.setIcon(sorryFace);
		panel.add(sorryLabel);
	}

}
