package edu.asu.CSE360._05._01;

public class ControlCenter {
	
	private double[] correct;
	private double[] incorrect;
	private double[] time;
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
