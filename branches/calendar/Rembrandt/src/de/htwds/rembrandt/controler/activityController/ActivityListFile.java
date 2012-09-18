package de.htwds.rembrandt.controler.activityController;

import java.io.*;
import de.htwds.rembrandt.model.ActivityList;




public class ActivityListFile {
	 

	
	public void save(ActivityList activityList, String directory, String filename){
		try {	
			FileOutputStream fos = new FileOutputStream(directory + "/" +  filename);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(activityList);
			oos.close();
		} catch (Exception e){
			
		}
	}
	
	public ActivityList load(String directory, String filename){
		try {
			FileInputStream fis = new FileInputStream(directory + "/" +  filename);
			ObjectInputStream ois = new ObjectInputStream(fis);
			ActivityList result = (ActivityList) ois.readObject();
			ois.close();
			return result;
		} catch (Exception e){
			
		}
		return null;
	}
	
}