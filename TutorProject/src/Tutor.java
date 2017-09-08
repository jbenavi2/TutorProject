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
	        	 	        	 
//	        	 String url = "src/sample" + state + ".html";
//	        	 System.out.println(url);
//	        	 JEditorPane editorPane = new JEditorPane(url);
//	        	 JFrame frame = new JFrame();
//	        	 frame.getContentPane().add(editorPane, BorderLayout.CENTER);
//	        	 frame.setSize(250, 250);
//	        	 frame.setVisible(true);
	         }
	         
	         catch (Exception e) {
	        	 System.out.println(e);
	         }
	         
	      }
		 
		 
		 
      else if (state == 2) {
           try {
    String url = "File:///Users/AndrewTon/NetBeansProjects/Tutor/src/Resources/sample" + state + ".html";
    JEditorPane editorPane = new JEditorPane(url);
     JFrame frame = new JFrame();
    frame.getContentPane().add(editorPane, BorderLayout.CENTER);
    frame.setSize(250, 250);
    frame.setVisible(true);
      }
      catch (Exception e) {
          System.out.println(e);
      }
      }
      else if (state == 3) {
           try {
    String url = "File:///Users/AndrewTon/NetBeansProjects/Tutor/src/Resources/sample" + state + ".html";
    JEditorPane editorPane = new JEditorPane(url);
     JFrame frame = new JFrame();
    frame.getContentPane().add(editorPane, BorderLayout.CENTER);
    frame.setSize(250, 250);
    frame.setVisible(true);
      }
      catch (Exception e) {
          System.out.println(e);
      }
      }
      else if (state == 4) {
          try {
    String url = "File:///Users/AndrewTon/NetBeansProjects/Tutor/src/Resources/sample" + state + ".html";
    JEditorPane editorPane = new JEditorPane(url);
     JFrame frame = new JFrame();
    frame.getContentPane().add(editorPane, BorderLayout.CENTER);
    frame.setSize(250, 250);
    frame.setVisible(true);
      }
      catch (Exception e) {
          System.out.println(e);
      }
      }
      
  } 

  
}
//"File:///Users/AndrewTon/NetBeansProjects/main/src/Resources/sample"
//"File:///Users/AndrewTon/NetBeansProjects/main/src/Resources/sample" + state + ".html"
//"File:///Users/AndrewTon/NetBeansProjects/main/src/Resources/sample" + state + ".html";