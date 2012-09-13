package de.htwds.rembrandt.model;

import java.util.ArrayList;

/**
 * 
 * @author Jan Zipfler
 * @version (Jan Zipfler 2012-09-12 )
 *
 * Superclass for all model classes, needed to get the data for the rembrandt project.
 */
public class JourneyModel {
	
	private JourneyContactListsModel contactListModel;
	private TravelInformationModel travelInformation;
	private GeneralInformationModel generalInformation;
	private GeneralInformationModel[] generalInformationArray;
	
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
		this.travelInformation = travelInformation;
	}
	
	public TravelInformationModel getTravelInformation(){
		return travelInformation;
	}
	
	public void setGeneralInformationModel(GeneralInformationModel generalInformation){
		this.generalInformation = generalInformation;
	}
	
	public GeneralInformationModel getGeneralInformationModel(){
		return generalInformation;
	}
	
	public GeneralInformationModel[] getGeneralInformationArray() {
		return generalInformationArray;
	}
	
	public void setGeneralInformationModelArray( GeneralInformationModel[] generalInformationArray ) {
		this.generalInformationArray = generalInformationArray;
	}
}
