package de.htwds.rembrandt.controler.viewStartController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import de.htwds.rembrandt.controler.datastructure.GeneralInformationFromDiskControler;
import de.htwds.rembrandt.model.JourneyModel;
import de.htwds.rembrandt.view.ViewMain;
import de.htwds.rembrandt.view.ViewStart;
import de.htwds.rembrandt.view.ViewWrapperWindow;

public class LoadSelectedJouneyActionListener implements ActionListener {

	private ViewWrapperWindow viewWrapper;
	private ViewStart viewStart;
	
	public LoadSelectedJouneyActionListener( ViewStart viewStart ) {
		this.viewStart = viewStart;
		this.viewWrapper = viewStart.getViewWrapper();
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

		ViewMain viewMain = new ViewMain( viewWrapper, new JourneyModel() );
		
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
