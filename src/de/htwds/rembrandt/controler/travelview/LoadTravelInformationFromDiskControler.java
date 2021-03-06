package de.htwds.rembrandt.controler.travelview;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import de.htwds.rembrandt.controler.activityController.ActivityListFile;
import de.htwds.rembrandt.controler.datastructure.FolderPathController;
import de.htwds.rembrandt.exception.TravelInformationException;
import de.htwds.rembrandt.exception.TravelToDiscException;
import de.htwds.rembrandt.model.TravelInformationModel;

/**
 * 
 * @author Daniel
 * @version 1.1 (14.09.2012)
 */
public class LoadTravelInformationFromDiskControler {

	private TravelInformationModel data;
	private String journeyName;
	
	public LoadTravelInformationFromDiskControler(String journeyName) throws TravelInformationException{
		this.journeyName = journeyName;
		data = new TravelInformationModel();
		readDataFromDisk();
	}
	
	private void readDataFromDisk() throws TravelInformationException{
		String[] result = new String[10];
		StringBuffer comment = new StringBuffer();
		int counter = 0;
		String fileName;
        File data;
        fileName = FolderPathController.getTravelInformationFolder(journeyName) + FolderPathController.getFileSeperator() + Messages.getString("LoadTravelInformationFromDiskControler.0"); //$NON-NLS-1$
        data = new File(fileName);
        if(!data.exists()) throw new TravelInformationException(TravelInformationException.ERROR_FILE_NOT_FOUND);
        FileReader fr = null;
        try {
            fr = new FileReader(data);
            BufferedReader in = new BufferedReader(fr);
    		String line = null;
    		while ((line = in.readLine()) != null) {
    			if (counter < 9){
    				result[counter] = line;
    			} else {
    				if(line != null && line.length() > 0)
    					comment.append(line + Messages.getString("LoadTravelInformationFromDiskControler.1")); //$NON-NLS-1$
    			}
    			counter ++;
    		}   
    		result[9] = comment.toString();
        } catch (IOException e) {
        	throw new TravelToDiscException( e.getMessage() );
        } finally {
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                	throw new TravelToDiscException( e.getMessage() );
                }
            }
        }
        fillData(result);
	}
	
	private void fillData(String[] result){
		data.setCountry(result[0]);
		data.setCity(result[1]);
		data.setDateA(result[2]);
		data.setDateD(result[3]);
		data.setArrivalStart(result[4]);
		data.setArrivalDestination(result[5]);
		data.setDepartureStart(result[6]);
		data.setDepartureDestination(result[7]);
		data.setOption(Integer.parseInt(result[8].trim()));
		data.setComment(result[9]);
		loadActivityList();
	}
	
	
	
	private void loadActivityList(){
        ActivityListFile alf = new ActivityListFile();
        data.setActivityList(alf.load(FolderPathController.getActivitiesFolder(data.toString()),data.toString()));
	}
	
	/**
	 * Method which returns the read data from the Disk
	 * 
	 * @return data read from the Disk
	 */
	public TravelInformationModel getReadData(){
		return data;
	}
}