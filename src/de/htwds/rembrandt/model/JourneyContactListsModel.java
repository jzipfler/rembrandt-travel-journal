package de.htwds.rembrandt.model;

import java.util.ArrayList;

public class JourneyContactListsModel {

	private ArrayList<Contact> privateContactList;
	private ArrayList<Contact> globalContactList;
	
	public JourneyContactListsModel() {
		setPrivateContactList( null );
		setGlobalContactList( null );
	}
	
	public ArrayList<Contact> getPrivateContactList() {
		return privateContactList;
	}

	public void setPrivateContactList(ArrayList<Contact> privateContactList) {
		this.privateContactList = privateContactList;
	}
	
	public ArrayList<Contact> getGlobalContactList() {
		return globalContactList;
	}

	public void setGlobalContactList(ArrayList<Contact> globalContactList) {
		this.globalContactList = globalContactList;
	}
}
