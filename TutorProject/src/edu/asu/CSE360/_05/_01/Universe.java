package edu.asu.CSE360._05._01;
/**
* Description:
* 	Creates a Jframe that holds panels created by the the assessor, companion and tutor classes.
* 	Includes a slider used to change content within the panels, depending on the position.
* Assignment number:
* 	Recitation Project 1
* Completion time:
* 	2 Hours
*
* @author Andrew Bui
* @version 1
*/

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.Border;
import java.awt.*;

public class Universe extends JFrame
{
	public static void main(String[] args) 
	{
		//Label Containing Name
		JLabel nameLabel = new JLabel("Andrew Bui", SwingConstants.CENTER);
		
		//create Slider
		int minSlider = 0;
		int maxSlider = 4;
		JSlider slider = new JSlider(JSlider.HORIZONTAL, minSlider, maxSlider, minSlider);
		//tick marks with number labels
		slider.setMajorTickSpacing(1);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		
		//Create panels for initial state
		Companion panel1 = new Companion();
		Assessor panel2 = new Assessor();
		Tutor panel3 = new Tutor();
		JPanel panel4 = new JPanel();
		//blank panel to keep bevel consistent
		JPanel panel5 = new JPanel();
		
		//add name label to panel 
		panel4.add(nameLabel);

		//Bevel for Panels
		Border raisedBevel = BorderFactory.createLoweredBevelBorder();
		panel1.setBorder(raisedBevel);
		panel2.setBorder(raisedBevel);
		panel3.setBorder(raisedBevel);
		panel4.setBorder(raisedBevel);
		panel5.setBorder(raisedBevel);
		
		//Grid Layout to hold Jpanels
		JPanel panelGrid = new JPanel();
		panelGrid.setLayout(new GridLayout(2,2));
		panelGrid.add(panel1);
		panelGrid.add(panel2);
		panelGrid.add(panel3);
		panelGrid.add(panel4);		
		
		//Create JFrame to hold content and add close operation
		JFrame frame = new JFrame("Recitation Project 1");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Create grid to hold panels and slider to change states
		Container content = frame.getContentPane();
		content.setLayout(new BorderLayout());
		content.add(panelGrid, BorderLayout.CENTER);
		content.add(slider, BorderLayout.SOUTH);
		
		//slider listener to update the content of panels
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged (ChangeEvent e) {
				JSlider slider = (JSlider) e.getSource();
				if (!slider.getValueIsAdjusting() ) {
					int value = slider.getValue();
					
					//remove old content
					content.removeAll();
					panelGrid.removeAll();
					
					//update frame with new panels
					//re-add slider
					content.add(slider, BorderLayout.SOUTH);
					
					//create new panels - waiting for other class files
					Companion panel1 = new Companion();
					Assessor panel2 = new Assessor();
					Tutor panel3 = new Tutor();
					
					//set state - waiting for other class files
					panel1.changeState(value);
					panel2.changeState(value);
					panel3.changeState(value);
					
					//bevels
					panel1.setBorder(raisedBevel);
					panel2.setBorder(raisedBevel);
					panel3.setBorder(raisedBevel);
					
					//re-add to panelGrid
					panelGrid.add(panel1);
					panelGrid.add(panel2);
					panelGrid.add(panel3);
					
					//if slider is moved back to 0, add panel4 (name)
					if (value == 0) {
						panelGrid.add(panel4);
					}
					else {
						panelGrid.add(panel5);
					}
					
					//add grid to content
					content.add(panelGrid, BorderLayout.CENTER);
					
					//re-validate and repaint
					content.revalidate();
					content.repaint();
				}
			}
		});
		frame.setSize(1280,720);
		frame.setVisible(true);
	  }
}
