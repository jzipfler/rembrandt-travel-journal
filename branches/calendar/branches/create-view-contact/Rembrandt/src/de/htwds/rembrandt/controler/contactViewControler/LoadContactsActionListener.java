package de.htwds.rembrandt.controler.contactViewControler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import de.htwds.rembrandt.view.ViewContacts;
import de.htwds.rembrandt.view.ViewMain;

public class LoadContactsActionListener implements ActionListener {

	
	private ViewContacts viewContacts;
	
	public LoadContactsActionListener( ViewContacts viewContacts ) {
		
		this.viewContacts = viewContacts;
	}	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		ViewMain viewMain = viewContacts.getParentFrame();
		viewMain.getCurrentContentPanel().removeAll();
		viewMain.getCurrentContentPanel().add(viewContacts);
		viewMain.getCurrentContentPanel().updateUI();
	}

}
