
package de.htwds.rembrandt.controler.contactViewControler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import de.htwds.rembrandt.controler.activityController.ActivityListFile;
import de.htwds.rembrandt.controler.datastructure.FolderPathController;
import de.htwds.rembrandt.model.ActivityList;
import de.htwds.rembrandt.view.ViewActivity;
import de.htwds.rembrandt.view.ViewCalendar;
import de.htwds.rembrandt.view.ViewMain;


public class LoadActivityAbortActionListener implements ActionListener {


	private ViewActivity viewActivity;
	private ViewCalendar viewCalendar;
	
	public LoadActivityAbortActionListener(ViewActivity viewActivity) {
		this.viewActivity = viewActivity;
	}	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		ViewMain viewMain = viewActivity.getParentFrame();
		viewMain.getCurrentContentPanel().removeAll();
		viewCalendar = new ViewCalendar(viewMain);
		ActivityListFile alf = new ActivityListFile();
 		ActivityList af = alf.load(FolderPathController.getActivitiesFolder(viewMain.getJourneyModel().getGeneralInformationModel().getFolderName()),viewMain.getJourneyModel().getGeneralInformationModel().getFolderName());
		viewCalendar.setActivityList(af);
		viewMain.getCurrentContentPanel().add(viewCalendar);
		viewMain.getCurrentContentPanel().updateUI();
	}

}
