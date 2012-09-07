package de.htwds.rembrandt.controler.contactViewControler;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import de.htwds.rembrandt.view.ViewCalendar;
import de.htwds.rembrandt.view.ViewActivity;
import de.htwds.rembrandt.view.ViewContactDetails;
import de.htwds.rembrandt.view.ViewMain;




public class LoadActivityActionListener implements ActionListener {
/**
	private ViewCalendar viewCalendar;
	private ViewActivity viewActivity;
		
	public LoadActivityActionListener(ViewCalendar viewCalendar){
		this.viewCalendar = viewCalendar;
		this.viewActivity = new ViewActivity();
	}
	


	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		viewCalendar.buttonPane.setVisible(false);
		viewCalendar.removeAll();
		viewCalendar.add(viewActivity.activityPane);		
		viewCalendar.add(viewActivity.buttonPane);
		viewActivity.updateUI();
	
	}     
	*/
	private ViewActivity viewActivity;
	
	public LoadActivityActionListener( ViewActivity viewActivity ) {
		this.viewActivity = viewActivity;
	}	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {

		ViewMain viewMain = viewActivity.getParentFrame();
		viewMain.getCurrentContentPanel().removeAll();
		viewMain.getCurrentContentPanel().add(viewActivity);
		viewMain.getCurrentContentPanel().updateUI();
	}
}
