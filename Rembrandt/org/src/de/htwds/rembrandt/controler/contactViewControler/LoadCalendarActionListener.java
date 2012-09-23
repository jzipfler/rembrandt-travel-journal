package de.htwds.rembrandt.controler.contactViewControler;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import de.htwds.rembrandt.controler.datastructure.FolderPathController;
import de.htwds.rembrandt.view.ViewContacts;
import de.htwds.rembrandt.view.ViewMain;
import de.htwds.rembrandt.view.ViewCalendar;
import de.htwds.rembrandt.model.ActivityList;
import de.htwds.rembrandt.controler.activityController.ActivityListFile;


public class LoadCalendarActionListener implements ActionListener {
	

	private ViewCalendar viewCalendar;
	private ViewMain viewMain;
	
	public LoadCalendarActionListener(ViewMain viewMain ) {	
		this.viewMain = viewMain;

	}	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		viewCalendar = new ViewCalendar(viewMain);
		
		viewMain.getCurrentContentPanel().removeAll();
		viewMain.getCurrentContentPanel().add(viewCalendar);
		ActivityListFile alf = new ActivityListFile();
 		ActivityList af = alf.load(FolderPathController.getActivitiesFolder(viewMain.getJourneyModel().getGeneralInformationModel().getFolderName()),viewMain.getJourneyModel().getGeneralInformationModel().getFolderName());
	
		viewCalendar.setActivityList(af);
		viewMain.getCurrentContentPanel().updateUI();
	}
	
	
	
	
}
