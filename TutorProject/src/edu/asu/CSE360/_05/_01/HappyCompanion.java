package edu.asu.CSE360._05._01;
/**

* Description:
* 	Decorator type
* 	Displays Gordon Ramsey with face of approval
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

public class HappyCompanion extends CompanionDecorator{
	@Override
	public void doSomething(JComponent panel) {
		
		super.doSomething(panel);
		ImageIcon happyFace = new ImageIcon("resources/happy.gif");
		JLabel happyLabel = new JLabel();
		happyLabel.setIcon(happyFace);
		panel.add(happyLabel);
	}

}
