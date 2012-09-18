
package de.htwds.rembrandt.controler.contactViewControler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import de.htwds.rembrandt.view.ViewCalendar;
import de.htwds.rembrandt.view.ViewMain;


public class LoadActivityAbortActionListener implements ActionListener {


	private ViewCalendar viewCalendar;
	
	public LoadActivityAbortActionListener(ViewCalendar viewCalendar ) {
		
		this.viewCalendar = viewCalendar;
	}	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		ViewMain viewMain = viewCalendar.getParentFrame();
		viewMain.getCurrentContentPanel().removeAll();
		viewMain.getCurrentContentPanel().add(viewCalendar);
		viewMain.getCurrentContentPanel().updateUI();
	}

}
