import javax.swing.*;
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
		JPanel panel1 = new JPanel();
		//JPanel panel2 = new JPanel();  //commented out by Javier for testing
		Assessor panel2 = new Assessor();//added by Javier
		JPanel panel3 = new JPanel();
		JPanel panel4 = new JPanel();
		panel2.changeState(4);//added by Javier for testing
		
		//add name labels for first 
		panel1.add(label1);
		//panel2.add(label2); //commented out by Javier for testing
		panel3.add(label3);
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
		
		frame.setSize(400,400);
		frame.setVisible(true);
	  }
	
}
