package de.htwds.rembrandt.controler.contactViewControler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import de.htwds.rembrandt.model.Contact;
import de.htwds.rembrandt.view.ViewContacts;

public class RemoveSelectedContactActionListener implements ActionListener {

	private static final String MSG_YES_DELETE = "Ja, löschen";
	private static final String MSG_NOT_DELETE = "Nein, nicht löschen";
	private static final String MSG_SURE_TO_DELETE_TITLE = "Löschen des Kontakts";
	private static final String MSG_SURE_TO_DELETE_CONTACT = "Sie versuchen gerade einen Kontakt zu löschen.\n" +
																"Sind Sie sicher, dass Sie den Kontakt löschen möchten?\n" +
																"\n" +
																"Der Kontakt kann nach dem löschen nicht wiederhergestellt werden.";
	
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
	
	private int areYouSureToDelte() {
		
		Object[] options = {	MSG_YES_DELETE,
								MSG_NOT_DELETE };

		return JOptionPane.showOptionDialog(	null,
						MSG_SURE_TO_DELETE_CONTACT,
						MSG_SURE_TO_DELETE_TITLE,
						JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE,
						null,     		//do not use a custom Icon
						options,  		//the titles of buttons
						options[0]);	//default button title


	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		int areYouSureValue = areYouSureToDelte();
		if ( areYouSureValue == JOptionPane.YES_OPTION ) {
			removeSelected();
			new UpdateListControler(viewContacts).updateList();
			viewContacts.updateUI();
		}

	}

}
