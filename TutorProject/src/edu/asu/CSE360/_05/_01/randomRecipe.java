package edu.asu.CSE360._05._01;

/**

* Description:
* 	Creates a JPanel that displays a randomized recipe
* 	Plays music
* Assignment number:
* 	Recitation Project 4
* Completion time:
* 	2 Hours
*
* @author Andrew Bui
* @version 1
*/

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.Font;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

public class randomRecipe extends JPanel {

	/**
	 * Create the panel.
	 */
	public randomRecipe(int x) {
		setBackground(Color.DARK_GRAY);
		setLayout(null);
		int parent = x;
		
		//text area for recipe
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setBounds(81, 53, 1067, 630);


		
		//Recipe Bank
		List<String> Recipes = new ArrayList<String>();
		String r1 = "Crispy Hasselback Potatoes with Spicy Bacon Scallion Relish\r\n\n"
				+ "Ingredients\r\n" + 
				"6 medium russet potatoes, scrubbed\r\n" + 
				"Olive oil\r\n" + 
				"Salt and pepper\r\n" + 
				"4 ounces bacon, chopped\r\n" + 
				"1 tablespoon cumin seeds\r\n" + 
				"1 teaspoon red chili flakes\r\n" + 
				"2 scallions, chopped\r\n" + 
				"Instructions\r\n" + 
				"Preheat your oven to 400 degrees F.\r\n" + 
				"Place each potato between the handles of 2 chopsticks or\r\n" + 
				"wooden spoons. Slice the potato into thin slices, leaving ¼\r\n" + 
				"inch at the bottom unsliced (the chopsticks/spoon handles\r\n" + 
				"will prevent you from slicing the potato all the way through).\r\n\n" + 
				"Repeat with the remaining potatoes.\r\n\n" + 
				"Place on a parchment-lined baking sheet, and brush\r\n" + 
				"thoroughly with olive oil, making sure to get the oil in between\r\n" + 
				"all the potato layers. Season with salt and pepper to taste, and\r\n" + 
				"roast in the oven for 1 hour and 20 minutes.\r\n\n" + 
				"When the potatoes are almost done roasting (i.e. when\r\n" + 
				"there are about 10 minutes of roasting time left), sautee the\r\n" + 
				"bacon in a pan over medium heat until crisp. Lightly smash\r\n" + 
				"the cumin seeds using a mortar and pestle, and add to the\r\n" + 
				"bacon along with the chili flakes and scallions. Stir, remove\r\n" + 
				"from the heat, and sprinkle over the potatoes.\r\n\n" + 
				"Serve!";
		
		String r2 = "Crispy Panko Chicken with Arugula, Parmesan, and Roasted Tomatoes\r\n\n"
				+ "GRADE\r\n" + 
				"\r\n" + 
				"Serves: 2\r\n" + 
				"Cost: $\r\n" + 
				"Skill Level: Easy\r\n" + 
				"Time to Make: 35 minutes\r\n" + 
				"INGREDIENTS\r\n" + 
				"\r\n" + 
				"1 pound thinly sliced chicken breast\r\n" + 
				"2 eggs\r\n" + 
				"1 teaspoon dijon mustard\r\n" + 
				"1 teaspoon honey\r\n" + 
				"1/2 teaspoon cayenne powder\r\n" + 
				"Salt and pepper to taste\r\n" + 
				"1 cup panko\r\n" + 
				"8-10 cherry tomatoes\r\n" + 
				"1/4 cup olive (or vegetable) oil, plus 2 tablespoons olive oil, divided\r\n" + 
				"2 cups arugula\r\n" + 
				"1 lemon\r\n" + 
				"Sprinkle of sugar, optional\r\n" + 
				"1/2 English cucumber\r\n" + 
				"1/4 cup fresh basil\r\n" + 
				"Shaved parmesan, for serving\r\n" + 
				"METHOD\r\n" + 
				"\r\n" + 
				"Prepare Ingredients: Preheat oven to 400ºF. Toss the cherry tomatoes in 1 tablespoon olive oil and season with salt and pepper on one half of a roasting pan (leaving the other half empty for the chicken) and transfer to the oven for 15-20 minutes. Pat the chicken dry and season with salt and pepper. Thinly slice the cucumber.\r\n" + 
				"Bread the Chicken: In a shallow bowl, whisk the eggs with the honey, dijon mustard, cayenne powder, and a sprinkle of salt and pepper. In another shallow bowl, combine the panko with just a touch of salt and pepper. Dip the chicken breasts into the egg mixture, shaking off the excess, and then into the panko, pressing the panko into the chicken to ensure it adheres. Transfer to a plate.\r\n" + 
				"Fry the Chicken: In a large skillet, heat the 1/4 cup of oil over medium high until very hot and almost smoking. Add the chicken, cooking in batches if necessary to avoid over-crowding the skillet, and cook for 3-5 minutes per side until well browned all over. Reduce the heat in the oven to 200ºF and transfer the breasts to the other half of the roasting pan to keep warm.\r\n" + 
				"Prepare the Salad: In a medium bowl, combine the juice of the lemon along with the remaining 1 tablespoon of olive oil and whisk until smooth. Season with salt, pepper, and a sprinkle of sugar if desired. Toss the arugula and sliced cucumber in the dressing. Tear the basil leaves and gently toss them with the arugula and cucumber. Set aside\r\n" + 
				"To Serve: Divide the dressed salad between plates and arrange a few roasted tomatoes on top along with the shaved parmesan. Serve with the crispy chicken breasts on the side. Enjoy!";
		
		String r3 = "Butternut Squash Soup with Bacon and Goat Cheese\r\n\n"
				+ "Preheat oven to 400 degrees.\r\n" + 
				"Cut 1 butternut squash(about 3 lbs) into 1 inch chunks. Dice 1 onion. Chop on red bell pepper. Dice at least 4 slices of bacon (I used more). Mince 3 cloves garlic.\r\n" + 
				"Put all of that on a baking sheet. Add olive oil, salt and pepper. Mix that bad boy up.\r\n" + 
				"Bake for 30 minutes (stir halfway through).\r\n" + 
				"Heat up a Dutch oven or larger stock pot. Add cooked squash mixture to it with some thyme. Stir that up and cook for 2 minutes or so. Season with salt and pepper to taste.\r\n" + 
				"Add in 3 Cups of chicken stock and puree with an immersion blender. Alternately you can let it cool a little and use a regular blender in batches.\r\n" + 
				"Bring it to a boil and then reduce the heat and simmer until you're ready to eat. If it is too thick, add more stock, mix, cook, and simmer again.\r\n" + 
				"Cook up some more bacon (at least 4 pieces. Again... I did more because bacon). Set that aside on a paper towel.\r\n" + 
				"When you're ready to eat, plate the soup, top with crumbled goat cheese, chopped bacon and chives.";
		
		String r4 = "Pickle Bloody Mary Shooters\r\n\n"
				+ "INGREDIENTS\r\n" + 
				"8 large pickles Old bay seasoning, for rimming 1 c. tomato juice, chilled 6 oz. vodka 1 tbsp. Worcestershire sauce 2 tsp. horseradish 1 tsp. Hot sauce Juice of 1/2 lemon Freshly ground black pepper Celery leaves, for garnish\r\n" + 
				"DIRECTIONS\r\n" + 
				"Make pickle shot glasses: Cut off the ends of each pickle so that both ends are flat, then cut each pickle in half crosswise. Using a quarter teaspoon, scoop out the middle of each pickle to create a well. Dip the top of each shot glass into Old Bay seasoning.\r\n" + 
				"In a large pitcher, combine tomato juice, vodka, Worcestershire, horseradish, hot sauce, lemon juice, and pepper. Stir until combined.\r\n" + 
				"Pour into pickle shot glasses and garnish with celery leaves.";
		
		String r5 = "Bejeweled Rice\r\n\n" + 
				"Ingredients\r\n" + 
				"⅓ cup unsalted, shelled pistachios\r\n" + 
				"⅓ cup slivered almonds\r\n" + 
				"4 tablespoons extra-virgin olive oil, divided\r\n" + 
				"2 large carrots, peeled, thinly sliced into rounds on a mandolin\r\n" + 
				"2 teaspoons sugar\r\n" + 
				"Kosher salt\r\n" + 
				"8 scallions, dark green parts and white parts separated, thinly sliced\r\n" + 
				"3 garlic cloves, thinly sliced\r\n" + 
				"3 cups long-grain rice, rinsed\r\n" + 
				"¾ teaspoon crushed red pepper flakes\r\n" + 
				"¾ teaspoon ground cardamom\r\n" + 
				"¾ teaspoon ground cinnamon\r\n" + 
				"¾ teaspoon ground turmeric\r\n" + 
				"4 tablespoons unsalted butter, cut into pieces\r\n" + 
				"2 teaspoons finely grated orange zest\r\n" + 
				"1 cup mixed unsweetened dried fruit (such as golden raisins,\r\n" + 
				"cranberries, and/or sour cherries)\r\n" + 
				"Preparation\r\n" + 
				"Preheat oven to 350°. Arrange pistachios and almonds on opposite\r\n" + 
				"sides of a rimmed baking sheet and toast, shaking pan gently halfway\r\n" + 
				"through, until almonds are golden brown and pistachios are slightly\r\n" + 
				"darkened, 6–8 minutes. Let cool, then coarsely chop pistachios.\r\n" + 
				"Meanwhile, heat 1 Tbsp. oil in a large heavy pot over medium.\r\n" + 
				"Cook carrots, stirring occasionally, until softened but haven't taken on\r\n" + 
				"any color, 8–10 minutes. Stir in sugar and a pinch of salt and cook\r\n" + 
				"until sugar dissolves, about 1 minute more. Transfer carrot mixture to\r\n" + 
				"a medium bowl.\r\n" + 
				"Heat remaining 3 Tbsp. oil in same pot over medium. Cook scallion\r\n" + 
				"whites and garlic, stirring occasionally, until softened, 4–6 minutes.\r\n" + 
				"Stir in rice, red pepper flakes, cardamom, cinnamon, and turmeric;\r\n" + 
				"cook, stirring often, until some grains are translucent, about 3 minutes.\r\n" + 
				"Add 3¾ cups water, season with 1 Tbsp. salt, and bring to a boil.\r\n" + 
				"Reduce heat to medium-low, cover, and simmer until rice is tender,\r\n" + 
				"15–18 minutes. Remove from heat, add butter and orange zest, and\r\n" + 
				"fluff rice with a fork. Cover pot and let rice steam 10 minutes.\r\n" + 
				"Spoon pilaf onto a platter. Top with neatly defined rows of dried fruit,\r\n" + 
				"almonds, pistachios, carrots, and scallion greens.";
		
		Recipes.add(r1);
		Recipes.add(r2);
		Recipes.add(r3);
		Recipes.add(r4);
		Recipes.add(r5);

		//randomly pick recipe to display
		Random rand = new Random();
		int value = rand.nextInt(4);
		String recipe= Recipes.get(value);
		textArea.setText(recipe);
		JScrollPane scroll = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setBounds(81, 53, 1067, 630);
		add(scroll);
		
		
		
		//back button goes back to lesson choices.
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (btnBack.isEnabled()) {
					if (parent == 0) {
						removeAll();
						setLayout(new BorderLayout());
						lessonChoicesBasics lessonPanel = new lessonChoicesBasics();
						add(lessonPanel,BorderLayout.CENTER);
						revalidate();
						repaint();
					}
					if (parent == 1) {
						removeAll();
						setLayout(new BorderLayout());
						lessonChoicesEggs lessonPanel = new lessonChoicesEggs();
						add(lessonPanel,BorderLayout.CENTER);
						revalidate();
						repaint();
					}
					if (parent == 2) {
						removeAll();
						setLayout(new BorderLayout());
						lessonChoicesMeat lessonPanel = new lessonChoicesMeat();
						add(lessonPanel,BorderLayout.CENTER);
						revalidate();
						repaint();
					}
				}
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBack.setBounds(10, 11, 89, 23);
		add(btnBack);

	}
}
