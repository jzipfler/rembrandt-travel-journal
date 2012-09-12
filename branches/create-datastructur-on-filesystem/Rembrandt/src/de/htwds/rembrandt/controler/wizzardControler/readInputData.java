package de.htwds.rembrandt.controler.wizzardControler;

import de.htwds.rembrandt.controler.viewStartController.LoadMainViewController;
import de.htwds.rembrandt.model.JourneyModel;
import de.htwds.rembrandt.model.TravelInformationModel;
import de.htwds.rembrandt.view.ViewWizzard;

/**
 * 
 * @author Daniel Horbach
 * @version ( Jan Zipfler 2012-09-12 )
 */
public class readInputData {

	private TravelInformationModel data;
	private ViewWizzard reference;
	private JourneyModel journey;
	
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
		journey = new JourneyModel();
		journey.setTravelInformation(data);
	}
	
	public void readStoreAndExit(){
		read();
		store();
		openMainWindow();
	}
	
	private void openMainWindow(){
		//Hauptview oefnnen und Daten uebergeben!
		//Ordnerstruktur
		new LoadMainViewController( reference.getViewStart().getViewWrapper(), journey ).loadMainView();
	}
}