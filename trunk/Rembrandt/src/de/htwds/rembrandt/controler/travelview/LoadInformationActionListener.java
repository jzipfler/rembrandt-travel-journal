package de.htwds.rembrandt.controler.travelview;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import de.htwds.rembrandt.model.TravelInformationModel;
import de.htwds.rembrandt.view.ViewMain;
import de.htwds.rembrandt.view.ViewTravelinformation;

public class LoadInformationActionListener implements ActionListener{

	private ViewTravelinformation view;
	private TravelInformationModel data;
	private ViewMain mainView;
	
	public LoadInformationActionListener(ViewTravelinformation view){
		this.view = view;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		loadData();
		view.readData(data);
	}
	
	private void loadData(){
		mainView = view.getMainView();
		data = mainView.getJourneyModel().getTravelInformation();
	}

}
