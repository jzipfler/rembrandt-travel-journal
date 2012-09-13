package de.htwds.rembrandt.controler.travelview;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import de.htwds.rembrandt.controler.datastructure.FolderPathController;
import de.htwds.rembrandt.exception.TravelInformationException;
import de.htwds.rembrandt.model.TravelInformationModel;

/**
 * 
 * @author Daniel
 * @version 1.1 (12.09.2012)
 */
public class LoadTravelInformationFromDiskControler {

	private TravelInformationModel data;
	private String journeyName;
	
	public LoadTravelInformationFromDiskControler(String journeyName) throws TravelInformationException{
		this.journeyName = journeyName;
		readDataFromDisk();
	}
	
	private void readDataFromDisk() throws TravelInformationException{
		String[] result = new String[10];
		StringBuffer comment = new StringBuffer();
		int counter = 0;
		String fileName;
        File data;
        fileName = FolderPathController.getTravelInformationFolder(journeyName) + FolderPathController.getFileSeperator() + "travelInformation.dat";
        data = new File(fileName);
        if(!data.exists()) throw new TravelInformationException(TravelInformationException.ERROR_FILE_NOT_FOUND);
        FileReader fr = null;
        try {
            fr = new FileReader(data);
            BufferedReader in = new BufferedReader(fr);
    		String line = null;
    		while ((line = in.readLine()) != null) {
    			if (counter < 9){
    				line = line.replaceAll("\n", "");
    				result[counter] = line;
    			} else {
    				comment.append(line);
    				result[9] = comment.toString();
    			}
    			counter ++;
    		}   
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fr != null) {
                try {
                    fr.close();
                    fillData(result);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
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