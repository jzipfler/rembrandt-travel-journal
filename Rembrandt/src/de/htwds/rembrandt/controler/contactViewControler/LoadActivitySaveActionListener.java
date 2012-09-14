
package de.htwds.rembrandt.controler.contactViewControler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import de.htwds.rembrandt.view.ViewActivity;
import de.htwds.rembrandt.model.ActivityModel;
import de.htwds.rembrandt.controler.activityController.ActivityFile;



public class LoadActivitySaveActionListener implements ActionListener {

	private ActivityModel activityModel;
	private ViewActivity viewActivity;
	private ActivityFile activityFile;
	
	public LoadActivitySaveActionListener(ViewActivity viewActivity) {
		this.viewActivity = viewActivity;
		activityModel = new ActivityModel();		
		activityFile = new ActivityFile();
	}	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Speichern..........");
		activityModel.set_titel(viewActivity.get_Description());
		activityModel.set_time(viewActivity.get_Time());
		activityModel.set_location(viewActivity.get_Location());
		activityModel.set_story(viewActivity.get_Story());	
		
		activityFile.save(activityModel);
	}

}
