package de.htwds.rembrandt.model;


import java.io.Serializable;

public class ActivityModel implements Serializable {

	private String titel;
	private String time;
	private String location;
	private String story;

	
	public ActivityModel(){}
	
	public void set_titel(String titel){
		this.titel = titel;
	}
	
	public void set_time(String time){
		this.time = time;
	}
	
	public void set_location(String location){
		this.location = location;
	}
	
	public void set_story(String story){
		this.story = story;
	}	
	
	public String get_titel(){
		return titel;
	}
	
	public String get_time(){
		return time;
	}
	
	public String toString(){
		return "Titel: " +  titel + "\nZeitpunkt: " + time + "\nOrt: " + location + "\nStory: " +  story + "\n";
	}
	
}
