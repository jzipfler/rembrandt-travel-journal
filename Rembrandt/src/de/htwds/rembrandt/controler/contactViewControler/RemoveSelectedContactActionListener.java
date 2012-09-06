package de.htwds.rembrandt.controler.contactViewControler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import de.htwds.rembrandt.model.Contact;
import de.htwds.rembrandt.view.ViewContacts;

public class RemoveSelectedContactActionListener implements ActionListener {

	private ViewContacts viewContacts;
	
	public RemoveSelectedContactActionListener( ViewContacts viewContacts ) {
		this.viewContacts = viewContacts;
	}
	
	private void removeSelected() {
		
		ArrayList<Contact> selectedContact;
		Contact removeContact = new LoadSelectedContactControler(viewContacts).loadSelectedContact();
		
		if ( viewContacts.getCmbCategory().getSelectedItem().toString().equals(viewContacts.STD_CMB_CATEGORY_PRIVATE) ) {
			
			selectedContact = viewContacts.getParentFrame().getJourneyModel().getContactListModel().getPrivateContactList();
			selectedContact.remove(removeContact);
			viewContacts.getParentFrame().getJourneyModel().getContactListModel().setPrivateContactList(selectedContact);
		}
		else if ( viewContacts.getCmbCategory().getSelectedItem().toString().equals(viewContacts.STD_CMB_CATEGORY_GLOBAL) ) {
			
			selectedContact = viewContacts.getParentFrame().getJourneyModel().getContactListModel().getGlobalContactList();
			selectedContact.remove(removeContact);
			viewContacts.getParentFrame().getJourneyModel().getContactListModel().setGlobalContactList(selectedContact);
		}
		else {
			
			ArrayList<Contact> otherContact;
			selectedContact = viewContacts.getParentFrame().getJourneyModel().getContactListModel().getPrivateContactList();
			otherContact = viewContacts.getParentFrame().getJourneyModel().getContactListModel().getGlobalContactList();
			if ( selectedContact != null && otherContact != null )
				if ( otherContact.contains(removeContact) && selectedContact.contains(removeContact)){
					otherContact.remove(removeContact);
					selectedContact.remove(removeContact);
					viewContacts.getParentFrame().getJourneyModel().getContactListModel().setPrivateContactList(otherContact);
					viewContacts.getParentFrame().getJourneyModel().getContactListModel().setGlobalContactList(selectedContact);
				}
				else if ( otherContact.contains(removeContact) && !selectedContact.contains(removeContact) ) {
					otherContact.remove(removeContact);
					viewContacts.getParentFrame().getJourneyModel().getContactListModel().setPrivateContactList(otherContact);
				}
				else if ( otherContact.contains(removeContact) && !selectedContact.contains(removeContact) ) {
					selectedContact.remove(removeContact);
					viewContacts.getParentFrame().getJourneyModel().getContactListModel().setGlobalContactList(selectedContact);
				}
				else
					return;
			else if ( selectedContact == null && otherContact != null ) {
				otherContact.remove(removeContact);
				viewContacts.getParentFrame().getJourneyModel().getContactListModel().setPrivateContactList(otherContact);
			}
			if ( selectedContact != null && otherContact == null ) {
				selectedContact.remove(removeContact);
				viewContacts.getParentFrame().getJourneyModel().getContactListModel().setGlobalContactList(selectedContact);
			}
			else
				return;
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		
		removeSelected();
		new UpdateListControler(viewContacts).updateList();
		viewContacts.updateUI();

	}

}
