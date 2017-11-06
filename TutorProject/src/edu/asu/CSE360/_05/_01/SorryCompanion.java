package edu.asu.CSE360._05._01;

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
