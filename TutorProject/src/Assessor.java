/**
* 4 question will be displayed.  One on each panel
* with different option styles for selecting answers.
* Those option styles include using a menu, checkboxes,
* buttons, and a textfield.
* Recitation Project 1
* Completion time: 4 hours
*
* @author Javier Benavides
* @version 1.0
*/


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
	
	// checkboxes for Question2
	private JCheckBox chkBoxOption1, chkBoxOption2, chkBoxOption3;
	
	// buttons for Question 3
	private JButton buttonOption1, buttonOption2, buttonOption3;
	
	// textfield for Question 4
	private JTextField textField;
	
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
			//setLayout(new BorderLayout());
			add(panelDefault);
		}
		
		else if(state == 1) {
			
			//create my label
			labelQuestion1 =  new JLabel("Question 1");
			labelQuestion1.setAlignmentX(Component.CENTER_ALIGNMENT);
			
			//create the combo box
			questionOneList = new JComboBox<String>(optionsList);
			questionOneList.setEditable(false);
			questionOneList.setAlignmentX(Component.CENTER_ALIGNMENT);
			
			//create my panel for when in state 1
			panelQuestion1 = new JPanel();
			panelQuestion1.setLayout(new BoxLayout(panelQuestion1, BoxLayout.Y_AXIS));
			panelQuestion1.add(labelQuestion1);
			panelQuestion1.add(questionOneList);
			
			//setLayout(new BorderLayout());
			add(panelQuestion1);
			
			questionOneList.addActionListener(new ComboBoxListener());
			
			
		}
		
		else if(state == 2) {
			//create my label
			labelQuestion2 = new JLabel("Question 2");
			labelQuestion2.setAlignmentX(Component.CENTER_ALIGNMENT);
			
			//create my 3 checkboxes
			chkBoxOption1 = new JCheckBox("Option 1");
			chkBoxOption1.setAlignmentX(Component.CENTER_ALIGNMENT);
			chkBoxOption2 = new JCheckBox("Option 2");
			chkBoxOption2.setAlignmentX(Component.CENTER_ALIGNMENT);
			chkBoxOption3 = new JCheckBox("Option 3");
			chkBoxOption3.setAlignmentX(Component.CENTER_ALIGNMENT);
			
			//create my panel for when in state 2
			panelQuestion2 = new JPanel();
			panelQuestion2.setLayout(new BoxLayout(panelQuestion2, BoxLayout.Y_AXIS));
			panelQuestion2.add(labelQuestion2);
			panelQuestion2.add(chkBoxOption1);
			panelQuestion2.add(chkBoxOption2);
			panelQuestion2.add(chkBoxOption3);
			
			//setLayout(new BorderLayout());
			add(panelQuestion2);
			
			chkBoxOption1.addItemListener(new CheckBoxListener());
			chkBoxOption2.addItemListener(new CheckBoxListener());
			chkBoxOption3.addItemListener(new CheckBoxListener());
			
			
		}
		
		else if(state == 3) {
			//create my label
			labelQuestion3 = new JLabel("Question 3");
			labelQuestion3.setAlignmentX(Component.CENTER_ALIGNMENT);
			
			//create my 3 option buttons
			buttonOption1 = new JButton("option 1");
			buttonOption1.setAlignmentX(Component.CENTER_ALIGNMENT);
			buttonOption2 = new JButton("option 2");
			buttonOption2.setAlignmentX(Component.CENTER_ALIGNMENT);
			buttonOption3 = new JButton("option 3");
			buttonOption3.setAlignmentX(Component.CENTER_ALIGNMENT);
			
			//create my panel for when in state 3
			panelQuestion3 = new JPanel();
			panelQuestion3.setLayout(new BoxLayout(panelQuestion3, BoxLayout.Y_AXIS));
			panelQuestion3.add(labelQuestion3);
			panelQuestion3.add(buttonOption1);
			panelQuestion3.add(buttonOption2);
			panelQuestion3.add(buttonOption3);
			
			//setLayout(new BorderLayout());
			add(panelQuestion3);
			
			buttonOption1.addActionListener(new ButtonListener());
			buttonOption2.addActionListener(new ButtonListener());
			buttonOption3.addActionListener(new ButtonListener());
			
		}
		
		else if(state == 4) {
			//create my label
			labelQuestion4 = new JLabel("Question 4");
			labelQuestion4.setAlignmentX(Component.CENTER_ALIGNMENT);
			
			//create my textfield
			textField = new JTextField();
			textField.setAlignmentX(Component.CENTER_ALIGNMENT);
			
			//create my panel for when in state 4
			panelQuestion4 = new JPanel();
			panelQuestion4.setLayout(new BoxLayout(panelQuestion4, BoxLayout.Y_AXIS));
			panelQuestion4.add(labelQuestion4);
			panelQuestion4.add(textField);
			
			add(panelQuestion4);			
			
			textField.addActionListener(new TextFieldListener());
		}
		
	}
	
	//TextFieldListener class listens for text is typed in the texfield
	private class TextFieldListener implements ActionListener{
		
		public void actionPerformed(ActionEvent event) {
			
			String text = textField.getText();
			JOptionPane.showMessageDialog(null, text);
		}
		
	}//end TextFieldListener
	
	//CheckBoxListner class listens to which boxes are selected
	private class CheckBoxListener implements ItemListener{
		
		public void itemStateChanged(ItemEvent event) {
			
			Object source = event.getItemSelectable();
			
			if(source == chkBoxOption1 || source == chkBoxOption2 || source == chkBoxOption3) {
				JOptionPane.showMessageDialog(null, "hello world!");
			}
		}

		
	}//end CheckBoxListener
	
	//ButtonListener class listens to see if Option 1, 2, or 3 is pushed.
	private class ButtonListener implements ActionListener{
		
		public void actionPerformed(ActionEvent event) {
			
			Object source = event.getSource();
			
			if(source == buttonOption1 || source == buttonOption2 || source == buttonOption3) {
				JOptionPane.showMessageDialog(null, "hello world!");
			}
			
		}
	}//end ButtonListener
	
	//ComboBoxListener class listens to see which options are selected from the Combo box
	private class ComboBoxListener implements ActionListener{
		
		public void actionPerformed(ActionEvent event) {
			
			JComboBox<String> source = (JComboBox<String>)event.getSource();
			String option = (String)source.getSelectedItem();
			
			if(option == "option1" || option == "option2" || option == "option3") {
				JOptionPane.showMessageDialog(null, "hello world!");
			}
			
		}
		
	}//end ComboBoxListener
	
}
