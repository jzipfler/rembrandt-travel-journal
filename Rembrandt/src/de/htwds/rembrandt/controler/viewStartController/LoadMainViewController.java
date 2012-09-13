package de.htwds.rembrandt.controler.viewStartController;

import java.io.IOException;

import de.htwds.rembrandt.controler.datastructure.ContactToDiscControler;
import de.htwds.rembrandt.controler.datastructure.GeneralInformationFromDiskControler;
import de.htwds.rembrandt.model.JourneyModel;
import de.htwds.rembrandt.view.ViewMain;
import de.htwds.rembrandt.view.ViewWrapperWindow;

/**
 * This class get executed from the wizzardController.readInputData class
 * 
 * @author jan
 * @version ( Jan Zipfler 2012-09-13 )
 */
public class LoadMainViewController {

	private ViewWrapperWindow viewWrapper;
	private JourneyModel journeyModel;
	
	public LoadMainViewController( ViewWrapperWindow viewWrapper, JourneyModel journeyModel ) {
		this.viewWrapper = viewWrapper;
		this.journeyModel = journeyModel;
	}
	
	public void loadMainView() {
		
		ViewMain viewMain = new ViewMain( viewWrapper, journeyModel );
		
		try {
			if ( viewMain.getJourneyModel().getGeneralInformationArray() == null )
				viewMain.getJourneyModel().setGeneralInformationModelArray( new GeneralInformationFromDiskControler().load() );
			new ContactToDiscControler( viewMain.getJourneyModel() ).loadGlobalContactFromDisc();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		viewWrapper.getPanel().removeAll();
		viewWrapper.getPanel().add( viewMain.getViewMain() );
		viewWrapper.getPanel().updateUI();
	}

}