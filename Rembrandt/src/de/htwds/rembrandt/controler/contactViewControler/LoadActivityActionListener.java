package de.htwds.rembrandt.controler.contactViewControler;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import de.htwds.rembrandt.view.ViewActivity;
import de.htwds.rembrandt.view.ViewCalendar;
import de.htwds.rembrandt.view.ViewMain;




public class LoadActivityActionListener implements ActionListener {

	private ViewActivity viewActivity;
	private ViewCalendar viewCalendar;

	public LoadActivityActionListener( ViewActivity viewActivity, ViewCalendar viewCalendar ) {
		this.viewActivity = viewActivity;
		this.viewCalendar = viewCalendar;
	}	
	
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		viewActivity.set_Time(viewCalendar.get_time());
		viewActivity.get_editButton().setVisible(false);
		viewActivity.get_deleteButton().setVisible(false);
		viewActivity.get_abortButton().setText(Messages.getString("LoadActivityActionListener.0")); //$NON-NLS-1$
		ViewMain viewMain = viewActivity.getParentFrame();
		viewMain.getCurrentContentPanel().removeAll();
		viewMain.getCurrentContentPanel().add(viewActivity);
		viewMain.getCurrentContentPanel().updateUI();
	}

}
