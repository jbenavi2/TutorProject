package edu.asu.CSE360._05._01;


import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class textLesson extends JPanel {
	private JPanel choicePanel;
	private JTextArea textArea;
	private JScrollPane scroll;
	private JButton doneButton,riceButton, onionButton, knifeButton, fishButton, pastaButton;
	
	public textLesson() {
		//layout of panels
		setLayout(new BorderLayout());
		JPanel choicePanel = new JPanel();
		choicePanel.setLayout(new FlowLayout());
		
		//buttons for choicePanel
		JButton riceButton = new JButton("Rice");
		JButton onionButton = new JButton("Onions");
		JButton knifeButton = new JButton("Knives");
		JButton fishButton = new JButton("Fish");
		JButton pastaButton = new JButton("Pasta");
		//add to panel
		choicePanel.add(riceButton);
		choicePanel.add(onionButton);
		choicePanel.add(knifeButton);
		choicePanel.add(fishButton);
		choicePanel.add(pastaButton);
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
 					revalidate();
 					repaint();
					lessonChoices lessonPanel = new lessonChoices();
					add(lessonPanel,BorderLayout.CENTER);
 				}
 			}
		});
		
		//action listener for subject buttons rice,onion,knife,fish and pasta
		//rice
		riceButton.addActionListener(new ActionListener() {
 			public void actionPerformed(ActionEvent e) {
 				if (riceButton.isEnabled()) {
 					textArea.setText("What You Need\r\n" + 
					"\r\n" + 
					"measuring cup\r\n" + 
					"water\r\n" + 
					"saucepan with lid\r\n" + 
					"salt\r\n" + 
					"rice\r\n" + 
					"wooden spoon\r\n" + 
					"fork\r\n" +
					"\r\n" +
					"Follow These Steps\r\n" + 
					"\r\n" + 
					"Boil water and add salt\r\n" + 
					"Pour water (for every cup of rice, use 1 cup of water) into a large saucepan with a tight-fitting lid. Bring to a boil. Mix 1 teaspoon salt into the water.\r\n" + 
					"Pour in rice\r\n" + 
					"Add it to the boiling water.\r\n" + 
					"Stir once, or just enough to separate the rice\r\n" + 
					"Use a wooden spoon to separate any clumps. Don’t over-stir: That can cause the rice to become sticky.\r\n" + 
					"Cover the pot and simmer\r\n" + 
					"Be sure the lid fits tightly on the pot. Turn down the heat to its lowest setting. Let rice simmer for about 18 minutes, then remove from heat and allow the rice to steam in the pot for another 5 minutes.\r\n" + 
					"Fluff rice with a fork\r\n" + 
					"Just before serving, gently fluff the rice with a fork to separate the grains.\r\n" + 
					"\r\n" + 
					"Tip: Do not uncover the saucepan or stir the rice during cooking. If it is done before you are ready to serve it, place a folded towel over the saucepan, replace the lid, and set aside. The towel will absorb excess moisture and condensation, helping prevent overcooked and mushy rice.");
 				}
 			}
		});
		//onion
		onionButton.addActionListener(new ActionListener() {
 			public void actionPerformed(ActionEvent e) {
 				if (onionButton.isEnabled()) {
 					textArea.setText("What You Need\r\n" + 
					"\r\n" + 
					"onions\r\n" + 
					"cutting board\r\n" + 
					"chef's knife\r\n" +
					"\r\n" +
					"Follow These Steps\r\n" + 
					"\r\n" + 
					"Cut the top, then slice in half\r\n" + 
					"Using a sharp chef’s knife, slice about a half an inch off the top of the onion and discard. Turn the onion to rest on this flat end and slice in half vertically.\r\n" + 
					"\r\n" + 
					"Tip: If you’re only using half of the onion, leave the skin on and wrap what you’re not using in plastic wrap.\r\n" + 
					"Peel off the papery layers\r\n" + 
					"Remove and discard the skin.\r\n" + 
					"Chop vertically\r\n" + 
					"Take one onion half and lay it flat on your cutting board. Holding the root end, carefully cut vertically, making sure not to slice all the way through.\r\n" + 
					"\r\n" + 
					"Tip: Leave the root side intact to make chopping easier.\r\n" + 
					"Chop horizontally\r\n" + 
					"Rotate the onion and slice vertically down through the onion, still leaving the root end intact. Discard the root end and repeat with the remaining half of the onion.\r\n" + 
					"\r\n" + 
					"Tip: The closer together the initial horizontal and vertical cuts are, the smaller the dice.");
 				}
 			}
		});
		//knife
		knifeButton.addActionListener(new ActionListener() {
 			public void actionPerformed(ActionEvent e) {
 				if (doneButton.isEnabled()) {
 					textArea.setText("There is nothing more frustrating in the kitchen than a dull knife. Not only does it make prep work a chore and your finished product less attractive, it's also downright dangerous. A dull blade requires more pressure to cut into a food, and can easily slip off of a tough onion skin and into your finger. Ouch.\r\n" + 
 							"\r\n" + 
 							"Most home cooks should sharpen their knives at least twice a year, and much more frequently if they use their knives every day. There are three ways to go about it.\r\n" + 
 							"\r\n" + 
 							"Method 1: Use an Electric Sharpener. A good quality electric sharpener is an option, but I strongly discourage their use. First off, they remove a tremendous amount of material from your edge. Sharpen your knife a dozen times, and you've lost a good half-centimeter of width, throwing it off balance, and rendering any blade with a bolster (i.e. most high quality forged blades) useless. Secondly, even the best models provide only an adequate edge. If you don't mind replacing your knives every few years and are happy with the edge they give you, they are an option. But a much better choice is to...\r\n" + 
 							"\r\n" + 
 							"Method 2: Send it out to a professional. This is a good option—provided you have a good knife sharpener living nearby, and are willing to pay to have the services performed. If you plan to sharpen your blades a dozen or so times a year as I do, this can get quite expensive. All but the best pros also use a grinding stone, which again will take away much more material than is necessary from your blade, reducing its lifespan. Want to forge a stronger relationship with your blade? Then you'll want to...\r\n" + 
 							"\r\n" + 
 							"Method 3: Use a Sharpening Stone. The best method by far. Not only will it give you the best edge, it also removes the least amount of material. With a fine enough grit, your knife should be able to take hairs off your arm when you've finished. Additionally—and I'm not kidding about the importance of this one—the act of sharpening your knife will help you create a much stronger bond with your blade, and a knife that is treated respectfully will behave much better for its owner.");
 				}
 			}
		});
		//fish
		fishButton.addActionListener(new ActionListener() {
 			public void actionPerformed(ActionEvent e) {
 				if (doneButton.isEnabled()) {
 					textArea.setText("To start, place fish skin side down on the cutting board.\r\n" + 
 							"Tip: If not being served immediately, fresh fish should be refrigerated and cooked within a day. If it is being frozen, keep the skin on to help protect the fish from freezer burn.\r\n\n" +
 							"Dip your fingers in coarse salt or wrap the tail end of the fillet with part of a paper towel to keep it from slipping out of your grip.\r\n\n" +
 							"With a sharp, thin-bladed knife, make a small cut through the base of the tail, then slightly loosen the flesh from the skin.\r\n\n" +
 							"Firmly holding the tail end of the skin that has been separated from the flesh, slide the knife between the skin and the flesh. Make sure to keep the knife flush against the skin.\r\n\n" +
 							"Using a gentle sawing motion, continue to slide the knife down the length of the fillet until the entire piece of skin is loosened. Discard any small scales left on the fish or the cutting board.\r\n\n" +
 							"Next, run a clean hand across the surface of the fillet to feel for any small bones. Using a pair of fish tweezers or needle-nose pliers, carefully remove each pin bone individually. Before cooking, double check the fillet to make sure you've removed all the bones.");
 				}
 			}
		});
		//pasta
		pastaButton.addActionListener(new ActionListener() {
 			public void actionPerformed(ActionEvent e) {
 				if (doneButton.isEnabled()) {
 					textArea.setText("What You Need\r\n" + 
 							"\r\n" + 
 							"water\r\n" + 
 							"large pot\r\n" + 
 							"pasta\r\n" + 
 							"salt\r\n" + 
 							"tongs\r\n" + 
 							"colander\r\n\n" + 
 							"Follow These Steps\r\n" + 
 							"\r\n" + 
 							"Boil water in a large pot\r\n" + 
 							"To make sure pasta doesn’t stick together, use at least 4 quarts of water for every pound of noodles.\r\n" + 
 							"Salt the water with at least a tablespoon—more is fine\r\n" + 
 							"The salty water adds flavor to the pasta.\r\n" + 
 							"Add pasta\r\n" + 
 							"Pour pasta into boiling water. Don’t break the pasta; it will soften up within 30 seconds and fit into the pot.\r\n" + 
 							"Stir the pasta\r\n" + 
 							"As the pasta starts to cook, stir it well with the tongs so the noodles don’t stick to each other (or the pot).\r\n" + 
 							"Test the pasta by tasting it, it should be firm but not crunchy\r\n" + 
 							"Follow the cooking time on the package, but always taste pasta before draining to make sure the texture is right. Pasta cooked properly should be al dente—a little chewy.\r\n" + 
 							"Drain the pasta\r\n" + 
 							"Drain cooked pasta well in a colander. If serving hot, add sauce right away; if you’re making a pasta salad, run noodles under cold water to stop the cooking.");
 				}
 			}
		});
	}
}
