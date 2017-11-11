package edu.asu.CSE360._05._01;

public class ControlCenter {
	
	private static double[] correct = new double[3];
	private static double[] incorrect = new double[3];
	private static double[] time = new double[3];
	private static ControlCenter _instance;
	
	private ControlCenter() {		
		
		
	}
	
	public static ControlCenter getInstance() {
		if(_instance == null) {
			_instance = new ControlCenter();
		}
		return _instance;
	}
	
	public void lessonOneInput(double correctInput, double incorrectInput) {
		
		correct[0] = correctInput;
		incorrect[0] = incorrectInput;
	}
	
	public double getLessonOneCorrect() {
		return correct[0];
	}
	
	public double getLessonOneIncorrect() {
		return incorrect[0];
	}
	
	public void lessonTwoInput(double correctInput, double incorrectInput) {
		
		correct[1] = correctInput;
		incorrect[2] = incorrectInput;
	}
	
	
	
	
	
	
	
	
	

}
