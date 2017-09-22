package edu.asu.CSE360._05._01;
/**
* The panel will display one of four GIF options for different types of faces: 
* happy, thinking, worried, and sorry.
* Assignment number: Recitation Project 2
* Completion time: .5 hours
*
* @author Natalie DePaula
* @version 2.0
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Companion extends JPanel {
	
	// initial state when program starts, will show my name
	int state = 0;
	
	// The panels for different types of faces
	private JPanel panelDefault;
	private JPanel happy;
	private JPanel thinking;
	private JPanel worried;
	private JPanel sorry;
	
	// The labels for each panel
	private JLabel myName;
	private JLabel happyLabel;
	private JLabel thinkingLabel;
	private JLabel worriedLabel;
	private JLabel sorryLabel;
	
	// The pictures for each label in each panel
	private ImageIcon happyGIF;
	private ImageIcon thinkingGIF;
	private ImageIcon worriedGIF;
	private ImageIcon sorryGIF;
	
	public Companion() {
		
		//create my label that only show my name
		myName = new JLabel("Natalie DePaula");
		myName.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		//create my panel that will only contain my name
		panelDefault = new JPanel();
		panelDefault.setLayout(new BoxLayout(panelDefault, BoxLayout.Y_AXIS));
		panelDefault.add(myName);
		setLayout(new BorderLayout());
		add(panelDefault);
	}

	public void changeState(int state) {
		
		if(state == 0) {
			//create my label that only contains my name
			myName = new JLabel("Natalie DePaula");
			myName.setAlignmentX(Component.CENTER_ALIGNMENT);
			
			//create default panel that only contains my name			
			panelDefault = new JPanel();
			panelDefault.setLayout(new BoxLayout(panelDefault, BoxLayout.Y_AXIS));
			panelDefault.add(myName);
			
			//setLayout(new BorderLayout());
			add(panelDefault);
		}
		
		else if(state == 1) {
			
			//Creates the happy GIF
			happyGIF = new ImageIcon("resources/happy.gif");
			
			//creates the happy label that holds the GIF
			happyLabel =  new JLabel("", happyGIF, JLabel.CENTER);
			
			//create happy panel for when in state 1
			//centers the contents of the panel horizontally
			happy = new JPanel(new GridBagLayout());
			GridBagConstraints happyLayout = new GridBagConstraints();
			happyLayout.weightx = 1;
			happyLayout.fill = GridBagConstraints.HORIZONTAL;
			happyLayout.gridwidth = GridBagConstraints.REMAINDER;
	        
        	//sets background color to white
        	happy.setBackground(Color.white);
			
	       	happy.add(happyLabel);
			add(happy);
			
		}
		
		else if(state == 2) {
			
			//Creates the thinking GIF
			thinkingGIF = new ImageIcon("resources/thinking.gif");
			
			//creates the thinking label that holds the GIF
			thinkingLabel =  new JLabel("", thinkingGIF, JLabel.CENTER);
			
			//create thinking panel for when in state 2
			//centers the contents of the panel horizontally
			thinking = new JPanel(new GridBagLayout());
        	GridBagConstraints thinkingLayout = new GridBagConstraints();
        	thinkingLayout.weightx = 1;
        	thinkingLayout.fill = GridBagConstraints.HORIZONTAL;
        	thinkingLayout.gridwidth = GridBagConstraints.REMAINDER;
			
        	//sets background color to white
        	thinking.setBackground(Color.white);
        
        	thinking.add(thinkingLabel);
			add(thinking);
			
		}
		
		else if(state == 3) {
			
			//Creates the worried GIF
			worriedGIF = new ImageIcon("resources/worried.gif");
			
			//creates the worried label that holds the GIF
			worriedLabel =  new JLabel("", worriedGIF, JLabel.CENTER);
			
			//create worried panel for when in state 4
			//centers the contents of the panel horizontally
			worried = new JPanel(new GridBagLayout());
       		GridBagConstraints worriedLayout = new GridBagConstraints();
        	worriedLayout.weightx = 1;
        	worriedLayout.fill = GridBagConstraints.HORIZONTAL;
        	worriedLayout.gridwidth = GridBagConstraints.REMAINDER;
	        
        	//sets background color to white
        	worried.setBackground(Color.white);
		
        	worried.add(worriedLabel);
			add(worried);
			
		}
		
		else if(state == 4) {
			
			//Creates the sorry GIF
			sorryGIF = new ImageIcon("resources/sorry.gif");
			
			//creates the sorry label that holds the GIF
			sorryLabel =  new JLabel("", sorryGIF, JLabel.CENTER);
			
			//create sorry panel for when in state 4
			//centers the contents of the panel horizontally
			sorry = new JPanel(new GridBagLayout());
        	GridBagConstraints sorryLayout = new GridBagConstraints();
        	sorryLayout.weightx = 1;
        	sorryLayout.fill = GridBagConstraints.HORIZONTAL;
        	sorryLayout.gridwidth = GridBagConstraints.REMAINDER;
	        
        	//sets background color to white
        	sorry.setBackground(Color.white);
		
        	sorry.add(sorryLabel);
			add(sorry);
		}
		
	}
	
}
