package edu.asu.CSE360._05._01;
/**

* Description:
* 	Decorator type
* 	Displays Gordon Ramsey with a worried face
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

public class WorriedCompanion extends CompanionDecorator{
	@Override
	public void doSomething(JComponent panel) {
		
		super.doSomething(panel);
		ImageIcon worriedFace = new ImageIcon("resources/worried.gif");
		JLabel worriedLabel = new JLabel();
		worriedLabel.setIcon(worriedFace);
		panel.add(worriedLabel);		
		
	}

}
