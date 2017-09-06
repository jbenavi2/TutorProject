//Natalie DePaula
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
