package de.htwds.rembrandt.controler.contactViewControler;

import java.util.ArrayList;

import de.htwds.rembrandt.model.Contact;
import de.htwds.rembrandt.view.ViewContacts;

public class LoadSelectedContactControler {

	private ViewContacts viewContacts;
	private ArrayList<Contact> selectedContact;
	private Contact tmpContact;
	
	public LoadSelectedContactControler( ViewContacts viewContacts ) {
		this.viewContacts = viewContacts;
		this.selectedContact = null;
	}
	
	protected Contact loadSelectedContact(){
		String tmpWrapperString = (String) viewContacts.getLstContacts().getSelectedValue();
		int firstNamePosition = tmpWrapperString.indexOf(Messages.getString("LoadSelectedContactControler.0")); //$NON-NLS-1$
		String lastName = tmpWrapperString.substring(0, firstNamePosition );
		String firstName = tmpWrapperString.substring( firstNamePosition + 1 );
		
		tmpContact = new Contact( firstName, lastName );
		
		getMatchedList();
		
		if ( selectedContact.contains(tmpContact) ) {
			int indexOfElement = selectedContact.indexOf(tmpContact);
			tmpContact = selectedContact.get(indexOfElement);
		}
		else
			return null;//throw new RuntimeException(); // Should not happen ( else list is broken?! )
		
		return tmpContact;
	}
	
	private void getMatchedList() {
		if ( viewContacts.getCmbCategory().getSelectedItem().toString().equals(ViewContacts.STD_CMB_CATEGORY_PRIVATE) )
			
			selectedContact = viewContacts.getParentFrame().getJourneyModel().getContactListModel().getPrivateContactList();
		else if ( viewContacts.getCmbCategory().getSelectedItem().toString().equals(ViewContacts.STD_CMB_CATEGORY_GLOBAL) )
			
			selectedContact = viewContacts.getParentFrame().getJourneyModel().getContactListModel().getGlobalContactList();
		else
			if ( viewContacts.getParentFrame().getJourneyModel().getContactListModel().getPrivateContactList().contains(tmpContact) )
				selectedContact = viewContacts.getParentFrame().getJourneyModel().getContactListModel().getPrivateContactList();
			else
				selectedContact = viewContacts.getParentFrame().getJourneyModel().getContactListModel().getGlobalContactList();
	}

}
