package de.htwds.rembrandt.controler.wizzardControler;

import de.htwds.rembrandt.model.TravelInformationModel;
import de.htwds.rembrandt.view.ViewWizzard;

public class readInputData {

	private TravelInformationModel data;
	private ViewWizzard reference;
	
	public readInputData(ViewWizzard reference){
		this.reference = reference;
	}
	
	private void read(){
		data = new TravelInformationModel(reference.getCountry(),
										  reference.getCity(),
										  reference.getDate(),
										  reference.getEndDate(),
										  reference.getOption(),
										  reference.getArrivalStart(),
										  reference.getArrivalDestination(),
										  reference.getDepartureStart(),
										  reference.getDepartureDestination());
	}
	
	private void store(){
		
	}
	
	public void readAndStore(){
		read();
		store();
	}
	
}
