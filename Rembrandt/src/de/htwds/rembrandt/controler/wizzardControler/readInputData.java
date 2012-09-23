package de.htwds.rembrandt.controler.wizzardControler;

import java.io.IOException;

import javax.swing.JOptionPane;

import de.htwds.rembrandt.controler.datastructure.CheckExistingDataStructureControler;
import de.htwds.rembrandt.controler.datastructure.GeneralInformationFromDiskControler;
import de.htwds.rembrandt.controler.viewStartController.LoadMainViewController;
import de.htwds.rembrandt.exception.TravelToDiscException;
import de.htwds.rembrandt.model.GeneralInformationModel;
import de.htwds.rembrandt.model.JourneyModel;
import de.htwds.rembrandt.model.TravelInformationModel;
import de.htwds.rembrandt.view.ViewWizzard;

/**
 * 
 * @author Daniel Horbach
 * @version ( Jan Zipfler 2012-09-16 )
 */
public class readInputData {

	private final String ERROR_JOURNEY_ALREADY_EXISTS 	= "Dies gewünschte Reise existiert bereits.";
	private final String MSG_JOUNEY_ALREADY_EXISTS 	= "Fehler beim erstellen der Reise";
	
	private TravelInformationModel data;
	private GeneralInformationModel generalData;
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
		generalData =  data.createGeneralInformation();
	}
	
	/**
	 * Use this to check if a journey with this name already exists.
	 * Throw a RuntimeException if it already exists. The exception will be caught
	 * and diplays a popup error message in front of the wizzar...wizzard won't close.
	 */
	private void checkAlreadyExistingJourney() {
		
		GeneralInformationModel[] tmp = new GeneralInformationFromDiskControler().load();
		for (GeneralInformationModel generalInformationModel : tmp) {
			if ( generalInformationModel.equals(generalData) )
				throw new RuntimeException( ERROR_JOURNEY_ALREADY_EXISTS );
		}
	}
	
	private void store(){
		journey = new JourneyModel();
		journey.setTravelInformation(data);
		journey.setGeneralInformationModel(generalData); //Wizzard schreibt die generalData zuerst in das Modell
	}
	
	public void readStoreAndExit(){
		try {
		
			read();
			checkAlreadyExistingJourney();
			store();
			openMainWindow();
		} catch ( RuntimeException runtimeException ) {
			
			JOptionPane.showMessageDialog( reference, 
					runtimeException.getMessage() , 
					MSG_JOUNEY_ALREADY_EXISTS, 
					JOptionPane.ERROR_MESSAGE );
		}
		
	}
	
	private void openMainWindow(){

		new CheckExistingDataStructureControler().checkExistingDataStructure( data.toString() );
		try {
			 GeneralInformationModel[] array = new GeneralInformationFromDiskControler().load( generalData );
//			 System.out.println("readInoutData, Array is Null?: " + ( array == null ));
//			 System.out.println("readInoutData, Array Länge: " + array.length);
			 journey.setGeneralInformationModelArray(array);
		} catch ( TravelToDiscException discException ) {

			JOptionPane.showMessageDialog( reference, 
					discException.getMessage() 
					+ TravelToDiscException.NEW_LINE_HELPER_STRING 
					+ TravelToDiscException.ERROR_LOAD_GENERAL_INFORMATION, 
					TravelToDiscException.MSG_ERROR_DURING_SAVE_OR_LOAD, 
					JOptionPane.ERROR_MESSAGE );
		}
		reference.setVisible(false);
		reference.dispose();
		new LoadMainViewController( reference.getViewStart().getViewWrapper(), journey ).loadMainView();
	}
}