
package de.htwds.rembrandt.controler.contactViewControler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import de.htwds.rembrandt.view.ViewActivity;
import de.htwds.rembrandt.view.ViewCalendar;
import de.htwds.rembrandt.view.ViewMain;
import de.htwds.rembrandt.model.ActivityList;
import de.htwds.rembrandt.model.ActivityModel;
import de.htwds.rembrandt.model.JourneyModel;
import de.htwds.rembrandt.controler.activityController.ActivityListFile;
import de.htwds.rembrandt.controler.activityController.ActivityFile;
import de.htwds.rembrandt.controler.datastructure.FolderPathController;




public class LoadActivitySaveActionListener implements ActionListener {

	private ActivityModel activityModel;
	private ViewActivity viewActivity;
	private ActivityFile activityFile;
	private ActivityList activityList;
	private ViewCalendar viewCalendar;
	private ActivityListFile activityListFile;
	private	JourneyModel journeyModel;

	
	public LoadActivitySaveActionListener(ViewActivity viewActivity,  JourneyModel journeyModel) {
		this.viewActivity = viewActivity;
		this.journeyModel = journeyModel;
		activityModel = new ActivityModel();		
		activityFile = new ActivityFile();
	}	
	
	@Override
	public void actionPerformed(ActionEvent e) {
	
		
		if (activityModel.checkString(viewActivity.get_Description())){
			activityModel.set_titel(viewActivity.get_Description());
			activityModel.set_time(viewActivity.get_Time());
			activityModel.set_location(viewActivity.get_Location());
			activityModel.set_story(viewActivity.get_Story());	
			journeyModel.getTravelInformation().getActivityList().addActivity(activityModel);
			activityFile.delete(FolderPathController.getActivitiesFolder(journeyModel.getGeneralInformationModel().getFolderName()), activityModel.get_titel() + "_" + activityModel.get_time());
			activityFile.save(activityModel, FolderPathController.getActivitiesFolder(journeyModel.getGeneralInformationModel().getFolderName()));
			activityListFile = new ActivityListFile();
			activityList = activityListFile.load(FolderPathController.getActivitiesFolder(journeyModel.getGeneralInformationModel().getFolderName()),journeyModel.getGeneralInformationModel().getFolderName());
			activityList.deleteActivity(activityModel.get_titel() + "_" + activityModel.get_time());
			if ( activityList == null ){
				activityList = new ActivityList();
				activityList.addActivity(activityModel);
			} else {
				activityList.addActivity(activityModel);
			}
			activityListFile.save(activityList, FolderPathController.getActivitiesFolder(journeyModel.getGeneralInformationModel().getFolderName()), journeyModel.getGeneralInformationModel().getFolderName());
			ViewMain viewMain = viewActivity.getParentFrame();
			viewMain.getCurrentContentPanel().removeAll();
			viewCalendar = new ViewCalendar(viewMain);
			ActivityListFile alf = new ActivityListFile();
			ActivityList af = alf.load(FolderPathController.getActivitiesFolder(viewMain.getJourneyModel().getGeneralInformationModel().getFolderName()),viewMain.getJourneyModel().getGeneralInformationModel().getFolderName());
			viewCalendar.setActivityList(af);
			viewMain.getCurrentContentPanel().add(viewCalendar);
			viewMain.getCurrentContentPanel().updateUI();
		} else {
			viewActivity.set_Description("Keine Sonderzeichen eingeben !");
		}
		
		
	}

}
