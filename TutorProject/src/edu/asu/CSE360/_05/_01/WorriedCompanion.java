package edu.asu.CSE360._05._01;

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
