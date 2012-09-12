package de.htwds.rembrandt.controler.viewStartController;

import java.io.IOException;

import de.htwds.rembrandt.controler.datastructure.GeneralInformationFromDiskControler;
import de.htwds.rembrandt.model.JourneyModel;
import de.htwds.rembrandt.view.ViewMain;
import de.htwds.rembrandt.view.ViewWrapperWindow;

/**
 * 
 * @author jan
 * @version ( Jan Zipfler 2012-09-12 )
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
			viewMain.getJourneyModel().setGeneralInformationModelArray( new GeneralInformationFromDiskControler().load() );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		viewWrapper.getPanel().removeAll();
		viewWrapper.getPanel().add( viewMain.getViewMain() );
		viewWrapper.getPanel().updateUI();
	}

}