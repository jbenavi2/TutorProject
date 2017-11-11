/*
* Singleton Type class
* 
* Only one object exists at a time
* 
* stores correct, incorrect, and time of each lesson
* 
* Completion time: 5 hours
*
* @author Javier Benavides
* @version 1.0
*/

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
	
	public void lessonOneInput(double correctInput, double incorrectInput, double timeInput) {
		
		correct[0] = correctInput;
		incorrect[0] = incorrectInput;
		time[0] = timeInput;
	}
	
	public double getLessonOneCorrect() {
		return correct[0];
	}
	
	public double getLessonOneIncorrect() {
		return incorrect[0];
	}
	
	public double getLessonOneTime() {
		return time[0];
	}
	
	public void lessonTwoInput(double correctInput, double incorrectInput, double timeInput) {
		
		correct[1] = correctInput;
		incorrect[1] = incorrectInput;
		time[1] = timeInput;
	}
	
	public double getLessonTwoCorrect() {
		return correct[1];
	}
	
	public double getLessonTwoIncorrect() {
		return incorrect[1];
	}
	
	public double getLessonTwoTime() {
		return time[1];
	}
	
	public void lessonThreeInput(double correctInput, double incorrectInput, double timeInput) {
		
		correct[2] = correctInput;
		incorrect[2] = incorrectInput;
		time[2] = timeInput;
	}
	
	public double getLessonThreeCorrect() {
		return correct[2];
	}
	
	public double getLessonThreeIncorrect() {
		return incorrect[2];
	}
	
	public double getLessonThreeTime() {
		return time[2];
	}
		

}
