package de.htwds.rembrandt.controler.travelview;


import de.htwds.rembrandt.model.TravelInformationModel;
import de.htwds.rembrandt.view.ViewMain;
import de.htwds.rembrandt.view.ViewTravelinformation;

/**
 * 
 * @author Daniel
 * @version 1.1 (12.09.2012)
 */
public class SaveTravelInformationControler {

	private ViewTravelinformation view;
	private TravelInformationModel data;
	private ViewMain mainView;
	
	public SaveTravelInformationControler(ViewTravelinformation view){
		this.view = view;
		data = view.getMainView().getJourneyModel().getTravelInformation();
	}
	

	public void save() {
		getInput();
	}
	
	private void getInput(){
		if(data == null){
			mainView.getJourneyModel().setTravelInformation(new TravelInformationModel());
		}
		data.setCity(view.getCityText());
		data.setCountry(view.getCountryText());
		data.setArrivalDestination(view.getArrivalDestinationText());
		data.setArrivalStart(view.getArrivalStartText());
		data.setComment(view.getCommentText());
		data.setOption(view.getOptionsInput());
		data.setDateA(view.getArrivalText());
		data.setDateD(view.getDaprtureText());
		data.setDepartureStart(view.getDepartureStartText());
		data.setDepartureDestination(view.getDepartureDestinationText());	
	}

}