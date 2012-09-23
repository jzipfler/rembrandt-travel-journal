package de.htwds.rembrandt.controler.travelview;


import de.htwds.rembrandt.model.GeneralInformationModel;
import de.htwds.rembrandt.model.TravelInformationModel;
import de.htwds.rembrandt.view.ViewMain;
import de.htwds.rembrandt.view.ViewTravelinformation;

/**
 * 
 * @author Daniel
 * @version 1.1 (14.09.2012)
 */
public class SaveTravelInformationControler {

	private ViewTravelinformation view;
	private TravelInformationModel data;
	private GeneralInformationModel generalInformation;
	private ViewMain mainView;
	
	public SaveTravelInformationControler(ViewTravelinformation view, ViewMain mainView){
		this.view = view;
		this.mainView = mainView;
		data = mainView.getJourneyModel().getTravelInformation();
	}
	

	public void save() {
		getInput();
		generalInformation = data.createGeneralInformation();
		mainView.getJourneyModel().setGeneralInformationModel(generalInformation); //Brauch man das?
		fillInfoAboutTravelPanel(generalInformation);
	}
	
	private void getInput(){
		if(data == null){
			mainView.getJourneyModel().setTravelInformation(new TravelInformationModel());
			data = mainView.getJourneyModel().getTravelInformation();
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
	
	private void fillInfoAboutTravelPanel( GeneralInformationModel newGeneralInformation ) {
		GeneralInformationModel[] array = mainView.getJourneyModel().getGeneralInformationArray();
		for (int i = 0; i < array.length; i++) {
			if ( array[i].equals(newGeneralInformation) )
				array[i] = newGeneralInformation;
		}
	}

}