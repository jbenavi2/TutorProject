import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;


public class Universe extends JFrame
{
	
	public static void main(String[] args) 
	{
		//Labels Containing Names of Team Members
		JLabel label1 = new JLabel("Natalie DePaula", SwingConstants.CENTER);
		JLabel label2 = new JLabel("Javier Benavides", SwingConstants.CENTER);
		JLabel label3 = new JLabel("Andrew Ton", SwingConstants.CENTER);
		JLabel label4 = new JLabel("Andrew Bui", SwingConstants.CENTER);
		//Format Content
		//dark grey background, blue text, centered text
		label1.setBorder(new LineBorder(Color.BLACK));
		label1.setForeground(Color.BLUE);
		label1.setBackground(Color.lightGray);
		label1.setOpaque(true);
		label2.setBorder(new LineBorder(Color.BLACK));
		label2.setForeground(Color.BLUE);
		label2.setBackground(Color.lightGray);
		label2.setOpaque(true);
		label3.setBorder(new LineBorder(Color.BLACK));
		label3.setForeground(Color.BLUE);
		label3.setBackground(Color.lightGray);
		label3.setOpaque(true);
		label4.setBorder(new LineBorder(Color.BLACK));
		label4.setForeground(Color.BLUE);
		label4.setBackground(Color.lightGray);
		label4.setOpaque(true);
		
		//create Slider
		int minSlider = 0;
		int maxSlider = 4;
		JSlider slider = new JSlider(JSlider.HORIZONTAL, minSlider, maxSlider, minSlider);
		//tick marks with number labels
		slider.setMajorTickSpacing(1);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		
		
		//!!temp. switch out for other class files.!!
		//JPanel panel1 = new JPanel();
		Companion panel1 = new Companion();
		Assessor panel2 = new Assessor();//added by Javier
		Tutor panel3 = new Tutor();
		JPanel panel4 = new JPanel();
		
		//add name labels for first 
		//panel1.add(label1);
		//panel3.add(label3);
		panel4.add(label4);

		
		//Bevel for Panels
		Border raisedBevel = BorderFactory.createLoweredBevelBorder();
		panel1.setBorder(raisedBevel);
		panel2.setBorder(raisedBevel);
		panel3.setBorder(raisedBevel);
		panel4.setBorder(raisedBevel);

		//Grid Layout to hold Jpanels
		JPanel panelGrid = new JPanel();
		panelGrid.setLayout(new GridLayout(2,2));
		panelGrid.add(panel1);
		panelGrid.add(panel2);
		panelGrid.add(panel3);
		panelGrid.add(panel4);		
		
		JFrame frame = new JFrame("Application2");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container content = frame.getContentPane();
		content.setLayout(new BorderLayout());
		content.add(panelGrid, BorderLayout.CENTER);
		content.add(slider, BorderLayout.SOUTH);
		
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged (ChangeEvent e) {
				JSlider slider = (JSlider) e.getSource();
				if (!slider.getValueIsAdjusting() ) {
					//debug
					int value = slider.getValue();
//					System.out.println(value);  //commented out by Javier
					
					//remove old content
					content.removeAll();
					panelGrid.removeAll();
					
					//update frame with new panels
					//re-add slider
					content.add(slider, BorderLayout.SOUTH);
					
					//create new panels - waiting for other class files
					Companion panel1 = new Companion();
					Assessor panel2 = new Assessor();
					Tutor panel3 = new Tutor();
					
					//set state - waiting for other class files
					panel1.changeState(value);
					panel2.changeState(value);
					panel3.changeState(value);
					
					
					//rea-dd to panelGrid
					panelGrid.add(panel1);
					panelGrid.add(panel2);
					panelGrid.add(panel3);
					panelGrid.add(panel4);
					
					//bevels
					panel2.setBorder(raisedBevel);
					
					//add grid to content
					content.add(panelGrid, BorderLayout.CENTER);
					
					//re-validate and repaint
					content.revalidate();
					content.repaint();
				}
			}
		});
				
		frame.setSize(1280,720);
		frame.setVisible(true);
	  }
	
}
