package edu.asu.CSE360._05._01;

import javax.swing.*;

public class BasicCompanion implements Companion{
	@Override
	public void doSomething(JComponent panel) {
		
		ImageIcon happy = new ImageIcon("resources/happy.gif");
		JLabel happyLabel = new JLabel();
		happyLabel.setIcon(happy);
		panel.add(happyLabel);		
		
	}

}
