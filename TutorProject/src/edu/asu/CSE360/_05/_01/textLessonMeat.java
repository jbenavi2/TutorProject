package edu.asu.CSE360._05._01;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**

* Description:
* 	JPanel that holds lesson info, the topic can be chosen with a button at the top. The user cannot edit the text.
*   The Done button takes the user back to the lesson choices.
* Assignment number:
* 	Recitation Project 4
* Completion time:
* 	1.5 Hours
*
* @author Andrew Bui
* @version 1
*/

public class textLessonMeat extends JPanel {
	private JPanel choicePanel;
	private JTextArea textArea;
	private JScrollPane scroll;
	private JButton doneButton,riceButton, onionButton, knifeButton, fishButton, pastaButton;
	
	public textLessonMeat() {
		//layout of panels
		setLayout(new BorderLayout());
		JPanel choicePanel = new JPanel();
		choicePanel.setLayout(new FlowLayout());
		
		//buttons for choicePanel
		JButton basicButton = new JButton("Basic Anatomy");
		JButton cutButton = new JButton("Cuts of Meat");
		JButton cookingButton = new JButton("Cooking");
		//add to panel
		choicePanel.add(basicButton);
		choicePanel.add(cutButton);
		choicePanel.add(cookingButton);
		add(choicePanel, BorderLayout.NORTH);
		
		//done Button - send user back to lesson choice screen
		doneButton = new JButton("DONE");
		doneButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(doneButton,BorderLayout.SOUTH);
		
		//JTextArea, holds info, changes on button press to corresponding subject
		JTextArea textArea = new JTextArea(30,100);
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setText("Select a topic from one of the buttons above...");

		//scroll pane for text area in case text extends area
		JScrollPane scroll = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		add(scroll,BorderLayout.CENTER);
		
		//action listener for done button, takes user back to lesson choice screen
		doneButton.addActionListener(new ActionListener() {
 			public void actionPerformed(ActionEvent e) {
 				if (doneButton.isEnabled()) {
 					removeAll();
					setLayout(new BorderLayout());
					lessonChoicesMeat lcm = new lessonChoicesMeat();
					add(lcm, BorderLayout.CENTER);
					revalidate();
					repaint();
 				}
 			}
		});
		
		//action listener for subject buttons anatomy, cuts, cooking, and diagram
		//intro
		basicButton.addActionListener(new ActionListener() {
 			public void actionPerformed(ActionEvent e) {
 				if (basicButton.isEnabled()) {
 					textArea.setText("Basic Anatomy: We can cook the meat from almost every part of an animal, nose to tail. Whether we're talking about cows or goats or pigs, the major cuts are generally the same and cook in similar ways. These are as follows:" + 
 							"\r\n" + 
 							"The shoulders and legs (or shanks)\r\n" + 
 							"The middle area (loin and ribs)\r\n" + 
 							"The haunches (back thighs and legs)\r\n\n" + 
 							"These main cuts break down into lots of smaller cuts  too many to mention individually! But these are the major pieces usually found in American meat cases. And then there are the other, less common-cooked, cuts, like organ meat, tongue, tail, head, cheeks, and sweetbreads.");
 				}
 			}
		});
		//cuts of meat
		cutButton.addActionListener(new ActionListener() {
 			public void actionPerformed(ActionEvent e) {
 				if (cutButton.isEnabled()) {
 					textArea.setText("Tough Versus Tender Cuts: Picture a cow or a pig wandering around a pasture looking for food. The shoulders, haunches, and legs are getting all the workout  these big cuts are tough and lean as a result. The back gets much less of a workout, so the cuts from this middle area are generally more tender and fattier. Neither of these cuts is better than the other, but they do cook differently so it's important to be aware of the differences.\r\n" + 
 							"\r\n" + 
 							"Tender, Quick-Cooking Cuts of Meat: Tender cuts from the back (loin) region of cows, pigs, and other animals are quick-cooking cuts. These are things like ribeye steak, sirloin steak, pork chops, and pork tenderloin generally small, thin cuts that would serve one or two people. These cuts already tender and full of flavor, so they don't need much cooking to make them taste awesome. In fact, cooking these cuts too long makes the fat melt out and the muscle fibers seize up, making the meat dry, chewy, and tasteless. Use these quick-cooking cuts for fast preparations, like simple searing, stir fries, and other stovetop preparations.\n\n" +
 							"Tough, Slow-Cooking Cuts of Meat: By contrast, tough cuts from the shoulders and rear of the animal will taste dry and chewy if you don't let them cook long enough. These are cuts like beef chuck, beef round roast, pork shoulder, and pork butt, and they are generally large cuts serving multiple people. These cuts need long, slow cooking in order to break down tough connective tissues and become tender and delicious. (We'll talk about this process in much more detail when we get to the lesson on Braising in a couple weeks.) Use these tougher cuts in braises, soups and stews, and roasts.\r\n" + 
 							"\r\n" + 
 							"Your Friend, The Butcher: If you are unsure whether a particular cut is meant for quick cooking or slow cooking when you're at the meat counter, or if you don't see the specific cut called for in your recipe, ask the butcher. They are your best resource for knowing how cuts will cook, what can be substituted, and many other meat-related questions. Don't be shy!");
 				}
 			}
		});
		//cooking meat
		cookingButton.addActionListener(new ActionListener() {
 			public void actionPerformed(ActionEvent e) {
 				if (doneButton.isEnabled()) {
 					textArea.setText("Preparing Meat for Cooking: Small tender cuts are generally ready to go straight from the package. Larger cuts often have a layer or patches of fat on the outside; you can trim these away with a sharp knife. Leave any fat marbled through the middle of the meat  that's where a lot of the best flavor comes in!\r\n" + 
 							"\r\n" + 
 							"Searing Meat Before Cooking: Searing is almost always one of the first steps when cooking meat. In the case of steak, it's the only step! We sear meat for one purpose only: to give it flavor. Contrary to what you may have heard, searing does not seal in moisture or anything else it simply caramelizes the outside of the meat, adding deep and roasty umami flavors to your dish. Use high heat and sear until you see a deep golden-brown crust on the outside of the meat.\n\n" +
 							"Resting Meat After Cooking: Most meat also needs a period of resting after it's taken off the heat and before you slice into it. Usually, resting for 5 to 10 minutes is fine. During this time, moisture that was pulled to the surface during cooking settles back into the muscle fibers, keeping the meat juicy instead of tasting dry.\r\n" + 
 							"\r\n" + 
 							"Safe Cooking Temperatures: Safe minimum cooking temperatures as set by the US government are as follows:\r\n" + 
 							"\r\n" + 
 							"Ground Beef, Pork, Lamb, and Other Meat: 160F\r\n" + 
 							"Whole Cuts of Beef, Pork, Lamb, and Other Meat: 145F");
 				}
 			}
		});
	}
}
