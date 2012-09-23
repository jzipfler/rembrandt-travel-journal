package de.htwds.rembrandt.controler.travelview;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import de.htwds.rembrandt.view.ViewMain;
import de.htwds.rembrandt.view.ViewTravelinformation;

/**
 *
 * @version ( Daniel Horbach 2012-09-12 )
 *
 */
public class LoadTravelInformationPanelActionListener implements ActionListener{

	private ViewMain viewMain;
	private ViewTravelinformation viewInformation;
	
	public LoadTravelInformationPanelActionListener(ViewMain viewMain){
		this.viewMain = viewMain;
		this.viewInformation = new ViewTravelinformation(viewMain);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		new LoadInformationControler(viewInformation);
		
		viewMain.getCurrentContentPanel().removeAll();
		viewMain.getCurrentContentPanel().add(viewInformation);
		viewInformation.updateUI();
	}

}