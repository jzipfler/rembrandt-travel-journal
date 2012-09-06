package de.htwds.rembrandt.controler.contactViewControler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import de.htwds.rembrandt.view.ViewContactDetails;
import de.htwds.rembrandt.view.ViewContacts;
import de.htwds.rembrandt.view.ViewMain;

public class LoadContactsActionListener implements ActionListener {

	
	private ViewContacts viewContacts;
	
	public LoadContactsActionListener( ViewContacts viewContacts ) {
		
		this.viewContacts = viewContacts;
	}	
	
	private int decideChangeOrNot(){
		ViewContactDetails viewContactDetails = viewContacts.getViewContactDetails();
		if ( viewContactDetails.getBtnUnlock().getText() == viewContactDetails.STD_BUTTON_UNLOCK_LOCK )
			return -1;
		return 0;
	}
	
	private void performChange(){
		ViewMain viewMain = viewContacts.getParentFrame();
		viewMain.getCurrentContentPanel().removeAll();
		viewMain.getCurrentContentPanel().add(viewContacts);
		viewMain.getCurrentContentPanel().updateUI();
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		if ( decideChangeOrNot() == 0 )
			performChange();
	}

}