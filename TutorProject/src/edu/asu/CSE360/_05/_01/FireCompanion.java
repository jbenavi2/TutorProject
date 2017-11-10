package edu.asu.CSE360._05._01;

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
