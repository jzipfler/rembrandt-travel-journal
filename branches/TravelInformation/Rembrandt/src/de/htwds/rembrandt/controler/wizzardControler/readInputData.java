package de.htwds.rembrandt.controler.wizzardControler;

import java.io.IOException;

import de.htwds.rembrandt.controler.datastructure.CheckExistingDataStructureControler;
import de.htwds.rembrandt.controler.datastructure.GeneralInformationFromDiskControler;
import de.htwds.rembrandt.controler.viewStartController.LoadMainViewController;
import de.htwds.rembrandt.model.GeneralInformationModel;
import de.htwds.rembrandt.model.JourneyModel;
import de.htwds.rembrandt.model.TravelInformationModel;
import de.htwds.rembrandt.view.ViewWizzard;

/**
 * 
 * @author Daniel Horbach
 * @version ( Jan Zipfler 2012-09-13 )
 */
public class readInputData {

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
	
	private void store(){
		journey = new JourneyModel();
		journey.setTravelInformation(data);
		journey.setGeneralInformationModel(generalData); //Wizzard schreibt die generalData zuerst in das Modell
	}
	
	public void readStoreAndExit(){
		read();
		store();
		openMainWindow();
	}
	
	private void openMainWindow(){
		//Hauptview oefnnen und Daten uebergeben!
		new CheckExistingDataStructureControler().checkExistingDataStructure( data.toString() );
		try {
			 GeneralInformationModel[] array = new GeneralInformationFromDiskControler().load( generalData );
			 System.out.println("readInoutData, Array is Null?: " + ( array == null ));
			 System.out.println("readInoutData, Array Länge: " + array.length);
//			 for (GeneralInformationModel generalInformationModel : array) {
//				System.out.println(generalInformationModel);
//			}
			 journey.setGeneralInformationModelArray(array);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new LoadMainViewController( reference.getViewStart().getViewWrapper(), journey ).loadMainView();
	}
}