package edu.asu.CSE360._05._01;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class RateLesson extends JPanel {
	private JTextField commentField;

	/**
	 * Create the panel.
	 */
	public RateLesson() {
		setLayout(null);
		
		String fileName = "resources/review.txt";
		JTextArea reviewText = new JTextArea();
		reviewText.setText("Basics of Cooking - 3 stars - It was aight...\r\nBasics of Cooking - 5 stars - Me cook good now!\r\n");
		reviewText.setEditable(false);
		reviewText.setLineWrap(true);
		reviewText.setWrapStyleWord(true);
		reviewText.setBounds(62, 45, 1163, 453);
		try {
			String line = null;
			FileReader fileReader = new FileReader(fileName);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			while ((line = bufferedReader.readLine()) != null) {
				reviewText.append(line + "\n");
			}
		}
		catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                  
        }
		
		JScrollPane scroll = new JScrollPane(reviewText, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setBounds(62, 45, 1163, 453);
		add(scroll);
		
		JComboBox lessonChoice = new JComboBox();
		lessonChoice.setModel(new DefaultComboBoxModel(new String[] {"Select Lesson...", "Basics of Cooking", "Eggs and Baking"}));
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
		commentField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				commentField.setText("");
			}
		});
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
				if (addButton.isEnabled()) {
					String lessonRev = String.valueOf(lessonChoice.getSelectedItem());
					String stars = String.valueOf(slider.getValue());
					String comment = commentField.getText();
					String review = lessonRev + " - " + stars + " stars" + " - " + comment + "\n";
					
					if (lessonRev.equals("Select Lesson...") || comment.equals("Must Select Lesson to Review and Write Comment") || comment.equals("Comments...")) {
						commentField.setText("Must Select Lesson to Review and Write Comment");
					}
					else {
						reviewText.append(review);
						try {
							BufferedWriter outStream = new BufferedWriter( new FileWriter("resources/review.txt",true));
							PrintWriter printWriter = new PrintWriter(outStream);
							printWriter.print(review);
							printWriter.close();
						}
						catch (IOException e1) {
							e1.printStackTrace();
						}
					}
				}
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
