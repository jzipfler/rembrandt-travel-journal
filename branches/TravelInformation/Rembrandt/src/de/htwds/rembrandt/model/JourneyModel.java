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
	private TravelInformationModel traavelInformation;
	
	/*
	 * Your implementation here
	 */
	
	public JourneyModel() {
		contactListModel = new JourneyContactListsModel();
	}
	
	public JourneyContactListsModel getContactListModel() {
		return contactListModel;
	}
	
	public void setTravelInformation(TravelInformationModel travelInformation){
		this.traavelInformation = travelInformation;
	}
	
	public TravelInformationModel getTravelInformation(){
		return traavelInformation;
	}
	
}
