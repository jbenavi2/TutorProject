package edu.asu.CSE360._05._01;

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
