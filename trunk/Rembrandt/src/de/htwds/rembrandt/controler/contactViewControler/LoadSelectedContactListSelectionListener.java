package de.htwds.rembrandt.controler.contactViewControler;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import de.htwds.rembrandt.model.Contact;
import de.htwds.rembrandt.view.ViewContacts;

public class LoadSelectedContactListSelectionListener implements ListSelectionListener {

	private ViewContacts viewContacts;
	
	public LoadSelectedContactListSelectionListener( ViewContacts viewContacts ) {
		this.viewContacts = viewContacts;
	}
	
	private void noValueSelected() {
		
		viewContacts.getBtnDeleteContact().setEnabled(false);
		viewContacts.getBtnEditContact().setEnabled(false);
		clearContactTextFields();
	}
	
	private void valueSelected() {
		Contact tmpContact = new LoadSelectedContactControler(viewContacts).loadSelectedContact();
		if ( tmpContact == null ) 
			noValueSelected();
		else {
			
			fillContactTextFields( tmpContact );
		
			viewContacts.getBtnDeleteContact().setEnabled(true);
			viewContacts.getBtnEditContact().setEnabled(true);
		}
	}

	private void clearContactTextFields() {
		viewContacts.getTxtName().setText(null);
		viewContacts.getTxtMail().setText(null);
		viewContacts.getTxtPhone().setText(null);
		viewContacts.getTxtAreaDescription().setText(null);
	}
	
	private void fillContactTextFields( Contact tmpContact) {
		
		viewContacts.getTxtName().setText( tmpContact.toString() );
		viewContacts.getTxtMail().setText( tmpContact.getPrivatMail() );
		viewContacts.getTxtPhone().setText( tmpContact.getPrivatPhone() );
		/*
		if ( tmpContact.getPrivatPhone() == 0 )
			viewContacts.getTxtPhone().setText( null );
		else {
			Integer wrapper = tmpContact.getPrivatPhone();
			viewContacts.getTxtPhone().setText( wrapper.toString() );
		}
		*/
		viewContacts.getTxtAreaDescription().setText( tmpContact.getNotices() );
	}
	
	@Override
	public void valueChanged(ListSelectionEvent e) {

		if ( viewContacts.getLstContacts().isSelectionEmpty() )

			noValueSelected();
		else
			
			valueSelected();
		
	}
	
	
}