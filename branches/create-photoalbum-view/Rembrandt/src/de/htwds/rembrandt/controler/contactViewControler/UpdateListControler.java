package de.htwds.rembrandt.controler.contactViewControler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import de.htwds.rembrandt.model.Contact;
import de.htwds.rembrandt.view.ViewContacts;

public class UpdateListControler {

	private ViewContacts viewContacts;
	private Object[] contactListElementArray;
	
	public UpdateListControler( ViewContacts viewContacts ) {
		this.viewContacts = viewContacts;
	}
	
	public void updateList() {
		initializeArray();
		if ( contactListElementArray == null )
			refreshEmptyList();
		else {
			convertListToArray();
			sortArray();
			refreshList();
		}
	}
	
	private void initializeArray() {
		
		try {
			if ( viewContacts.getCmbCategory().getSelectedItem().toString().equals( viewContacts.STD_CMB_CATEGORY_PRIVATE ) )
				contactListElementArray 
					= new Object[ viewContacts.getParentFrame().getJourneyModel().getContactListModel().getPrivateContactList().size() ];
			else if ( viewContacts.getCmbCategory().getSelectedItem().toString().equals( viewContacts.STD_CMB_CATEGORY_GLOBAL ) )
				contactListElementArray 
				= new Object[ viewContacts.getParentFrame().getJourneyModel().getContactListModel().getGlobalContactList().size() ];
			else if ( viewContacts.getCmbCategory().getSelectedItem().toString().equals( viewContacts.STD_CMB_CATEGORY_ALL ) ) {
				int sizeOfBothLists = 0;
				if ( viewContacts.getParentFrame().getJourneyModel().getContactListModel().getPrivateContactList() != null ) 
					sizeOfBothLists
						+= viewContacts.getParentFrame().getJourneyModel().getContactListModel().getPrivateContactList().size();
				if ( viewContacts.getParentFrame().getJourneyModel().getContactListModel().getGlobalContactList() != null )
					sizeOfBothLists
						+= viewContacts.getParentFrame().getJourneyModel().getContactListModel().getGlobalContactList().size();
				
				if ( sizeOfBothLists != 0 )
					contactListElementArray = new Object[ sizeOfBothLists ];
				else
					contactListElementArray = null;
			}
			else
				contactListElementArray = null; // Should never happen
		} catch (NullPointerException nullException) {
			contactListElementArray = null;
		}
	}
	
	private void convertListToArray() {
		
		
		if ( viewContacts.getCmbCategory().getSelectedItem().toString().equals( viewContacts.STD_CMB_CATEGORY_PRIVATE ) )
			
			contactListElementArray = viewContacts.getParentFrame().getJourneyModel().getContactListModel().getPrivateContactList().toArray();
		else if ( viewContacts.getCmbCategory().getSelectedItem().toString().equals( viewContacts.STD_CMB_CATEGORY_GLOBAL ) )
			
			contactListElementArray = viewContacts.getParentFrame().getJourneyModel().getContactListModel().getGlobalContactList().toArray();
		else if ( viewContacts.getCmbCategory().getSelectedItem().toString().equals( viewContacts.STD_CMB_CATEGORY_ALL ) ) {
			
			ArrayList<Contact> mergeList;
			if ( 	viewContacts.getParentFrame().getJourneyModel().getContactListModel().getPrivateContactList() != null &&
					viewContacts.getParentFrame().getJourneyModel().getContactListModel().getGlobalContactList() != null ) {
				mergeList = viewContacts.getParentFrame().getJourneyModel().getContactListModel().getGlobalContactList();
				mergeList.addAll( viewContacts.getParentFrame().getJourneyModel().getContactListModel().getPrivateContactList() );
			
				mergeList = removeDublicatesFromArrayList( mergeList );
			}
			else if ( 	viewContacts.getParentFrame().getJourneyModel().getContactListModel().getPrivateContactList() != null && 
						viewContacts.getParentFrame().getJourneyModel().getContactListModel().getGlobalContactList() == null)
				
				mergeList = viewContacts.getParentFrame().getJourneyModel().getContactListModel().getPrivateContactList();
			
			else if ( 	viewContacts.getParentFrame().getJourneyModel().getContactListModel().getPrivateContactList() == null &&
						viewContacts.getParentFrame().getJourneyModel().getContactListModel().getGlobalContactList() != null  )
				
				mergeList = viewContacts.getParentFrame().getJourneyModel().getContactListModel().getGlobalContactList();
			
			else
				return;
			
			contactListElementArray = mergeList.toArray();
		}
		else
			; // Should never happen --> noop
		
		
//		contactListElementArray = viewContacts.getParentFrame().getJourneyModel().getContactList().toArray();

	}
	
	private ArrayList<Contact> removeDublicatesFromArrayList( ArrayList<Contact> mergeList ) {
		HashSet<Contact> hashSet = new HashSet<Contact>(mergeList);
		mergeList.clear();
		mergeList.addAll(hashSet);
		return mergeList;
	}
	
	private void sortArray() {
		if ( contactListElementArray.length > 1 )
			Arrays.sort(contactListElementArray);
	}
	
	private void refreshList() {
		
		viewContacts.getLstModelContacts().removeAllElements();
		for (Object contactListElement : contactListElementArray ) {
			viewContacts.getLstModelContacts().addElement(contactListElement.toString());
		}
		viewContacts.getLstContacts().updateUI();
	}
	
	private void refreshEmptyList() {
		viewContacts.getLstModelContacts().removeAllElements();
		viewContacts.getLstContacts().updateUI();
	}
}
