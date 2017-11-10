package edu.asu.CSE360._05._01;


/**

* Description:
* 	Creates a Jframe that holds the first panel, a list of lessons and all subsequent panels
* Assignment number:
* 	Recitation Project 3
* Completion time:
* 	0.5 Hours
*
* @author Andrew Bui
* @version 1
*/

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import sun.audio.*;
import java.io.*;

public class Universe extends JFrame
{
	public static void main(String[] args) 
	{
			
		//Create JFrame to hold content and add close operation
		JFrame frame = new JFrame("Cooking Tutor");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container content = frame.getContentPane();
		
		//start music
		//comment out if this throws error. Uses restricted API? Had to change eclipse setting to get it working
		String Filename = "resources/song.wav";
		try {
			InputStream in = new FileInputStream(Filename);
			// Create an AudioStream object from the input stream.
			AudioStream as = new AudioStream(in);         
			// Use the static class member "player" from class AudioPlayer to play
			// clip.
			AudioPlayer.player.start(as);           	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
         
		
		
		//initial State - Choose Lesson
		//content.setLayout(new GridBagLayout());
		//lessonList chooseLesson = new lessonList();
		Login loginScreen = new Login();
		content.add(loginScreen);
		
		//set frame size and visible
		frame.setSize(1280,720);
		frame.setResizable(false);
		frame.setVisible(true);
	  }
}
