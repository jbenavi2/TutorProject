import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


//Javier Benavides
public class Assessor extends JPanel{
	
	// initial state when program starts.  Will show my name
	int state = 0;
	
	// The panels for questions
	private JPanel panelDefault;
	private JPanel panelQuestion1;
	private JPanel panelQuestion2;
	private JPanel panelQuestion3;
	private JPanel panelQuestion4;
	
	// The title labels for each panel
	private JLabel myName;
	private JLabel labelQuestion1;
	private JLabel labelQuestion2;
	private JLabel labelQuestion3;
	private JLabel labelQuestion4;
	
	// Combo box with options for Question 1
	private String[] optionsList = {"option1", "option2", "option3"};
	private JComboBox<String> questionOneList;
	
	// buttons for Question 3
	private JButton option1, option2, option3;
	
	//default constructor
	public Assessor() {
		//create my label that only show my name
		myName = new JLabel("Javier Benavides");
		myName.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		//create my panel that will only contain my name
		panelDefault = new JPanel();
		panelDefault.setLayout(new BoxLayout(panelDefault, BoxLayout.Y_AXIS));
		panelDefault.add(myName);
		setLayout(new BorderLayout());
		add(panelDefault);
	}
	
	//method for when the slider changes in Universe
	public void changeState(int state) {
		
		// if state = 1 Question 1 (menu)
		// if state = 2 Question 2 (checkboxes)
		// if state = 3 Question 3 (buttons)
		// if state = 4 Question 4 (text field)
		// if state = 0 <Javier>
		
		if(state == 0) {
			//create my label that only contains my name
			myName = new JLabel("Javier Benavides");
			myName.setAlignmentX(Component.CENTER_ALIGNMENT);
			
			//create my panel that only contains my name			
			panelDefault = new JPanel();
			panelDefault.setLayout(new BoxLayout(panelDefault, BoxLayout.Y_AXIS));
			panelDefault.add(myName);
			setLayout(new BorderLayout());
			add(panelDefault);
		}
		
		else if(state == 1) {
			//options that will be inside combo box
			//String[] optionsList = { "option1", "option2", "option3" };
			
			//create my label
			labelQuestion1 =  new JLabel("Question 1");
			labelQuestion1.setAlignmentX(Component.CENTER_ALIGNMENT);
			
			//create the combo box
			questionOneList = new JComboBox<String>(optionsList);
			questionOneList.setAlignmentX(Component.CENTER_ALIGNMENT);
			
			//create my panel for when in state 1
			panelQuestion1 = new JPanel();
			panelQuestion1.setLayout(new BoxLayout(panelQuestion1, BoxLayout.Y_AXIS));
			panelQuestion1.add(labelQuestion1);
			panelQuestion1.add(questionOneList);
			
			setLayout(new BorderLayout());
			add(panelQuestion1);
			
			
		}
		
		else if(state == 3) {
			//create my label
			labelQuestion3 = new JLabel("Question 3");
			labelQuestion3.setAlignmentX(Component.CENTER_ALIGNMENT);
			
			//create my 3 option buttons
			option1 = new JButton("option 1");
			option1.setAlignmentX(Component.CENTER_ALIGNMENT);
			option2 = new JButton("option 2");
			option2.setAlignmentX(Component.CENTER_ALIGNMENT);
			option3 = new JButton("option 3");
			option3.setAlignmentX(Component.CENTER_ALIGNMENT);
			
			//create my panel for when in state 3
			panelQuestion3 = new JPanel();
			panelQuestion3.setLayout(new BoxLayout(panelQuestion3, BoxLayout.Y_AXIS));
			panelQuestion3.add(labelQuestion3);
			panelQuestion3.add(option1);
			panelQuestion3.add(option2);
			panelQuestion3.add(option3);
			
			setLayout(new BorderLayout());
			add(panelQuestion3);
		}		
		
	}	
	
}
