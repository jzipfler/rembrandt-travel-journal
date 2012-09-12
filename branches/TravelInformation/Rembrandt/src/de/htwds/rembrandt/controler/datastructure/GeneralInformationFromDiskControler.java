package de.htwds.rembrandt.controler.datastructure;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;

import de.htwds.rembrandt.model.GeneralInformationModel;
/**
 * 
 * @author Daniel
 * @version 1.0 (12.09.2012)
 */
public class GeneralInformationFromDiskControler {
	
	private ArrayList<GeneralInformationModel> informationArray;
	
	public GeneralInformationFromDiskControler() {
		informationArray = null;
	}
	
	public GeneralInformationModel[] load() throws IOException{
		return load(null);
	}
	
	public GeneralInformationModel[] load(GeneralInformationModel newModel) throws IOException{
		
		String filename;
        File data;
        filename = FolderPathController.getGeneralInformationFolder() + FolderPathController.getFileSeperator() + "generalInformation.dat";
        data = new File(filename);
        if( data.exists() ){
        	
        	ObjectInputStream in = null;
	        in = new ObjectInputStream( new BufferedInputStream( new FileInputStream(data)));
	        try {
	        	informationArray = (ArrayList<GeneralInformationModel>)in.readObject();
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            if (in != null) {
	                try {
	                    in.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
        }
        else
        	informationArray = new ArrayList<GeneralInformationModel>();
        if(newModel != null)
        	informationArray.add(newModel);
        
		return informationArray.toArray( new GeneralInformationModel[informationArray.size()] );
	}
	
	public void save(GeneralInformationModel[] data) throws IOException{
		ObjectOutputStream out;
		File file;
		file = new File(FolderPathController.getGeneralInformationFolder() + FolderPathController.getFileSeperator() + "generalInformation.dat");
		if(file.exists()){
			file.delete();
		}
		out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
		try{
			informationArray = new ArrayList<GeneralInformationModel>();
			for (GeneralInformationModel generalInformationModel : data) {
				informationArray.add(generalInformationModel);
			}
			out.writeObject(informationArray);
		} catch(Exception e){
			//To Do!!
			e.printStackTrace();
		} finally {
			out.close();
		}
	}
	
	public void remove(GeneralInformationModel newModel){
		informationArray.remove(newModel); //testen
	}
}
