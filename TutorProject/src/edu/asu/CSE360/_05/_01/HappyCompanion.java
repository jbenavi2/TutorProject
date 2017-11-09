package edu.asu.CSE360._05._01;

import javax.swing.*;
public class HappyCompanion extends CompanionDecorator{
	@Override
	public void doSomething(JComponent panel) {
		
		super.doSomething(panel);
		ImageIcon happyFace = new ImageIcon("resource/happy.gif");
		JLabel happyLabel = new JLabel();
		happyLabel.setIcon(happyFace);
		panel.add(happyLabel);
	}

}
