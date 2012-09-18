package de.htwds.rembrandt.model;

import java.io.Serializable;
import de.htwds.rembrandt.model.ActivityModel;

public class ActivityList implements Serializable {
	
	private int counter;
	private String[] list;
	
	public ActivityList(){
		counter = 0;
		list = new String[1000];
	}
	
	
	public int getCounter(){
		return counter;
	}
	
	public void addActivity(ActivityModel activityModel){
		list[counter++] = activityModel.get_titel() + "_" + activityModel.get_time();
	}
	
	public String getActivityName(int i){
		return list[i];
	}
}
