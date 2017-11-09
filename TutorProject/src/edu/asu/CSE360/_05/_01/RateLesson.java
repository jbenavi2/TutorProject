package edu.asu.CSE360._05._01;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTable;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.table.DefaultTableModel;
import java.awt.ScrollPane;
import javax.swing.JComboBox;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;

public class RateLesson extends JPanel {
	private JTextField commentField;

	/**
	 * Create the panel.
	 */
	public RateLesson() {
		setLayout(null);
		
		JTextArea txtrBasicsOfCooking = new JTextArea();
		txtrBasicsOfCooking.setText("Basics of Cooking - 3 stars - It was aight...\r\nBasics of Cooking - 5 stars - Me cook good now!\r\n");
		txtrBasicsOfCooking.setEditable(false);
		txtrBasicsOfCooking.setBounds(62, 45, 1163, 453);
		add(txtrBasicsOfCooking);
		
		JComboBox lessonChoice = new JComboBox();
		lessonChoice.setModel(new DefaultComboBoxModel(new String[] {"Select Lesson...", "Basics of Cooking"}));
		lessonChoice.setBounds(89, 521, 209, 45);
		add(lessonChoice);
		
		JSlider slider = new JSlider();
		slider.setValue(0);
		slider.setMajorTickSpacing(1);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setMaximum(5);
		slider.setBounds(383, 521, 234, 45);
		
		add(slider);
		
		commentField = new JTextField();
		commentField.setText("Comments...");
		commentField.setHorizontalAlignment(SwingConstants.CENTER);
		commentField.setBounds(702, 521, 496, 45);
		add(commentField);
		commentField.setColumns(10);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeAll();
				setLayout(new BorderLayout());
				TutorOptions tutorChoice = new TutorOptions();
				add(tutorChoice, BorderLayout.CENTER);
				revalidate();
				repaint();
			}
		});
		btnBack.setBounds(10, 11, 89, 23);
		add(btnBack);
		
		JButton addButton = new JButton("ADD REVIEW");
		addButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		addButton.setBounds(554, 611, 179, 45);
		add(addButton);
		
		JLabel lblBad = new JLabel("BAD");
		lblBad.setHorizontalAlignment(SwingConstants.CENTER);
		lblBad.setBounds(367, 577, 46, 14);
		add(lblBad);
		
		JLabel lblGood = new JLabel("GOOD");
		lblGood.setHorizontalAlignment(SwingConstants.CENTER);
		lblGood.setBounds(586, 577, 46, 14);
		add(lblGood);

	}
}
