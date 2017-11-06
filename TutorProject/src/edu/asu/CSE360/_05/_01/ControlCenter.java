package edu.asu.CSE360._05._01;

public class ControlCenter {
	
	private double[] array1;
	private double[] array2;
	private double[] array3;
	private static ControlCenter _instance;
	
	private ControlCenter() {
		
	}
	
	public static ControlCenter getInstance() {
		if(_instance == null) {
			_instance = new ControlCenter();
		}
		return _instance;
	}
	
	

}
