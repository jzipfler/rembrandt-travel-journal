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
	
	public void deleteActivity(String filename){
		for (int i = 0; i < counter; i++){
			if ( list[i].equals(filename)){
				list[i] = null;
				counter--;
			}
		}
		
		for (int i = 0; i < 1000; i++){
			if (list[i] == null & list[i+1] == null){
				i = 1000;
			} else if (list[i] == null){
				list[i] = list[i+1];
				list[i+1] = null;
			}
		}
		
	}
	
	public String getActivityName(int i){
		return list[i];
	}
	
	public String[] getList(){
		return list;
	}
	
	public void print(){
		for (int i = 0 ; i < getCounter(); i++){
			System.out.println(i + " : "+ getActivityName(i));
		}
	}
	
}
