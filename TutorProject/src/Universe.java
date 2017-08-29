//Andrew Bui

import javax.swing.*;

public class Universe extends JApplet{

	public void init() {
		Assessor assessor = new Assessor(3);
		getContentPane().add(assessor);
		
		
		setSize (400,400);
		
	}

}
