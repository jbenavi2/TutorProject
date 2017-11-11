package edu.asu.CSE360._05._01;

/**

* Description:
* 	Decorator type
* 	Displays Gordon Ramsey with fire in the background
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
public class FireCompanion extends CompanionDecorator {
	@Override
	public void doSomething(JComponent panel) {
		super.doSomething(panel);
		ImageIcon demon = new ImageIcon("resources/fireGordon.gif");
		JLabel demonLabel = new JLabel();
		demonLabel.setIcon(demon);
		panel.add(demonLabel);
	}

}
