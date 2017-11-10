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
* 	Recitation Project 3
* Completion time:
* 	1.5 Hours
*
* @author Andrew Bui
* @version 1
*/

public class textLessonEggs extends JPanel {
	private JPanel choicePanel;
	private JTextArea textArea;
	private JScrollPane scroll;
	private JButton doneButton,riceButton, onionButton, knifeButton, fishButton, pastaButton;
	
	public textLessonEggs() {
		//layout of panels
		setLayout(new BorderLayout());
		JPanel choicePanel = new JPanel();
		choicePanel.setLayout(new FlowLayout());
		
		//buttons for choicePanel
		JButton introButton = new JButton("Intro");
		JButton yolkButton = new JButton("Egg Yolks");
		JButton whiteButton = new JButton("Egg Whites");
		JButton wholeButton = new JButton("Fat and Foam");
		JButton scienceButton = new JButton("Science and Safety");
		//add to panel
		choicePanel.add(introButton);
		choicePanel.add(yolkButton);
		choicePanel.add(whiteButton);
		choicePanel.add(wholeButton);
		choicePanel.add(scienceButton);
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
					lessonList chooseLesson = new lessonList();
					add(chooseLesson, BorderLayout.CENTER);
					revalidate();
					repaint();
 				}
 			}
		});
		
		//action listener for subject buttons intro, yolks, whites, whole, and science
		//intro
		introButton.addActionListener(new ActionListener() {
 			public void actionPerformed(ActionEvent e) {
 				if (introButton.isEnabled()) {
 					textArea.setText("In day-to-day cooking, eggs can be scrambled, poached, or boiled to create easy, straightforward dishes all on their own. But when it comes to baking and pastry, the importance of their role changes from breakfast food to a vital ingredient for giving structure, texture, and flavor. The function and behavior of eggs can really vary depending on how we treat them in these recipes, and just knowing more about the different parts of an egg — the whites and the yolks — can help make even the trickiest pastries feel a little more approachable.\n"
 							+ "A Few Basic Things You Should Know About Eggs\r\n" + 
 							"At the grocery store there are dozens of different types of eggs — brown ones, whites ones, sometimes even green ones; eggs that are medium, large, and extra large. You might even see eggs from chickens, quails, or ducks!\r\n" + 
 							"\r\n" + 
 							"So what should you buy for baking and pastry? Stick with large chicken eggs, unless otherwise specified in your recipe; most U.S. baking and pastry recipes are designed to be made with large-sized chicken eggs.\n\n" +
 							"What Eggs Do in Baking Recipes\r\n" + 
 							"Eggs play an important role in everything from cakes and cookies to meringues and pastry cream — they create structure and stability within a batter, they help thicken and emulsify sauces and custards, they add moisture to cakes and other baked goods, and can even act as glue or glaze.\r\n" + 
 							"Between the yolks, the white, and the whole egg, the functions of an egg can overlap and vary widely from recipe to recipe.\n\n" +
 							"How to Crack an Egg Like a Pro\r\n" + 
 							"Now that you've learned quite a bit about eggs — ready to crack a few? The baking pros always crack their eggs by rapping them on a flat surface or the inside wall of a mixing bowl. This avoids small bits of jagged shell getting forced inside the egg, which can puncture the yolk and leave tiny, annoying bits of shell to fish from the bowl. If you do get a bit of shell in your bowl, use a larger piece of the shell left in your hand to scoop it out; the sharp edge of the egg shell will break the surface tension and make it easier to scoop out the stray shell.\r\n" + 
 							"\r\n" + 
 							"It's also best to crack eggs into a smaller bowl, separate from your actual mixing bowl. This makes it easier to scoop out the stray bits of shell, and also helps prevent having to start completely over if you accidentally break a yolk that you needed left whole — throwing away one broken egg (or saving it for dinner!) is better than tossing a whole mixing bowl of ingredients.");
 				}
 			}
		});
		//yolks
		yolkButton.addActionListener(new ActionListener() {
 			public void actionPerformed(ActionEvent e) {
 				if (yolkButton.isEnabled()) {
 					textArea.setText("The Role of Egg Yolks: Fat\r\n" + 
 							"Recipes that use just the yolk of an egg typically do so for the yolk's fat content and emulsifying abilities. The fat gives baked goods extra-rich flavor and a velvety texture. The yolk also has the unique ability to bind liquids and fats together, creating an emulsion that prevents them from separating. This emulsion process helps create a more homogenous mix of ingredients — aiding in an even distribution of liquid and fats throughout a recipe for smooth batters, satiny custards, and creamy curds.\r\n" + 
 							"\r\n" + 
 							"When yolks are heated, the proteins they contain unfold and gel together. This is a delicate situation; t0o much heat and the proteins will gel too much and turn curdled and grainy, but when warmed gently over low heat, egg yolks have a great ability to thicken products like sauces and custards. Again, their emulsifying properties enhance and thicken cream when they are cooked together.\r\n" + 
 							"\r\n" + 
 							"→ Common recipes that often use just the egg yolks: Custards, pastry cream, cakes, ice cream, creme brûlée, and curds.");
 				}
 			}
		});
		//whites
		whiteButton.addActionListener(new ActionListener() {
 			public void actionPerformed(ActionEvent e) {
 				if (doneButton.isEnabled()) {
 					textArea.setText("The Role of Egg Whites: Foam!\r\n" + 
 							"When egg whites are used alone, they perform an entirely different role from the yolks, especially when whipped. Whipping and using egg whites in a recipe does not have to be as intimidating as you may think, and we'll be talking much more about this in a few days. For now, just know that whipping egg whites means incorporating millions of little air bubbles within the white. This creates a fairly stable foam that we can use to make everything from a soufflé to meringue. To help stabilize egg whites even further, we can add acidic elements, like cream of tartar and lemon juice.\r\n" + 
 							"\r\n" + 
 							"One of the best ways to use whipped egg whites is as a natural leavening agent in something like a delicate cake or a soufflé. In the heat of the oven, the air trapped in the foam starts to expand, causing the recipe rise without the need for things like yeast or baking soda. In fact, whipped egg whites are how many classic baked goods, like sponge cakes, got their lift in the days before baking soda and baking powder!\r\n" + 
 							"\r\n" + 
 							"Egg whites can also be whipped with sugar to make meringue, which can then be baked into crunchy meringue kisses, made into billowy pavlovas, or dolloped on top of desserts like baked Alaska. Sugar makes whipped egg whites incredibly stable — you can even pipe it using a piping bag into stars, kisses, and toadstools.\r\n" + 
 							"\r\n" + 
 							"While the idea of \"light\" and \"airy\" whipped egg whites might make you think that more is better, it is possible to overdo it. Over-whipped whites will become clumpy, grainy, and difficult to fold into your batter. Also, using too many whites in a batter can wind up making the final product dry.\r\n" + 
 							"\r\n" + 
 							"→ Common recipes that often use just egg whites: Meringues, pavlova, chiffon cakes, macarons, marshmallows, marshmallow fluff, and frostings.");
 				}
 			}
		});
		//whole eggs
		wholeButton.addActionListener(new ActionListener() {
 			public void actionPerformed(ActionEvent e) {
 				if (doneButton.isEnabled()) {
 					textArea.setText("The Role of Whole Eggs: Fat and Foam\r\n" + 
 							"When you use whole eggs in a recipe, you get some of the best properties of both the yolk and the white. While whole eggs aren't quite as good as straight yolks at creating an emulsion, they are still excellent binding agents, especially in cakes, cookies, and other baked goods. Eggs also firm up and solidify when heated, giving crucial structural support to delicate desserts and pastries. At the same time, eggs make baked goods more tender, creating light textures, soft breads, and delicate crumbs.\r\n" + 
 							"\r\n" + 
 							"When mixed with sugar (like in a cake or cookie batter), eggs help trap and hold air — not quite as well as whipped egg whites, but enough to give the finished product some lightness and lift. The combination of eggs and sugar also adds a great deal of moisture and flavor to a recipe.\r\n" + 
 							"\r\n" + 
 							"Yolks and whites can also be used separately in the same recipe. This truly is the best of both worlds, with the yolks providing richness to a base or batter while the whipped whites do their job of lightening and leavening. Chiffon cakes and soufflés are good examples of this kind of recipe.\r\n" + 
 							"\r\n" + 
 							"→ Common recipes that use whole eggs: Butter cakes, cookies, brownies, bread doughs, waffles, pancakes, muffins, and pastries.");
 				}
 			}
		});
		//science + safety
		scienceButton.addActionListener(new ActionListener() {
 			public void actionPerformed(ActionEvent e) {
 				if (doneButton.isEnabled()) {
 					textArea.setText("Master the Basics of Egg Science & Safety\r\n" + 
 							"Now that you have a basic understand of what eggs do in a recipe, make sure you know the basics of how and why they cook, and when they're safe to eat.\r\n" + 
 							"\r\n" + 
 							"What Is Egg Coagulation?\r\n" + 
 							"Coagulation is what happens when you cook eggs. When raw eggs are exposed to heat and then gel into a solid very quickly, we call this coagulation. Eggs begin to coagulate at 140°F and will set more firmly as the temperature rises. Over-coagulation, or \"curdling,\" may occur when the eggs are cooked at too high a temperature, or if they're cooked for too long. If you have ever experienced a grainy custard or a rubbery cake, this may be the culprit.\r\n" + 
 							"\r\n" + 
 							"What's Important to Know About Egg Temperature?\r\n" + 
 							"Depending on the recipe, eggs may need to be room temperature when they get mixed with the other ingredients. Recipes for cakes and other baked goods often call for room-temperature eggs because they bind and emulsify better than cold ones. Additionally, room-temperature egg whites whip up better than their colder counterparts. If a recipe doesn't specify the egg temperature, it's usually safe to assume that the temperature isn't crucial to the recipe and the eggs can be added either straight from the fridge or at room temperature.\r\n" + 
 							"\r\n" + 
 							"By the way, if you need to separate your eggs, do it while they are cold; the yolks are less likely to break and it's easier separate the yolk from the white. Also, to quickly warm up refrigerated eggs, just cover cold eggs in a bowl with warm tap water for a few minutes while you gather your remaining ingredients.\r\n" + 
 							"\r\n" + 
 							"Egg Safety\r\n" + 
 							"Trace amounts of salmonella — the bacteria responsible for many incidents of food poisoning — can sometimes be found in raw eggs. Although it's rare for someone to actually get sick from consuming raw or undercooked eggs, it's best to be careful, especially when serving egg dishes and desserts to people with compromised immune systems, the elderly, the young, and pregnant women. In these cases, be extra sure to cook eggs and egg dishes thoroughly (to 160°F), or use pasteurized eggs. Also, be mindful of cross-contamination between raw eggs and other ingredients.");
 				}
 			}
		});
	}
}
