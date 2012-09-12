package de.htwds.rembrandt.controler.travelview;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import de.htwds.rembrandt.controler.datastructure.FolderPathController;
import de.htwds.rembrandt.controler.datastructure.OperationSystemPropertiesControler;
import de.htwds.rembrandt.model.TravelInformationModel;
import de.htwds.rembrandt.view.ViewMain;

/**
 * 
 * @author Daniel
 * @version 1.2 (12.09.2012)
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
        File data;
        dateiname = FolderPathController.getTravelInformationFolder(toString()) + FolderPathController.getFileSeperator() + "travelInformation.dat";
        data = new File(dateiname);
        FileWriter fw = null;
        try {
            fw = new FileWriter(data, false);
            fw.write(dataToString());     
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fw != null) {
                try {
                    fw.close();
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
