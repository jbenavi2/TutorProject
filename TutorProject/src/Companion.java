/**
* The panel will display one of four options for different types of faces: 
* happy, thinking, worried, and sorry.
* Assignment number: Recitation Project 1
* Completion time: (estimation of hours spent on this program)
*
* @author Natalie DePaula, (the names of anyone whose code you use)
* @version (version)
*/

public class Companion extends JPanel {
	
	private JRadioButton A, B, C, D;
	private ButtonGroup group;
	
	public Companion() {
	
		group = new ButtonGroup();
		group.add(A);
		group.add(B);
		group.add(C);
		group.add(D);
		A = new JRadioButton ("A");
		B = new JRadioButton ("B");
		C = new JRadioButton ("C");
		D = new JRadioButton ("D");
		
	}
	
	
}
