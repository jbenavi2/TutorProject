package edu.asu.CSE360._05._01;
/**

* Description:
* 	DecoratorClass used for children to inherit from.	
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
