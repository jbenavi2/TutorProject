/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AndrewTon
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

// The panels for questions
	private JPanel panelDefault;
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	private JPanel panel4;
	
	// The title labels for each panel
	private JLabel myName;
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
  
    
   
    

	 public Tutor () {
		 
		 myName = new JLabel("Andrew Ton");
		 myName.setAlignmentX(Component.CENTER_ALIGNMENT);
	     
		 panelDefault = new JPanel();
		 panelDefault.setLayout(new BoxLayout(panelDefault, BoxLayout.Y_AXIS));
		 panelDefault.add(myName);
		 setLayout(new BorderLayout());
		 add(panelDefault);
	 }
  
  
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
	        	 
	        	 java.net.URL sample1 = Tutor.class.getResource("/sample2.html");
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
	        	 
	        	 java.net.URL sample1 = Tutor.class.getResource("/sample3.html");
	        	 JEditorPane editorPane = new JEditorPane();
	        	 editorPane.setPage(sample1);
	        	 add(editorPane); 	        	 
	         }
	         
	         catch (Exception e) {
	        	 System.out.println(e);
	         }
	         
	      }           

		else if (state == 4) {
         	try {
	        	 
	        	 java.net.URL sample1 = Tutor.class.getResource("/sample4.html");
	        	 JEditorPane editorPane = new JEditorPane();
	        	 editorPane.setPage(sample4);
	        	 add(editorPane);
	         }
	         
	         catch (Exception e) {
	        	 System.out.println(e);
	         }
	         
	      }     

  
}
//"File:///Users/AndrewTon/NetBeansProjects/main/src/Resources/sample"
//"File:///Users/AndrewTon/NetBeansProjects/main/src/Resources/sample" + state + ".html"
//"File:///Users/AndrewTon/NetBeansProjects/main/src/Resources/sample" + state + ".html";
