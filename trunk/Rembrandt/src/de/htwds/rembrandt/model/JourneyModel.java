package de.htwds.rembrandt.model;

import java.util.ArrayList;

/**
 * 
 * @author Jan Zipfler
 *
 * Superclass for all model classes, needed to get the data for the rembrandt project.
 */
public class JourneyModel {
	
	private JourneyContactListsModel contactListModel;
	
	/*
	 * Your implementation here
	 */
	
	public JourneyModel() {
		contactListModel = new JourneyContactListsModel();
	}
	
	public JourneyContactListsModel getContactListModel() {
		return contactListModel;
	}
	
}
