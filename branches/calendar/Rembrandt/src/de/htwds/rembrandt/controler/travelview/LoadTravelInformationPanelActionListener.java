package de.htwds.rembrandt.controler.travelview;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import de.htwds.rembrandt.view.ViewMain;
import de.htwds.rembrandt.view.ViewTravelinformation;

public class LoadTravelInformationPanelActionListener implements ActionListener{

	private ViewMain viewMain;
	private ViewTravelinformation viewInformation;
	
	public LoadTravelInformationPanelActionListener(ViewMain viewMain){
		this.viewMain = viewMain;
		this.viewInformation = new ViewTravelinformation();
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		viewMain.getCurrentContentPanel().removeAll();
		viewMain.getCurrentContentPanel().add(viewInformation);
		viewInformation.updateUI();
	}

}
