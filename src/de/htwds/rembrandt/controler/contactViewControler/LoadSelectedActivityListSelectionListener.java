package de.htwds.rembrandt.controler.contactViewControler;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import de.htwds.rembrandt.controler.activityController.ActivityFile;
import de.htwds.rembrandt.controler.datastructure.FolderPathController;
import de.htwds.rembrandt.model.ActivityModel;
import de.htwds.rembrandt.view.ViewActivity;
import de.htwds.rembrandt.view.ViewCalendar;
import de.htwds.rembrandt.view.ViewMain;

public class LoadSelectedActivityListSelectionListener implements ListSelectionListener  {


		private boolean status = false;
		private ViewCalendar viewCalendar;
		private ViewActivity viewActivity;
		
		public LoadSelectedActivityListSelectionListener( ViewCalendar viewCalendar ) {
			this.viewCalendar = viewCalendar;
		}
		
		
		@Override
		public void valueChanged(ListSelectionEvent e) {
			
			if ( viewCalendar.getList().isSelectionEmpty() )

				noValueSelected();
			else
				
				valueSelected();
			
			
		}
		
		
	
		
		public void noValueSelected(){
			
		}
		
		
		
		public void valueSelected(){
			if (status & viewCalendar.getList().getSelectedValue() != null){
				viewActivity = new ViewActivity(viewCalendar.getParentFrame(), viewCalendar);
				ActivityFile af = new ActivityFile();
				ActivityModel am = af.load(FolderPathController.getActivitiesFolder(viewCalendar.getParentFrame().getJourneyModel().getGeneralInformationModel().getFolderName()) ,viewCalendar.getList().getSelectedValue().toString());
				if ( am != null){
					viewActivity.set_Description(am.get_titel());
					viewActivity.set_Time(am.get_time());
					viewActivity.set_Location(am.get_location());
					viewActivity.set_Story(am.get_story());
		 		}
				viewActivity.get_saveButton().setVisible(false);
				viewActivity.get_descriptionField().setEditable(false);
				viewActivity.get_timeField().setEditable(false);
				viewActivity.get_locationField().setEditable(false);
				viewActivity.get_storyArea().setEditable(false);
				ViewMain viewMain = viewActivity.getParentFrame();
				viewMain.getCurrentContentPanel().removeAll();
				viewMain.getCurrentContentPanel().add(viewActivity);
				viewMain.getCurrentContentPanel().updateUI();	 	
				status = false;
			} else if (!status) {
				status = true;
			}
		}
		
		

}
