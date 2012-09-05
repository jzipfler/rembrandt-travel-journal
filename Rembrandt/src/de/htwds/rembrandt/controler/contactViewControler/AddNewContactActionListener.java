package de.htwds.rembrandt.controler.contactViewControler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import de.htwds.rembrandt.view.ViewContacts;

public class AddNewContactActionListener implements ActionListener {

	private ViewContacts viewContacts;
	
	public AddNewContactActionListener( ViewContacts viewContacts ) {
		this.viewContacts = viewContacts;
	}
		
	private void loadContactDetailView() {
		
		new LoadContactDetailsActionListener( viewContacts.getViewContactDetails() ).loadContactDetails();
	}
	
	private void enableTextFields() {
		
		new EnableTextFieldsActionListener( viewContacts.getViewContactDetails() ).setTextFieldsEnabled();
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		loadContactDetailView();
		enableTextFields();
		
	}

	

}
