package de.htwds.rembrandt.model;


import java.io.Serializable;

public class ActivityModel implements Serializable {

	public String titel;
	public String time;
	public String location;
	public String story;

	
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

	public String get_location(){
		return location;
	}
	
	public String get_story(){
		return story;
	}
	
	public String toString(){
		return "Titel: " +  titel + "\nZeitpunkt: " + time + "\nOrt: " + location + "\nStory: " +  story + "\n";
	}
	
}
