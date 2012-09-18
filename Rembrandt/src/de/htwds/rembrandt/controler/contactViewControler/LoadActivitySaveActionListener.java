
package de.htwds.rembrandt.controler.contactViewControler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import de.htwds.rembrandt.view.ViewActivity;
import de.htwds.rembrandt.model.ActivityModel;
import de.htwds.rembrandt.model.JourneyModel;
import de.htwds.rembrandt.controler.activityController.ActivityFile;
import de.htwds.rembrandt.controler.datastructure.FolderPathController;




public class LoadActivitySaveActionListener implements ActionListener {

	private ActivityModel activityModel;
	private ViewActivity viewActivity;
	private ActivityFile activityFile;
	private	JourneyModel journeyModel;

	
	public LoadActivitySaveActionListener(ViewActivity viewActivity,  JourneyModel journeyModel) {
		this.viewActivity = viewActivity;
		this.journeyModel = journeyModel;
		activityModel = new ActivityModel();		
		activityFile = new ActivityFile();
	}	
	
	@Override
	public void actionPerformed(ActionEvent e) {
	
		
		activityModel.set_titel(viewActivity.get_Description());	
		activityModel.set_time(viewActivity.get_Time());
		activityModel.set_location(viewActivity.get_Location());
		activityModel.set_story(viewActivity.get_Story());	
		journeyModel.getTravelInformation().getActivityList().addActivity(activityModel);
		activityFile.save(activityModel, FolderPathController.getActivitiesFolder(journeyModel.getGeneralInformationModel().getFolderName()));
		
		//System.out.println(journeyModel.getTravelInformation().getActivityList().getActivityName(1));
		System.out.println(journeyModel.getTravelInformation().getActivityList().getCounter());
		
		//TEST
		for (int i=0; i < journeyModel.getTravelInformation().getActivityList().getCounter(); i++){
			System.out.println("" + i + " : \n" +journeyModel.getTravelInformation().getActivityList().getActivityName(i));
		}
		System.out.println("Speichern..........");
		
	}

}
