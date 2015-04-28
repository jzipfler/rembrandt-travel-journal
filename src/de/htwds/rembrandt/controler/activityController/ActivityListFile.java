package de.htwds.rembrandt.controler.activityController;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import de.htwds.rembrandt.controler.datastructure.FolderPathController;
import de.htwds.rembrandt.model.ActivityList;




public class ActivityListFile {
	 

	
	public void save(ActivityList activityList, String directory, String filename){
		try {		 	
			
			FileOutputStream fos = new FileOutputStream(directory +  FolderPathController.getFileSeperator() +  filename);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(activityList);
			oos.close();
		} catch (Exception e){
			
		}
	}

	
	public ActivityList load(String directory, String filename){	
		try {
			FileInputStream fis = new FileInputStream(directory +  FolderPathController.getFileSeperator() +  filename);
			ObjectInputStream ois = new ObjectInputStream(fis);
			ActivityList result = (ActivityList) ois.readObject();
			ois.close();	
			return result;
			
		} catch (Exception e){
			ActivityList result = new ActivityList();
			return result;
		}
		
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