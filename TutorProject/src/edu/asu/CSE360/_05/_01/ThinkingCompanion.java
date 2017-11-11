package edu.asu.CSE360._05._01;
/**

* Description:
* 	Decorator type
* 	Displays Gordon Ramsey with a thinking face
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

public class ThinkingCompanion extends CompanionDecorator {
	@Override
	public void doSomething(JComponent panel) {
		
		super.doSomething(panel);
		ImageIcon thinkingFace = new ImageIcon("resources/thinking.gif");
		JLabel thinkingLabel = new JLabel();
		thinkingLabel.setIcon(thinkingFace);
		panel.add(thinkingLabel);		
	}

}
