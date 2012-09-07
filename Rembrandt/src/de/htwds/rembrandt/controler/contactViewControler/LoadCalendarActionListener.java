package de.htwds.rembrandt.controler.contactViewControler;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import de.htwds.rembrandt.view.ViewContacts;
import de.htwds.rembrandt.view.ViewMain;
import de.htwds.rembrandt.view.ViewCalendar;


public class LoadCalendarActionListener implements ActionListener {
	
/**	//private ViewMain viewMain;
	private ViewMain viewMain;
	private ViewCalendar viewCalendar ;
	
	public LoadCalendarActionListener(ViewMain viewMain){
		this.viewMain = viewMain;
		this.viewCalendar = new ViewCalendar();
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		viewMain.getCurrentContentPanel().removeAll();
		viewMain.getCurrentContentPanel().add(viewCalendar);
		viewMain.getCurrentContentPanel().updateUI();
	}*/
	private ViewCalendar viewCalendar;
	
	public LoadCalendarActionListener(ViewMain viewMain ) {
		
		this.viewCalendar = new ViewCalendar( viewMain );
	}	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		ViewMain viewMain = viewCalendar.getParentFrame();
		viewMain.getCurrentContentPanel().removeAll();
		viewMain.getCurrentContentPanel().add(viewCalendar);
		viewCalendar.updateUI();
	}
}
