package de.htwds.rembrandt.controler.activityController;

import java.io.*;
import de.htwds.rembrandt.model.ActivityModel;




public class ActivityFile {
	 

	
	public void save(ActivityModel activityModel, String directory){
		try {	
			FileOutputStream fos = new FileOutputStream(directory + "/" +  activityModel.get_titel() + "_" + activityModel.get_time());
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(activityModel);
			oos.close();
		} catch (Exception e){
			
		}
	}
	
	public ActivityModel load(ActivityModel activityModel){
		try {
			FileInputStream fis = new FileInputStream(activityModel.get_titel() + "/" + activityModel.get_time());
			ObjectInputStream ois = new ObjectInputStream(fis);
			ActivityModel result = (ActivityModel) ois.readObject();
			ois.close();
			return result;
		} catch (Exception e){
			
		}
		return null;
	}
	
}
