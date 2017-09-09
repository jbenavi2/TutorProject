package edu.asu.CSE360._05._01;
/*
 * This panel will load one of four different HTML files
 * Assignment number: Recitation Project 1
* Completion time: 3.0 hours
 */

/**
 *
 * @author AndrewTon
 * @version 1.0
 */
import static java.awt.AWTEventMulticaster.add;
import java.awt.BorderLayout;
import java.net.URL;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import java.awt.Component;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Tutor extends JPanel {

// The panels for initial loading
	private JPanel panelDefault;
	
	// The title labels for my name
	private JLabel myName;
  
    
   
    

	 public Tutor () {
		 
		 myName = new JLabel("Andrew Ton");
		 myName.setAlignmentX(Component.CENTER_ALIGNMENT);
	     
		 panelDefault = new JPanel();
		 panelDefault.setLayout(new BoxLayout(panelDefault, BoxLayout.Y_AXIS));
		 panelDefault.add(myName);
		 setLayout(new BorderLayout());
		 add(panelDefault);
	 }//end Tutor
  
  
	 public void changeState (int state) {
  
		 if (state == 0) {			 
    	  
	          myName = new JLabel("Andrew Ton");
	          myName.setAlignmentX(Component.CENTER_ALIGNMENT);
	          panelDefault = new JPanel();
	          panelDefault.setLayout(new BoxLayout(panelDefault, BoxLayout.Y_AXIS));
	          panelDefault.add(myName);
	          setLayout(new BorderLayout());
	          add(panelDefault);
		 }
      
	     	else if (state == 1) {
	   	try {
	        	 
	        	 java.net.URL sample1 = Tutor.class.getResource("/sample1.html");
	        	 JEditorPane editorPane = new JEditorPane();
	        	 editorPane.setPage(sample1);
	        	 add(editorPane);
			}
	         
	         catch (Exception e) {
	        	 System.out.println(e);
	         }
	         
	      }
		 
		 
		 
      		else if (state == 2) {
           	try {
	        	 
	        	 java.net.URL sample2 = Tutor.class.getResource("/sample2.html");
	        	 JEditorPane editorPane = new JEditorPane();
	        	 editorPane.setPage(sample2);
	        	 add(editorPane);	
	         	}
	         
	         catch (Exception e) {
	        	 System.out.println(e);
	         }
	         
	      }      


		else if (state == 3) {
           	try {
	        	 
	        	 java.net.URL sample3 = Tutor.class.getResource("/sample3.html");
	        	 JEditorPane editorPane = new JEditorPane();
	        	 editorPane.setPage(sample3);
	        	 add(editorPane); 	        	 
	         }
	         
	         catch (Exception e) {
	        	 System.out.println(e);
	         }
	         
	      }           

		else if (state == 4) {
         	try {
	        	 
	        	 java.net.URL sample4 = Tutor.class.getResource("/sample4.html");
	        	 JEditorPane editorPane = new JEditorPane();
	        	 editorPane.setPage(sample4);
	        	 add(editorPane);
	         }
	         
	         catch (Exception e) {
	        	 System.out.println(e);
	         }
	         
	      }
	 }

  
}
