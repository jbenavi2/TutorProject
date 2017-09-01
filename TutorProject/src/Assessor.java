import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


//Javier Benavides
public class Assessor extends JPanel{
	
	// initial state when program starts.  Will show my name
	int state = 0;
	
	// The panels for questions
	private JPanel panelQuestion3;
	
	// The title labels for each panel
	private JLabel labelQuestion3;
	
	// buttons for Question 3
	private JButton option1, option2, option3;
	
	public Assessor(int state) {
		
		// if state = 1 Question 1 (menu)
		// if state = 2 Question 2 (checkboxes)
		// if state = 3 Question 3 (buttons)
		// if state = 4 Question 4 (text field)
		// if state = 0 <Javier>
		
		if(state == 3) {
			//create my label
			labelQuestion3 = new JLabel("Question 3");
			
			//create my 3 option buttons
			option1 = new JButton("option 1");
			option1.setAlignmentX(Component.CENTER_ALIGNMENT);
			option2 = new JButton("option 2");
			option2.setAlignmentX(Component.CENTER_ALIGNMENT);
			option3 = new JButton("option 3");
			option3.setAlignmentX(Component.CENTER_ALIGNMENT);
			
			panelQuestion3 = new JPanel();
			panelQuestion3.setLayout(new BoxLayout(panelQuestion3, BoxLayout.Y_AXIS));
			panelQuestion3.add(labelQuestion3);
			//panelQuestion3.add(Box.createRigidArea(new Dimension(0,5)));
			panelQuestion3.add(option1);
			panelQuestion3.add(option2);
			panelQuestion3.add(option3);
			
			setLayout(new BorderLayout());
			add(panelQuestion3);
		}		
		
	}	
	
}
