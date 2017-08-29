import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


//Javier Benavides
public class Assessor extends JPanel{
	
	// initial state when program starts.  Will show my name
	int state = 0;
	
	// The panels for questions
	private JPanel question3;
	
	// buttons for Question 3
	private JButton option1, option2, option3;
	
	public Assessor(int state) {
		
		// if state = 1 Question 1 (menu)
		// if state = 2 Question 2 (checkboxes)
		// if state = 3 Question 3 (buttons)
		// if state = 4 Question 4 (text field)
		// if state = 0 <Javier>
		
		if(state == 3) {
			option1 = new JButton("option 1");
			option2 = new JButton("option 2");
			option3 = new JButton("option 3");
			
			question3 = new JPanel();
			question3.setLayout(new GridLayout (3,1));
			question3.add(option1);
			question3.add(option2);
			question3.add(option3);
			
			setLayout(new BorderLayout());
			add(question3);
		}		
		
	}	
	
}
