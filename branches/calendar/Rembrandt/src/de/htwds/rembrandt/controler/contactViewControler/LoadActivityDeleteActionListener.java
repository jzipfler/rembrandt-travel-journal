	package de.htwds.rembrandt.controler.contactViewControler;

	import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import de.htwds.rembrandt.controler.activityController.ActivityFile;
import de.htwds.rembrandt.controler.activityController.ActivityListFile;
import de.htwds.rembrandt.controler.datastructure.FolderPathController;
import de.htwds.rembrandt.model.ActivityList;
import de.htwds.rembrandt.model.ActivityModel;
import de.htwds.rembrandt.view.ViewActivity;
import de.htwds.rembrandt.view.ViewCalendar;
import de.htwds.rembrandt.view.ViewMain;

	
public class LoadActivityDeleteActionListener implements ActionListener{


	private ViewActivity viewActivity;
	private ViewCalendar viewCalendar;
	private ViewMain viewMain;
	
	public LoadActivityDeleteActionListener(ViewActivity viewActivity) {
		this.viewActivity = viewActivity;
	}	
	
	@Override
	public void actionPerformed(ActionEvent e) {

		
			ActivityFile af = new ActivityFile();
			String filename = viewActivity.get_Description() + "_" + viewActivity.get_Time();
			ActivityListFile alf = new ActivityListFile();
			ActivityList al = alf.load(FolderPathController.getActivitiesFolder(viewActivity.getParentFrame().getJourneyModel().getGeneralInformationModel().getFolderName()),viewActivity.getParentFrame().getJourneyModel().getGeneralInformationModel().getFolderName());
			al.deleteActivity(filename);
			al.print();
			
			alf.delete(FolderPathController.getActivitiesFolder(viewActivity.getParentFrame().getJourneyModel().getGeneralInformationModel().getFolderName()) , viewActivity.getParentFrame().getJourneyModel().getGeneralInformationModel().getFolderName());
			al.print();
		
			alf.save(al, FolderPathController.getActivitiesFolder(viewActivity.getParentFrame().getJourneyModel().getGeneralInformationModel().getFolderName()), viewActivity.getParentFrame().getJourneyModel().getGeneralInformationModel().getFolderName());
			af.delete(FolderPathController.getActivitiesFolder(viewActivity.getParentFrame().getJourneyModel().getGeneralInformationModel().getFolderName()) , filename);
			
		
		
		ViewMain viewMain = viewActivity.getParentFrame();
		viewMain.getCurrentContentPanel().removeAll();
		viewCalendar = new ViewCalendar(viewMain);	
		viewCalendar.setActivityList(al);
		viewMain.getCurrentContentPanel().add(viewCalendar);
		viewMain.getCurrentContentPanel().updateUI();
	}

}

