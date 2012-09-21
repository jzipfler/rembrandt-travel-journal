package de.htwds.rembrandt.controler.travelview;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import de.htwds.rembrandt.controler.datastructure.FolderPathController;
import de.htwds.rembrandt.model.TravelInformationModel;
import de.htwds.rembrandt.view.ViewMain;
import de.htwds.rembrandt.controler.activityController.ActivityListFile;


/**
 * 
 * @author Daniel
 * @version 1.2 (14.09.2012)
 */
public class SaveTravelInformationToDiskControler {
	
	private TravelInformationModel data;
	
	public SaveTravelInformationToDiskControler(ViewMain main){
		this.data = main.getJourneyModel().getTravelInformation();
		dataToString();
	}
	
	public String dataToString(){
		StringBuffer value = new StringBuffer();
		value.append(data.getCountry() + "\n");
		value.append(data.getCity() + "\n");
		value.append(data.getDateArrival() + "\n");
		value.append(data.getDateDeparture() + "\n");
		value.append(data.getArrivalStart() + "\n");
		value.append(data.getArrivalDestination() + "\n");
		value.append(data.getDepartureStart() + "\n");
		value.append(data.getDepartureDestionation() + "\n");
		value.append(data.getOption() + "\n");
		value.append(data.getComment() + "\n");
		return value.toString();
	}
	
	private void save(){
		String dateiname;
		String[] toWrite = dataToString().toString().split("\n");
        File file;
        dateiname = FolderPathController.getTravelInformationFolder(data.toString()) + FolderPathController.getFileSeperator() + "travelInformation.dat";
        file = new File(dateiname);
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
        	fw = new FileWriter(file, false);
            bw = new BufferedWriter(fw);
            for(int i=0; i < toWrite.length; i++){
            	if(toWrite[i].equals("null")){
            		bw.write("");
            	} else {
            		bw.write(toWrite[i]);
            	}
            	if(i < toWrite.length -1)
            		bw.newLine();
    		}  
            
            
           ActivityListFile alf = new ActivityListFile();
           alf.save(data.getActivityList(),FolderPathController.getActivitiesFolder(data.toString()),data.toString());
            
            
            
            
            
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
	}
	
	/**
	 * Method to store the information to the harddisk.
	 */
	public void store(){
		save();
	}
	
}
