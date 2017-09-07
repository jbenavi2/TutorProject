/**
* The panel will display one of four options for different types of faces: 
* happy, thinking, worried, and sorry.
* Assignment number: Recitation Project 1
* Completion time: (estimation of hours spent on this program)
*
* @author Natalie DePaula, (the names of anyone whose code you use)
* @version (version)
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
	private ImageIcon happyImage;
	private ImageIcon thinkingImage;
	private ImageIcon worriedImage;
	private ImageIcon sorryImage;
		
	}
	
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
			
			//Creates the happy image
			ImageIcon happyImage = new ImageIcon("happy.jpg");
			
			//creates the happy label that holds the image
			happyLabel =  new JLabel("", happyImage, JLabel.CENTER);
			
			//create happy panel for when in state 1
			happy = new JPanel();
			happy.setLayout(new BoxLayout(happy, BoxLayout.Y_AXIS));
			happy.add(happyLabel);
			
			//setLayout(new BorderLayout());
			add(happy);
			
		}
		
		else if(state == 2) {
			
			//Creates the thinking image
			ImageIcon thinkingImage = new ImageIcon("thinking.jpg");
			
			//creates the thinking label that holds the image
			thinkingLabel =  new JLabel("", thinkingImage, JLabel.CENTER);
			
			//create thinking panel for when in state 2
			thinking = new JPanel();
			thinking.setLayout(new BoxLayout(thinking, BoxLayout.Y_AXIS));
			thinking.add(thinkingLabel);
			
			//setLayout(new BorderLayout());
			add(thinking);
			
		}
		
		else if(state == 3) {
			
			//Creates the worried image
			ImageIcon worriedImage = new ImageIcon("worried.jpg");
			
			//creates the worried label that holds the image
			worriedLabel =  new JLabel("", worriedImage, JLabel.CENTER);
			
			//create worried panel for when in state 3
			worried = new JPanel();
			worried.setLayout(new BoxLayout(worried, BoxLayout.Y_AXIS));
			worried.add(worriedLabel);
			//add image to panel here
			
			//setLayout(new BorderLayout());
			add(worried);
			
		}
		
		else if(state == 4) {
			
			//Creates the sorry image
			ImageIcon sorryImage = new ImageIcon("sorry.jpg");
			
			//creates the sorry label that holds the image
			sorryLabel =  new JLabel("", sorryImage, JLabel.CENTER);
			
			//create sorry panel for when in state 4
			sorry = new JPanel();
			sorry.setLayout(new BoxLayout(sorry, BoxLayout.Y_AXIS));
			sorry.add(sorryLabel);
			//add image to panel here
			
			//setLayout(new BorderLayout());
			add(sorry);
		}
		
	}
	
}
