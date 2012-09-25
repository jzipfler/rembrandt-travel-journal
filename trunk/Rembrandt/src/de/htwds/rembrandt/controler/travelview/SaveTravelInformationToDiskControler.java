package de.htwds.rembrandt.controler.travelview;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import de.htwds.rembrandt.controler.activityController.ActivityListFile;
import de.htwds.rembrandt.controler.datastructure.FolderPathController;
import de.htwds.rembrandt.model.TravelInformationModel;
import de.htwds.rembrandt.view.ViewMain;


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
		value.append(data.getCountry() + Messages.getString("SaveTravelInformationToDiskControler.0")); //$NON-NLS-1$
		value.append(data.getCity() + Messages.getString("SaveTravelInformationToDiskControler.1")); //$NON-NLS-1$
		value.append(data.getDateArrival() + Messages.getString("SaveTravelInformationToDiskControler.2")); //$NON-NLS-1$
		value.append(data.getDateDeparture() + Messages.getString("SaveTravelInformationToDiskControler.3")); //$NON-NLS-1$
		value.append(data.getArrivalStart() + Messages.getString("SaveTravelInformationToDiskControler.4")); //$NON-NLS-1$
		value.append(data.getArrivalDestination() + Messages.getString("SaveTravelInformationToDiskControler.5")); //$NON-NLS-1$
		value.append(data.getDepartureStart() + Messages.getString("SaveTravelInformationToDiskControler.6")); //$NON-NLS-1$
		value.append(data.getDepartureDestionation() + Messages.getString("SaveTravelInformationToDiskControler.7")); //$NON-NLS-1$
		value.append(data.getOption() + Messages.getString("SaveTravelInformationToDiskControler.8")); //$NON-NLS-1$
		value.append(data.getComment() + Messages.getString("SaveTravelInformationToDiskControler.9")); //$NON-NLS-1$
		return value.toString();
	}
	
	private void save(){
		String dateiname;
		String[] toWrite = dataToString().toString().split(Messages.getString("SaveTravelInformationToDiskControler.10")); //$NON-NLS-1$
        File file;
        dateiname = FolderPathController.getTravelInformationFolder(data.toString()) + FolderPathController.getFileSeperator() + Messages.getString("SaveTravelInformationToDiskControler.11"); //$NON-NLS-1$
        file = new File(dateiname);
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
        	fw = new FileWriter(file, false);
            bw = new BufferedWriter(fw);
            for(int i=0; i < toWrite.length; i++){
            	if(toWrite[i].equals(Messages.getString("SaveTravelInformationToDiskControler.12"))){ //$NON-NLS-1$
            		bw.write(Messages.getString("SaveTravelInformationToDiskControler.13")); //$NON-NLS-1$
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
