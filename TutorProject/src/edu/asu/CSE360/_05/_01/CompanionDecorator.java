package edu.asu.CSE360._05._01;

import javax.swing.*;

public class CompanionDecorator implements Companion{
	
	protected Companion c;
	
	public void add(Companion c) {
		this.c = c;
	}
	
	@Override
	public void doSomething(JComponent panel) {
		this.c.doSomething(panel);
	}

}
