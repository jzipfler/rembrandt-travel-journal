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

import de.htwds.rembrandt.exception.TravelToDiscException;
import de.htwds.rembrandt.model.GeneralInformationModel;
/**
 * 
 * @author Daniel
 * @version 1.2 ( 14.09.2012 - Jan Zipfler )
 */
public class GeneralInformationFromDiskControler {
	
	private ArrayList<GeneralInformationModel> informationArray;
	
	public GeneralInformationFromDiskControler() {
		informationArray = null;
	}
	
	public GeneralInformationModel[] load() throws TravelToDiscException{
		return load(null);
	}
	
	public GeneralInformationModel[] load(GeneralInformationModel newModel) throws TravelToDiscException{
		
		String filename;
        File data;
        filename = FolderPathController.getGeneralInformationFolder() + FolderPathController.getFileSeperator() + "generalInformation.dat";
        data = new File(filename);
        if( data.exists() ){
        	
        	ObjectInputStream in = null;
        	try {
        		
        		in = new ObjectInputStream( new BufferedInputStream( new FileInputStream(data)));
	        
	        	informationArray = (ArrayList<GeneralInformationModel>)in.readObject();
	        } catch (Exception e) {
	            throw new TravelToDiscException( e.getMessage() );
	        } finally {
	            if (in != null) {
	                try {
	                    in.close();
	                } catch (IOException e) {
	                	throw new TravelToDiscException( e.getMessage() );
	                }
	            }
	        }
        }
        else
        	informationArray = new ArrayList<GeneralInformationModel>();
        if(newModel != null)
        	informationArray.add(newModel);
        if ( informationArray == null )
        	return ( new GeneralInformationModel[0] );
//        System.out.println("GeneralInformationFromDisc, newModel: " + newModel );
//        System.out.println( "GeneralInformationFromDisc, Länge ArrayList: " + informationArray.size());
        
		return informationArray.toArray( new GeneralInformationModel[informationArray.size()] );
	}
	
	public void save(GeneralInformationModel[] data) throws TravelToDiscException{
		ObjectOutputStream out = null;
		File file;
		file = new File(FolderPathController.getGeneralInformationFolder() + FolderPathController.getFileSeperator() + "generalInformation.dat");
		if(file.exists()){
			file.delete();
		}
		try{
			
			out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
		
			informationArray = new ArrayList<GeneralInformationModel>();
			for (GeneralInformationModel generalInformationModel : data) {
				informationArray.add(generalInformationModel);
			}
			out.writeObject(informationArray);
		} catch(Exception e){

			throw new TravelToDiscException( e.getMessage() );
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {

					throw new TravelToDiscException(e.getMessage());
				}
			}
		}
	}
	
	public void remove(GeneralInformationModel newModel){
		informationArray.remove(newModel);
	}
}
