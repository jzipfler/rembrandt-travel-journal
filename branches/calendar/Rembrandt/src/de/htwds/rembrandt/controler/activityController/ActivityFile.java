package de.htwds.rembrandt.controler.activityController;

import java.io.*;
import de.htwds.rembrandt.model.ActivityModel;
import de.htwds.rembrandt.controler.datastructure.FolderPathController;




public class ActivityFile {
	 

	
	public void save(ActivityModel activityModel, String directory){
		try {	
			FileOutputStream fos = new FileOutputStream(directory +  FolderPathController.getFileSeperator() +  activityModel.get_titel() + "_" + activityModel.get_time());
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(activityModel);
			oos.close();
		} catch (Exception e){
			
		}
	}
	
	public ActivityModel load(String directory, String filename){
		try {
			String addy = directory + FolderPathController.getFileSeperator() + filename;
			FileInputStream fis = new FileInputStream(addy);
			ObjectInputStream ois = new ObjectInputStream(fis);
			ActivityModel result = (ActivityModel) ois.readObject();
			ois.close();
			return result;
		} catch (Exception e){
			
		}
		return null;
	}
	
	public void delete(String directory, String filename){
		try {
			String addy = directory + FolderPathController.getFileSeperator() + filename;
			File f=new File(addy);
			if(f.exists() && f.isFile()){
				f.delete();
			}

		} catch (Exception e){
			
		}	
	}

	
}
