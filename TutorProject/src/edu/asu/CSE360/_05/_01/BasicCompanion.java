package edu.asu.CSE360._05._01;

import javax.swing.*;

public class BasicCompanion implements Companion{
	@Override
	public void doSomething(JComponent panel) {
		
		ImageIcon fire = new ImageIcon("resources/fireGordon.gif");
		JLabel fireLabel = new JLabel();
		fireLabel.setIcon(fire);
		panel.add(fireLabel);		
		
	}

}
