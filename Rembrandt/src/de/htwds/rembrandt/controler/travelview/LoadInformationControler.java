package de.htwds.rembrandt.controler.travelview;

import de.htwds.rembrandt.model.TravelInformationModel;
import de.htwds.rembrandt.view.ViewMain;
import de.htwds.rembrandt.view.ViewTravelinformation;

/**
 * 
 * @author Daniel
 * @version 1.2 (12.09.2012)
 */
public class LoadInformationControler{

	private ViewTravelinformation view;
	private TravelInformationModel data;
	private ViewMain mainView;
	
	public LoadInformationControler(ViewTravelinformation view){
		this.view = view;
		loadData();
		view.readData(data);
	}
	
	private void loadData(){
		mainView = view.getMainView();
		data = mainView.getJourneyModel().getTravelInformation();
	}

}
