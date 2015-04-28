package de.htwds.rembrandt.controler.contactViewControler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import de.htwds.rembrandt.model.Contact;
import de.htwds.rembrandt.view.ViewContacts;

public class RemoveSelectedContactActionListener implements ActionListener {

	private static final String MSG_YES_DELETE = Messages.getString("RemoveSelectedContactActionListener.0"); //$NON-NLS-1$
	private static final String MSG_NOT_DELETE = Messages.getString("RemoveSelectedContactActionListener.1"); //$NON-NLS-1$
	private static final String MSG_SURE_TO_DELETE_TITLE = Messages.getString("RemoveSelectedContactActionListener.2"); //$NON-NLS-1$
	private static final String MSG_SURE_TO_DELETE_CONTACT = Messages.getString("RemoveSelectedContactActionListener.3") + //$NON-NLS-1$
																Messages.getString("RemoveSelectedContactActionListener.4") + //$NON-NLS-1$
																Messages.getString("RemoveSelectedContactActionListener.5") + //$NON-NLS-1$
																Messages.getString("RemoveSelectedContactActionListener.6"); //$NON-NLS-1$
	
	private ViewContacts viewContacts;
	
	public RemoveSelectedContactActionListener( ViewContacts viewContacts ) {
		this.viewContacts = viewContacts;
	}
	
	private void removeSelected() {
		
		ArrayList<Contact> selectedContact;
		Contact removeContact = new LoadSelectedContactControler(viewContacts).loadSelectedContact();
		
		if ( viewContacts.getCmbCategory().getSelectedItem().toString().equals(ViewContacts.STD_CMB_CATEGORY_PRIVATE) ) {
			
			selectedContact = viewContacts.getParentFrame().getJourneyModel().getContactListModel().getPrivateContactList();
			selectedContact.remove(removeContact);
			viewContacts.getParentFrame().getJourneyModel().getContactListModel().setPrivateContactList(selectedContact);
		}
		else if ( viewContacts.getCmbCategory().getSelectedItem().toString().equals(ViewContacts.STD_CMB_CATEGORY_GLOBAL) ) {
			
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
