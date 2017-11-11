package edu.asu.CSE360._05._01;

/**

* Description:
* 	Creates a JPanel that has a dropbox of all the lessons and will direct the user to the chosen lesson
* 	Plays music
* Assignment number:
* 	Recitation Project 4
* Completion time:
* 	1 Hours
*
* @author Andrew Bui
* @version 1
*/

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.BorderLayout;
import javax.swing.border.EtchedBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class lessonList extends JPanel {
	
	//assessor and mutator for lesson choice
	public static int lessonChoice = 0;
	public static void changeLessonChoice(int x) {
		lessonChoice = x;
	}
	
	public static int checkLessonChoice() {
		return lessonChoice;
	}
	/**
	 * Create the panel.
	 */
	@SuppressWarnings("unchecked")
	public lessonList() {
		setBackground(Color.DARK_GRAY);
		setLayout(null);
		
		JComboBox lessonList = new JComboBox();
		lessonList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (lessonList.getSelectedItem() == "Basics of Cooking") {
					changeLessonChoice(1);
				}
				else if (lessonList.getSelectedItem() == "Eggs and Baking") {
					changeLessonChoice(2);
				}
				else if (lessonList.getSelectedItem() == "Meat") {
					changeLessonChoice(3);
				}
				else {
					changeLessonChoice(0);
				}
			}
		});
		
		lessonList.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lessonList.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lessonList.setModel(new DefaultComboBoxModel(new String[] {"Select A Lesson...", "Basics of Cooking", "Eggs and Baking", "Meat"}));
		((JLabel)lessonList.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);

		lessonList.setBounds(335, 103, 610, 104);
		add(lessonList);
		
		JButton backButton = new JButton("BACK");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (backButton.isEnabled()) {
					removeAll();
					setLayout(new BorderLayout());
					TutorOptions tutorChoice = new TutorOptions();
					add(tutorChoice, BorderLayout.CENTER);
					revalidate();
					repaint();
				}
			}
		});
		backButton.setBounds(10, 11, 89, 23);
		add(backButton);
		
		JButton goButton = new JButton("GO!");
		goButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (goButton.isEnabled()) {
					if (checkLessonChoice() == 1) {
						removeAll();
						setLayout(new BorderLayout());
						lessonChoicesBasics lessonPanel = new lessonChoicesBasics();
						add(lessonPanel,BorderLayout.CENTER);
						revalidate();
						repaint();
					}
					else if (checkLessonChoice() == 2) {
						removeAll();
						setLayout(new BorderLayout());
						lessonChoicesEggs lessonPanel = new lessonChoicesEggs();
						add(lessonPanel,BorderLayout.CENTER);
						revalidate();
						repaint();
					}
					else if (checkLessonChoice() == 3) {
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
		goButton.setFont(new Font("Tahoma", Font.BOLD, 29));
		goButton.setBounds(545, 333, 190, 54);
		add(goButton);
		
		ImageIcon angelRamsay = new ImageIcon("resources/gr2.jpg");
		JLabel godRamsay = new JLabel();
		godRamsay.setIcon(angelRamsay);
		godRamsay.setHorizontalAlignment(SwingConstants.CENTER);
		godRamsay.setBounds(10, 333, 305, 377);
		add(godRamsay);

	}
}
